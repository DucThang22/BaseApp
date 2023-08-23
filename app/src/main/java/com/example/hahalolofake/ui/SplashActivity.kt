package com.example.hahalolofake.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.hahalolofake.databinding.ActivitySplashBinding
import com.example.hahalolofake.utils.SystemUtil

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUtil.setPreLanguage(this,SystemUtil.getPreLanguage(this))
        SystemUtil.setLocale(this)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        MobileAds.initialize(this) {}
//        binding.imgLaunch.postDelayed({
//            SystemUtil.setPreLanguage(this,SystemUtil.getPreLanguage(this))
//            SystemUtil.setLocale(this)
//            openMainActivity()
//        }, 3000)
        hideSystemUI()
    }
    private fun restorePrefData(): Boolean {
        val pref = applicationContext.getSharedPreferences("myPref", MODE_PRIVATE)
        return pref.getBoolean("isIntroOpened",false)
    }

    private fun openMainActivity() {


    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }

    override fun onStop() {
        super.onStop()
        hideSystemUI()
    }

}