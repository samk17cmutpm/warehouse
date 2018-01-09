package be.mine.warehouse.mvp

import android.util.Log
import be.mine.warehouse.base.BaseConsumer
import be.mine.warehouse.model.Post
import be.mine.warehouse.data.repositories.PostDataRepository
import be.mine.warehouse.domain.interactors.FetchingPostInteractor

/**
 * Created by sam_nguyen on 1/5/18.
 */
class MVPPresenter constructor(val mPostRepository: PostDataRepository) : MVPContract.Presenter {

    private lateinit var mView: MVPContract.View

    private var mFetchingPostInteractor: FetchingPostInteractor

    init {
        mFetchingPostInteractor = FetchingPostInteractor(mPostRepository)
    }
    override fun detachView() {

    }

    override fun fetchPost() {
        mFetchingPostInteractor.run(object : BaseConsumer<List<Post>>() {
            override fun onSuccess(data: List<Post>) {
                showData(data)
            }
        }, FetchingPostInteractor.RequestValues())
    }

    override fun attachView(view: MVPContract.View) {
        mView = view
    }

    fun showData(posts: List<Post>) {
        Log.e("showPost", posts.size.toString())
    }
}
