package todo.app.backend.api.presentation.request

data class TodoForm(
    val title:String,
    val category: Int
)
