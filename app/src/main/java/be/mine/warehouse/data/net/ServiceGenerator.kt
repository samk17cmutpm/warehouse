package be.mine.warehouse.data.net

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by sam_nguyen on 1/5/18.
 */
class ServiceGenerator private constructor() {
    companion object {
        private val API_BASE_URL = "https://jsonplaceholder.typicode.com/"
        private val DATE_FORMAT = "yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'"
        private val TIME_OUT = 1000

        private val mGson = GsonBuilder().setDateFormat(DATE_FORMAT).create()

        private val builder = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(mGson))

        private var retrofit: Retrofit = builder.build()

        private val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        fun <S> createService(serviceClass: Class<S>) : S {
            if (!httpClient.interceptors().contains(logging)) {
                httpClient.addInterceptor(logging)
                builder.client(httpClient.build())
                retrofit = builder.build()
            }
            return retrofit.create(serviceClass)
        }
    }
}