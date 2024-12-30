package todo.app.backend.api.presentation.todo

data class AddTodoRequest(
    val title: String,
    val category: String
)
