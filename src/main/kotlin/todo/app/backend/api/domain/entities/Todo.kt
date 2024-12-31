package todo.app.backend.api.domain.entities

import todo.app.backend.api.domain.valueObjects.TodoKind
import todo.app.backend.api.domain.valueObjects.TodoTitle

data class Todo(
    val title: TodoTitle,
    val kind: TodoKind,
    val category: Int = 1
)