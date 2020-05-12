package inn.mroyek.mysimplemvvm.presentation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import inn.mroyek.mysimplemvvm.data.repository.PostRepository
import inn.mroyek.mysimplemvvm.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostViewModel @Inject constructor(private val repository: PostRepository) : ViewModel (){

    private val disposable = CompositeDisposable()

    val postState = MutableLiveData<PostState>()

    fun loadPost() {
        disposable.add(
            repository.getPost()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadPost, this::onError)
        )
    }

    private fun onLoadPost(post: List<Post>) {
        postState.value = OnLoadPostState(post)
    }
    private fun onError(throwable: Throwable) {
        postState.value = OnErrorState(throwable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun dispose() {
        if (!disposable.isDisposed) disposable.dispose()
    }
}
