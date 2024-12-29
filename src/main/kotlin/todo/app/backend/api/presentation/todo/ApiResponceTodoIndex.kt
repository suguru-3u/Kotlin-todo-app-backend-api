package todo.app.backend.api.presentation.todo

import todo.app.backend.api.domain.Todo

data class ApiResponceTodoIndex(
    val todoList: List<Todo>
)
