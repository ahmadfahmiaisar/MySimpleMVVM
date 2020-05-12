package inn.mroyek.mysimplemvvm.data.repository

import dagger.Reusable
import inn.mroyek.mysimplemvvm.data.PostService
import inn.mroyek.mysimplemvvm.model.Post
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class PostRepository @Inject constructor(private val service: PostService) {

    fun getPost(): Single<List<Post>> {
        return service.getPosts()
            .flatMapIterable { it }
            .map {
                Post (
                    id = it.id,
                    title = it.title,
                    body = it.body
                )
            }
            .toList()
    }
}