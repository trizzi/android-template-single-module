package com.kryptkode.template.app.di.application

import com.kryptkode.template.app.App
import com.kryptkode.template.app.di.screen.ScreenComponent
import com.kryptkode.template.app.di.screen.ScreenModule
import com.kryptkode.template.app.di.viewmodel.ViewModelFactoryModule
import com.kryptkode.template.app.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component

/**
 * Created by kryptkode on 2/19/2020.
 */

@Component(
    modules = [
        AppModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class]
)
interface AppComponent {


    fun screenComponent(screenModule: ScreenModule): ScreenComponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }
}