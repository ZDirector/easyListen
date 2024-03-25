package com.example.homepage.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.common.constants.HttpConstants
import com.example.common.utils.MyApplication
import com.example.homepage.R
import com.example.homepage.agreement.ClickCallBack
import com.example.homepage.agreement.TermServiceDialogFragment
import permissions.dispatcher.PermissionUtils
import java.lang.Thread.sleep


class SplashActivity : AppCompatActivity() {
    private val firstDialog: TermServiceDialogFragment  = TermServiceDialogFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "abc", Toast.LENGTH_SHORT).show()
        //隐层状态栏和标题栏
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //隐藏标题栏
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        initAgreementService()
    }

    /**
     * 初始化第一次启动的时候弹窗的服务与协议
     */
    private fun initAgreementService() {
        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        firstDialog.setCallBack(object : ClickCallBack {
            override fun cancel() {
                MyApplication.instance.get()?.activityLifeCycle?.closeAll()
            }

            override fun confirm() {
                editor.putBoolean("is_first_open",false)
                editor.apply()
                initSplash()
                initPermission()
            }
        })

        if (prefs.getBoolean("is_first_open",true)){
            firstDialog.isCancelable=false
            firstDialog.showNow(supportFragmentManager,"firstDialog")
        }
        if (!prefs.getBoolean("is_first_open",true)){
            initSplash()
        }
    }

    /**
     * 初始化启动页
     */
    private fun initSplash(){
        Thread{
            try {
                val cookie = getCookie()
                val intent: Intent = if (cookie.isEmpty()) {
                    Intent(applicationContext, LoginActivity::class.java)
                } else {
                    HttpConstants.COOKIE = cookie
                    Intent(applicationContext, HomeActivity::class.java)
                }
                sleep(3000)
                startActivity(intent)
                finish()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }.start()
    }

    private fun getCookie(): String {
        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        return prefs.getString("cookie", "").toString()
    }

    /**
     * 初始化权限申请
     */
    private fun initPermission() {

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_SETTINGS
            ),
            1
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Log.e(
            "requestCode = $requestCode",
            " per = ${permissions[0]} ；grantResults = $grantResults"
        )

        if (requestCode == 1) {

            when (permissions[0]) {

                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.WRITE_SETTINGS -> {
                    Log.e("回调", "读写")

                    if (PermissionUtils.verifyPermissions(*grantResults)) {
                        Log.e("回调", "读写授权成功")
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_SETTINGS,
                                Manifest.permission.READ_EXTERNAL_STORAGE
                            ),
                            1
                        );
                    } else {
                        Log.e("回调", "读写授权失败")
                    }
                }
                Manifest.permission.CAMERA -> {
                    Log.e("回调", "相册")
                    if (PermissionUtils.verifyPermissions(*grantResults)) {
                        Log.e("回调", "相册授权成功")
                    } else {
                        Log.e("回调", "相册授权失败")
                    }
                }
            }
        }

    }


}