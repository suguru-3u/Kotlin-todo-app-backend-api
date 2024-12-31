package todo.app.backend.api.domain.valueObjects

class TodoTitle(
    val title: String
) {
    private val MAXTITLENUM = 256

    init {
        if (title.isEmpty() &&
            title.length > MAXTITLENUM
        ) {
            throw Error("TodoTitleクラスに不正な値が渡されました")
        }
    }
}