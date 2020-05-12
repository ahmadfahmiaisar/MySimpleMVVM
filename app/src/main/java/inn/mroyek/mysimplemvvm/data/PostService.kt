package inn.mroyek.mysimplemvvm.data

import inn.mroyek.mysimplemvvm.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getPosts() : Observable<List<Post>>
}