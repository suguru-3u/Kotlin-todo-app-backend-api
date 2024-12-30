package todo.app.backend.api.domain.valueObjects

enum class Category(value: String) {
    NORMAL("normal"),
    IMPORTANT("important"),
    EMERGENCY("emergency");

    companion object {
        fun findCategory(value: String): Category {
            return Category.entries.find { it.name.lowercase() == value }
                ?: throw Error("不正な値がCategoryクラスにリクエストされました")
        }
    }
}


