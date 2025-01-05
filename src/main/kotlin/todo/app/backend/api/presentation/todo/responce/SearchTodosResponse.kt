package todo.app.backend.api.presentation.todo.responce

import todo.app.backend.api.Infrastructure.datasource.entity.TodoEntity

data class SearchTodosResponse(
    val todoList: List<TodoEntity>
)
