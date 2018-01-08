package be.mine.warehouse.mvp

import android.util.Log
import be.mine.warehouse.base.BaseConsumer
import be.mine.warehouse.model.Post
import be.mine.warehouse.net.RestApi
import be.mine.warehouse.net.ServiceGenerator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
/**
 * Created by sam_nguyen on 1/5/18.
 */
class MVPPresenter : MVPContract.Presenter {

    private lateinit var mView: MVPContract.View

    private val mRestApiService: RestApi = ServiceGenerator.createService(RestApi::class.java)

    override fun detachView() {

    }

    override fun fetchData() {
        mRestApiService.fetchPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseConsumer<List<Post>>() {
                    override fun onSuccess(data: List<Post>) {
                    }
                })
    }

    override fun attachView(view: MVPContract.View) {
        mView = view
    }
}
