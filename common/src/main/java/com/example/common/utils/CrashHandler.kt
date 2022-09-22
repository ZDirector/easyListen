package com.example.common.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.*
import android.os.Process.killProcess
import android.os.Process.myPid
import android.text.TextUtils
import android.util.Log
import java.io.*
import java.lang.reflect.Field
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.exitProcess


/**
 * 全局捕获异常
 * 当程序发生Uncaught异常的时候,有该类来接管程序,并记录错误日志
 *
 */

class CrashHandler private constructor() : Thread.UncaughtExceptionHandler {
    private var mContext: Context? = null
    private var mDefaultHandler: Thread.UncaughtExceptionHandler? = null

    fun init(context: Context?) {
        mContext = context
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(thread: Thread, ex: Throwable) {
        // 收集设备信息、版本信息、异常信息
        val info = collectDeviceInfo(mContext, ex)
        // 本地存储
        saveInfo(info)
        Log.d(TAG, "已捕获到异常 ")

        //不进行延时处理的话kill不能执行完成
        Timer().schedule(object : TimerTask() {
            override fun run() {
                // 异常已经处理，结束进程
                killProcess(myPid())
                exitProcess(1)
            }
        }, 100)
    }

    /**
     * 收集设备信息
     *
     * @param c
     * @param ex
     */
    private fun collectDeviceInfo(c: Context?, ex: Throwable): String {
        val infos: HashMap<String, String> = HashMap()
        //收集版本信息
        try {
            val pm = c!!.packageManager
            val pi = pm.getPackageInfo(c.packageName, PackageManager.GET_ACTIVITIES)
            if (pi != null) {
                val versionCode = pi.versionCode.toString() + ""
                val versionName =
                    if (TextUtils.isEmpty(pi.versionName)) "没有版本名称" else pi.versionName
                infos["versionCode"] = versionCode
                infos["versionName"] = versionName
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        //收集设备信息
        val fields: Array<Field> = Build::class.java.declaredFields
        for (field in fields) {
            try {
                field.isAccessible = true
                infos[field.name] = field.get(null)!!.toString()
            } catch (e: Exception) {
            }
        }

        // 收集异常信息
        val writer: Writer = StringWriter()
        val printWriter = PrintWriter(writer)
        ex.printStackTrace(printWriter)
        var cause = ex.cause
        while (cause != null) {
            cause.printStackTrace(printWriter)
            cause = cause.cause
        }
        printWriter.close()
        val result = writer.toString()

        // 转化为字符串
        val sb = StringBuffer()
        for (info in infos) sb.append(info.key + "=" + info.value + "\n")
        sb.append(result)
        return sb.toString()
    }

    /**
     * 保存异常信息到本地
     * @param infos
     */
    private fun saveInfo(infos: String) {
        Log.d(TAG, "输出log日志: $infos")
        // 把采集到的信息写入到本地文件
        outToSdcard(infos)
    }

    /**
     * 保存异常信息到sdcard中
     *
     * @param errorLog
     */
    private fun outToSdcard(errorLog: String?) {
        val sdPath = Environment.getExternalStorageDirectory().path.toString() + "/error_log"
        //新建文件
        val sdCardDir = File(sdPath)
        if (!sdCardDir.exists()) {
            if (!sdCardDir.mkdirs()) {
                sdCardDir.createNewFile()
            }
        }
        val time = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .format(Date())
        val fileName = "$time.txt"
        //新建文件
        val saveFile = File(sdCardDir, fileName)
        if (!saveFile.exists()) {
            saveFile.createNewFile()
        }
        val outStream = FileOutputStream(saveFile)
        if (errorLog != null) {
            outStream.write(errorLog.toByteArray())
            outStream.close()
        }
        Log.d(TAG, "日志输出成功! ")
    }

    companion object {
        private const val TAG = "CrashHandlerTag"
        val instance : CrashHandler by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) { CrashHandler() }
    }
}