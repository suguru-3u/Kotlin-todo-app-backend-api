package todo.app.backend.api.domain.entities

import todo.app.backend.api.domain.valueObjects.Category

data class Todo(
    val title: String,
    val category: Category
) {
    init {
        if(title.isEmpty()){
            throw Error("不正な値を検知しました")
        }
    }
}