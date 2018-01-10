package be.mine.warehouse.di

import be.mine.warehouse.mvp.MVPActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/9/18.
 */
@Singleton
@Component(modules = arrayOf(PostRepositoryModule::class))
interface RepositoryComponent {
    fun inject(activity: MVPActivity)
}