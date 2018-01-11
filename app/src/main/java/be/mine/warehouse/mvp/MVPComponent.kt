package be.mine.warehouse.mvp

import be.mine.warehouse.di.PostRepositoryModule
import be.mine.warehouse.di.RepositoryComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Singleton
@Component(dependencies = arrayOf(RepositoryComponent::class), modules = arrayOf(MVPModule::class))
interface MVPComponent {
    fun inject(mvpActivity: MVPActivity)
}