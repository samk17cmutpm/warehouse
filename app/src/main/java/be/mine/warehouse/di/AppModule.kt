package be.mine.warehouse.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/9/18.
 */
@Module
class AppModule constructor(var mApplication: Application) {
    @Provides
    @Singleton
    fun providesApplication() : Application {
        return mApplication
    }
}