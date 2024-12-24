package todo.app.backend.api.presentation.responce

import todo.app.backend.api.domain.Todo

data class ApiResponceTodoIndex(
    val todoList: List<Todo>
)
