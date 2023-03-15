package com.example.satriaadhipradana.di

import com.example.domain.repository.DetailsRepository
import com.example.domain.repository.Page1Repository
import com.example.domain.repository.UserRepository
import com.example.domain.usecases.DetailsUseCase
import com.example.domain.usecases.Page1UseCase
import com.example.domain.usecases.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideUserUseCase(repository: UserRepository): UserUseCase {
        return UserUseCase(userRepository = repository)
    }

    @Provides
    fun providePage1UseCase(repository: Page1Repository): Page1UseCase{
        return Page1UseCase(page1Repository = repository)
    }

    @Provides
    fun provideDetailsUseCase(repository: DetailsRepository): DetailsUseCase{
        return DetailsUseCase(detailsRepository = repository)
    }
}