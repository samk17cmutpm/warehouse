package be.mine.warehouse.mvp

import be.mine.warehouse.base.BasePresenter
import be.mine.warehouse.base.BaseView

/**
 * Created by sam_nguyen on 1/5/18.
 */
interface MVPContract {

    interface View : BaseView {
        fun showData()
    }

    interface Presenter : BasePresenter<View> {
        fun fetchData()
    }

}