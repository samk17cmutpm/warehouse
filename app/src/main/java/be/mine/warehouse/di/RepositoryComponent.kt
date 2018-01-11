package be.mine.warehouse.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Component(modules = arrayOf(PostRepositoryModule::class))
interface RepositoryComponent {
}