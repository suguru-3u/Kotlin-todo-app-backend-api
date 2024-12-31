package todo.app.backend.api.domain.valueObjects

enum class TodoKind(val kindName: String) {
    NORMAL("normal"),
    IMPORTANT("important"),
    EMERGENCY("emergency");

    companion object {
        fun findCategory(value: String): TodoKind {
            return TodoKind.entries.find { it.kindName == value }
                ?: throw Error("不正な値がCategoryクラスにリクエストされました")
        }
    }
}


