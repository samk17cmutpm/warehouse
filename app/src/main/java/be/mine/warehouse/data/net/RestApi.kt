package be.mine.warehouse.data.net

import be.mine.warehouse.model.Post
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by sam_nguyen on 1/5/18.
 */
interface RestApi {
    @GET("posts")
    fun fetchPost() : Observable<Response<List<Post>>>

    @GET("posts")
    fun getPost() : Call<List<Post>>
}