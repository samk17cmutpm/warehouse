package be.mine.warehouse.domain.repositories

import be.mine.warehouse.model.Post
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/9/18.
 */
interface PostRepository {

    /**
     * Fetching Post
     */
    fun fetchPost() : Observable<Response<List<Post>>>

}