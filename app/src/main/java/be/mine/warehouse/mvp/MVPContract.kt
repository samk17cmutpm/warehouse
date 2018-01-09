package be.mine.warehouse.mvp

import be.mine.warehouse.base.BasePresenter
import be.mine.warehouse.base.BaseView
import be.mine.warehouse.model.Post

/**
 * Created by sam_nguyen on 1/5/18.
 */
interface MVPContract {

    interface View : BaseView {
        fun showPost(posts: List<Post>)
    }

    interface Presenter : BasePresenter<View> {
        fun fetchPost()
    }

}