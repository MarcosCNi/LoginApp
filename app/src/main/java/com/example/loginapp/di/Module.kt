package com.example.loginapp.di

import android.content.Context
import com.example.loginapp.db.DataBaseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun providesDatabaseHelper(
        @ApplicationContext context: Context
    ) : DataBaseHelper{
        return DataBaseHelper(context, null)
    }
}