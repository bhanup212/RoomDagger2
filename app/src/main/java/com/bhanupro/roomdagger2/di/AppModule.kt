package com.bhanupro.roomdagger2.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(application: Application) {
    private val app:Application = application

    @Singleton
    @Provides
    fun providesApplication():Application{
        return app
    }
}