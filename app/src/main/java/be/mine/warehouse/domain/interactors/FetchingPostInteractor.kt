package be.mine.warehouse.domain.interactors

import be.mine.warehouse.domain.UseCase
import be.mine.warehouse.domain.repositories.PostRepository
import be.mine.warehouse.model.Post
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/9/18.
 */
class FetchingPostInteractor @Inject constructor(val mPostRepository: PostRepository) : UseCase<FetchingPostInteractor.RequestValues, List<Post>>() {

    override fun buildUseCaseObservable(requestValues: RequestValues): Observable<Response<List<Post>>> {
        return mPostRepository.fetchPost()
    }

    class RequestValues : UseCase.RequestValues
}