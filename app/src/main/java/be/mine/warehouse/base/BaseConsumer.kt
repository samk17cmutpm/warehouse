package be.mine.warehouse.base

import io.reactivex.functions.Consumer
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/8/18.
 */
abstract class BaseConsumer<T> : Consumer<Response<T>> {

    override fun accept(t: Response<T>?) {
        /**
         * When t == null => 500
         */
        if (t == null) {
            cannotConnectToServer()
            return
        }

        /**
         * Case response != null
         */
        if (t.isSuccessful) {
            onSuccess(t.body()!!)
        } else {
            onFailed(t.message())
        }
    }
    open fun cannotConnectToServer() {}
    open fun onFailed(message: String) {}
    abstract fun onSuccess(data: T)
}