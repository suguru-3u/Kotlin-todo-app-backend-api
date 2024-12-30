package todo.app.backend.api.presentation.todo

import todo.app.backend.api.domain.entities.Todo

data class SearchTodosResponse(
    val todoList: List<Todo>
)
