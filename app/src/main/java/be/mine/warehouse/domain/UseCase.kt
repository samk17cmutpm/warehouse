package be.mine.warehouse.domain

import be.mine.warehouse.base.BaseConsumer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/9/18.
 */
abstract class UseCase<Q : UseCase.RequestValues, P> {

    val subscription: CompositeDisposable = CompositeDisposable()

    interface RequestValues {}

    abstract fun buildUseCaseObservable(requestValues: Q) : Observable<Response<P>>

    open fun run() {}

    fun run(consumer: BaseConsumer<P>, requestValues: Q) {
        val observable: Observable<Response<P>> = this.buildUseCaseObservable(requestValues)
        subscription.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer))
    }

    open fun dispose() {
        subscription.clear()
    }
}