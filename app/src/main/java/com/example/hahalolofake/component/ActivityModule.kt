package com.example.hahalolofake.component

import androidx.paging.ExperimentalPagingApi
import com.example.hahalolofake.ui.intro.IntroAct
import com.example.hahalolofake.ui.splash.SplashActivity
import com.example.hahalolofake.ui.main.MainActivity
import com.example.hahalolofake.ui.main_v2.MainActivityV2
import com.example.hahalolofake.ui.multilang.MultiLangAct
import com.example.hahalolofake.ui.permission.PermissionAct
import dagger.Module
import dagger.android.ContributesAndroidInjector


@ExperimentalPagingApi
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity
    @ContributesAndroidInjector
    abstract fun contributeMultiLangAct(): MultiLangAct

    @ContributesAndroidInjector
    abstract fun contributeIntroAct(): IntroAct

    @ContributesAndroidInjector
    abstract fun contributePermissionAct(): PermissionAct

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivityV2(): MainActivityV2
}