package com.example.themovieapp.core.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.themovieapp.constants.AppConstants
import com.example.themovieapp.data.local.IMovieDao
import com.example.themovieapp.data.local.MovieDataBase
import com.example.themovieapp.data.network.IWebServiceMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DependencyModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideServices(retrofit: Retrofit): IWebServiceMovie {
        return retrofit.create(IWebServiceMovie::class.java)
    }

    @Provides
    fun provideMovieDao(movieDatabase: MovieDataBase):IMovieDao{
        return movieDatabase.MovieDao()
    }
    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext appContex: Context): MovieDataBase {
        return Room.databaseBuilder(appContex, MovieDataBase::class.java, "MovieDataBase").build()
    }

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}