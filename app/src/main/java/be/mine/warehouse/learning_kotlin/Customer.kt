package be.mine.warehouse.learning_kotlin

import android.util.Log

/**
 * Created by sam_nguyen on 1/5/18.
 */
class Customer public constructor(name: String) {
    public val abc = name
    constructor(name: String, customer: Customer) : this(name) {

    }

    init {
        Log.e("Customer1", name)
    }

    init {
        Log.e("Customer2", name)
    }

    init {
        Log.e("Customer3", name)
    }
}