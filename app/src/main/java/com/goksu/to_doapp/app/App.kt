package com.goksu.to_doapp.app

import android.app.Application
import android.content.Context

open class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}

val Context.app: App
    get() = applicationContext as App

//package com.goksu.to_doapp.app
//
//import android.app.Application
//import dagger.hilt.android.HiltAndroidApp
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//import com.goksu.to_doapp.data.*
//
//@HiltAndroidApp
//class App : Application()
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun provideDatabase(application: Application): AppDatabase {
//        return AppDatabase.getDatabase(application)
//    }
//
//    @Provides
//    fun provideUserDao(database: AppDatabase): UserDao {
//        return database.userDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideUserRepository(userDao: UserDao): UserRepositoryImpl {
//        return UserRepositoryImpl(userDao)
//    }
//}



