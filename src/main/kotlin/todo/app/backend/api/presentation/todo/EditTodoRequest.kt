package todo.app.backend.api.presentation.todo

data class EditTodoRequest(
    val title: String,
    val category: String
)
