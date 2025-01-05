package todo.app.backend.api.domain.valueObjects

class CategoryName(val value: String) {
    private val MAXLENGTH: Int = 100

    init {
        val isEmpty = value.isEmpty()
        val isLength = value.length > MAXLENGTH
        if(isEmpty || isLength) throw Error("カテゴリ名で不正な値を検知しました")
    }
}