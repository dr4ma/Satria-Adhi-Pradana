package com.example.satriaadhipradana.di

import com.example.data.realm.UserRequests
import com.example.data.retrofit.DetailsRequest
import com.example.data.retrofit.Page1Requests
import com.example.domain.repository.DetailsRepository
import com.example.domain.repository.Page1Repository
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideUserModelRequests(realm: Realm): UserRepository {
        return UserRequests(realm = realm)
    }

    @Provides
    fun providePage1Requests() : Page1Repository{
        return Page1Requests()
    }

    @Provides
    fun provideDetailsRequests() : DetailsRepository{
        return DetailsRequest()
    }

}