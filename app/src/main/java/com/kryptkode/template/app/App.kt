package com.kryptkode.template.app

import android.app.Activity
import android.app.Service
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDexApplication
import com.kryptkode.template.app.di.application.AppComponent
import com.kryptkode.template.app.di.application.DaggerAppComponent
import timber.log.Timber

/**
 * Created by kryptkode on 2/18/2020.
 */
class App : MultiDexApplication() {


    private val coreComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        initLoggerIfDebugBuild()
    }

    private fun initLoggerIfDebugBuild() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as App).coreComponent
    }
}


fun Activity.coreComponent() = App.coreComponent(this)
fun Fragment.coreComponent() = App.coreComponent(requireContext())
fun Service.coreComponent() = App.coreComponent(this)