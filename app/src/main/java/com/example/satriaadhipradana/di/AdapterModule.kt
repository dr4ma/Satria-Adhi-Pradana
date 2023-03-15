package com.example.satriaadhipradana.di

import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.MainAdapter
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.delegates.CategoriesAdapterDelegate
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.delegates.FlashSaleAdapterDelegate
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.delegates.LatestAdapterDelegate
import com.example.satriaadhipradana.presentation.fragments.details.MainPageAdapter
import com.example.satriaadhipradana.presentation.fragments.page1.SearchAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    fun provideMainAdapter(
        latestAdapterDelegate : LatestAdapterDelegate,
        flashSaleAdapterDelegate: FlashSaleAdapterDelegate,
        categoriesAdapterDelegate: CategoriesAdapterDelegate
    ): MainAdapter {
        return MainAdapter(
            latestAdapterDelegate = latestAdapterDelegate,
            flashSaleAdapterDelegate = flashSaleAdapterDelegate,
            categoriesAdapterDelegate = categoriesAdapterDelegate
        )
    }

    @Provides
    @Singleton
    fun provideLatestDelegate(): LatestAdapterDelegate {
        return LatestAdapterDelegate()
    }

    @Provides
    @Singleton
    fun provideFlashSalesDelegate(): FlashSaleAdapterDelegate {
        return FlashSaleAdapterDelegate()
    }

    @Provides
    @Singleton
    fun provideCategoriesDelegate(): CategoriesAdapterDelegate {
        return CategoriesAdapterDelegate()
    }

    @Provides
    @Singleton
    fun provideSearchAdapter(): SearchAdapter {
        return SearchAdapter()
    }

    @Provides
    @Singleton
    fun provideMainPageAdapter(): MainPageAdapter {
        return MainPageAdapter()
    }
}