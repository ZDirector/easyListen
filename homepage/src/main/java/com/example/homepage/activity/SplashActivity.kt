package com.example.homepage.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.common.utils.ExitUtils
import com.example.homepage.R
import com.example.homepage.agreement.ClickCallBack
import com.example.homepage.agreement.TermServiceDialogFragment
import permissions.dispatcher.PermissionUtils
import java.lang.Thread.sleep


class SplashActivity : AppCompatActivity() {
    private val firstDialog: TermServiceDialogFragment  = TermServiceDialogFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //隐层状态栏和标题栏
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //隐藏标题栏
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        initAgreementService()
        initPermission()
    }

    /**
     * 初始化第一次启动的时候弹窗的服务与协议
     */
    private fun initAgreementService(){
        val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
        val editor= prefs.edit()
        firstDialog.setCallBack(object : ClickCallBack {
            override fun cancel() {
                ExitUtils.exitApp()
            }

            override fun confirm() {
                editor.putBoolean("is_first_open",false)
                editor.apply()
                initSplash()
            }
        })

        if (prefs.getBoolean("is_first_open",true)){
            firstDialog.isCancelable=false
            firstDialog.showNow(supportFragmentManager,"firstDialog")
        }
    }

    /**
     * 初始化启动页
     */
    private fun initSplash(){
        Thread{
            try {
                sleep(3000)
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }.start()
    }



    /**
     * 初始化权限申请
     */
    private fun initPermission(){

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
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

                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE -> {
                    Log.e("回调", "读写")

                    if (PermissionUtils.verifyPermissions(*grantResults)) {
                        Log.e("回调", "读写授权成功")
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(
                                Manifest.permission.CAMERA
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