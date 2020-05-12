package inn.mroyek.mysimplemvvm.presentation

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import inn.mroyek.mysimplemvvm.R
import inn.mroyek.mysimplemvvm.model.Post
import kotlinx.android.synthetic.main.item.view.*

class PostAdapter (private val post: Post) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvTitle.text = post.title
            tvBody.text = post.body
        }
    }

    override fun getLayout(): Int  = R.layout.item

}