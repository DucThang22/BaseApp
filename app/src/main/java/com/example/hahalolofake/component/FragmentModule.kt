package com.example.hahalolofake.component

import androidx.paging.ExperimentalPagingApi
import com.example.hahalolofake.ui.home.HomeFr
import com.example.hahalolofake.ui.setting.SettingFr
import dagger.Module
import dagger.android.ContributesAndroidInjector

@ExperimentalPagingApi
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeFr(): HomeFr

    @ContributesAndroidInjector
    abstract fun contributeSettingFr(): SettingFr



}