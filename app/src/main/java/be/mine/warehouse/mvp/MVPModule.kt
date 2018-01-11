package be.mine.warehouse.mvp

import be.mine.warehouse.data.repositories.PostDataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Module
class MVPModule constructor() {

    @Provides
    @Singleton
    fun providesMVPPresenter(postDataRepository: PostDataRepository) : MVPContract.Presenter {
        return MVPPresenter(postDataRepository)
    }

}