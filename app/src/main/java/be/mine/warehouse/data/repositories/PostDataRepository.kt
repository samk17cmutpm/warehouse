package be.mine.warehouse.data.repositories

import be.mine.warehouse.data.net.RestApi
import be.mine.warehouse.data.net.ServiceGenerator
import be.mine.warehouse.domain.repositories.PostRepository
import be.mine.warehouse.model.Post
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/9/18.
 */
class PostDataRepository : PostRepository {

    val mRestApi = ServiceGenerator.createService(RestApi::class.java)

    override fun fetchPost(): Observable<Response<List<Post>>> {
        return mRestApi.fetchPost()
    }
}