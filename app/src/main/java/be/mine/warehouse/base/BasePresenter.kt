package be.mine.warehouse.base

/**
 * Created by sam_nguyen on 1/5/18.
 */
interface BasePresenter<V> {
    fun attachView(view: V)
    fun detachView()
}