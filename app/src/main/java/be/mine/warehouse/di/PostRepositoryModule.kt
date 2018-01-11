package be.mine.warehouse.di

import be.mine.warehouse.data.repositories.PostDataRepository
import be.mine.warehouse.domain.repositories.PostRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/9/18.
 */
@Module
class PostRepositoryModule constructor() {
    @Provides
    @Singleton
    fun providesPostRepository() : PostRepository {
        return PostDataRepository()
    }
}