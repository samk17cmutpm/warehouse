package be.mine.warehouse

import android.app.Application
import be.mine.warehouse.data.repositories.PostDataRepository
import be.mine.warehouse.di.DaggerRepositoryComponent
import be.mine.warehouse.di.PostRepositoryModule
import be.mine.warehouse.di.RepositoryComponent
import dagger.android.DaggerApplication

/**
 * Created by sam_nguyen on 1/9/18.
 */
class WareHouseApplication : Application() {

    private lateinit var mRepositoryComponent: RepositoryComponent

    override fun onCreate() {
        super.onCreate()
        mRepositoryComponent = DaggerRepositoryComponent.builder()
                .postRepositoryModule(PostRepositoryModule())
                .build()
    }

    fun getRepositoryComponent() : RepositoryComponent {
        return mRepositoryComponent
    }

}