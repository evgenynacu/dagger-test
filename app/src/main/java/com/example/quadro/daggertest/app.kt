package com.example.quadro.daggertest

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Named
import javax.inject.Singleton

class MyApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    InjectorModule::class
])
interface AppComponent : AndroidInjector<MyApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApp>()
}

@Suppress("unused")
@Module
abstract class InjectorModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}

@Module
class AppModule {

    @Provides
    @Singleton
    @Named("test")
    fun getString2() = "This is test2"
}
