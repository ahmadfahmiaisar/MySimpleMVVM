package inn.mroyek.mysimplemvvm.presentation

import inn.mroyek.mysimplemvvm.model.Post

sealed class PostState

data class OnLoadPostState(val postList: List<Post>) : PostState()

data class OnErrorState(val t: Throwable) : PostState()
