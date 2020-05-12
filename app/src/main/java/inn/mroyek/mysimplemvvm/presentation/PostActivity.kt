package inn.mroyek.mysimplemvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

import inn.mroyek.mysimplemvvm.R
import inn.mroyek.mysimplemvvm.di.injector
import inn.mroyek.mysimplemvvm.model.Post
import inn.mroyek.mysimplemvvm.utils.toast
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    private val viewModel: PostViewModel by lazy {
        @Suppress("DEPRECATION")
        ViewModelProviders.of(this, injector.postViewModelFactory())
            .get(PostViewModel::class.java)
    }

    private val postAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        initView()

        if (savedInstanceState == null) viewModel.loadPost()

        observePostState()
    }

    private fun observePostState() {
        viewModel.postState.observe(this, Observer { state ->
            when(state) {
                is OnLoadPostState -> funOnloadPost(state.postList)
                is OnErrorState -> funOnError(state.t)
            }
        })
    }

    private fun funOnloadPost(postList: List<Post>) {
        postAdapter.clear()
        postList.forEach {
            postAdapter.add(PostAdapter(it))
        }
        postAdapter.notifyDataSetChanged()
    }

    private fun funOnError(throwable: Throwable) {
        toast(throwable.localizedMessage)
    }

    private fun initView() {
        rv_post.apply {
            layoutManager = LinearLayoutManager(this@PostActivity)
            adapter = postAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.dispose()
    }
}
