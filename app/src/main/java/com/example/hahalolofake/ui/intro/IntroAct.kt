package com.example.hahalolofake.ui.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.hahalolofake.R
import com.example.hahalolofake.base.AbsActivity
import com.example.hahalolofake.data.models.IntroEntity
import com.example.hahalolofake.databinding.ActivityIntroBinding
import com.example.hahalolofake.ui.intro.adaper.IntroAdapter

class IntroAct : AbsActivity<ActivityIntroBinding>() {
    private lateinit var introAdapter: IntroAdapter
    var position = 0

    private val intro = listOf(
        IntroEntity(getString(R.string.title_intro_1), getString(R.string.content_intro_1), R.drawable.intro_1),
        IntroEntity(getString(R.string.title_intro_2), getString(R.string.content_intro_2), R.drawable.intro_2),
        IntroEntity(getString(R.string.title_intro_3), getString(R.string.content_intro_3), R.drawable.intro_3)
    )

    override fun initView() {
        introAdapter = IntroAdapter(intro)
        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.viewPager
        val btnStart = binding.buttonStartIntro

        viewPager.adapter = introAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if(position==0){
                    binding.buttonBackIntro.alpha= 0F
                }else{
                    binding.buttonBackIntro.alpha= 1F
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
        dotsIndicator.setViewPager2(viewPager)
    }

    override fun initAction() {
        binding.buttonStartIntro.setOnClickListener {
            position = binding.viewPager.currentItem
            if (position < intro.size) {
                position++
                binding.viewPager.currentItem = position
            }

            if (position == intro.size) {
//                startActivity(Intent(this, PermissionAct::class.java))
                finish()
            }
        }
        binding.buttonBackIntro.setOnClickListener {
            position = binding.viewPager.currentItem
            if (position < intro.size) {
                position --
                binding.viewPager.currentItem = position
            }

        }
    }

    override fun getContentView(): Int {
        return R.layout.activity_intro
    }

    override fun bindViewModel() {
        TODO("Not yet implemented")
    }


    private fun hideSystemUI() {
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                    or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                    or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }

    override fun onStop() {
        super.onStop()
        hideSystemUI()
    }
}