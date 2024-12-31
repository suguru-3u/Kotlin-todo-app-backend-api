package todo.app.backend.api.presentation.todo

open class BaseTodoRequest(
    open val title: String,
    open val kind: String,
    open val category: Int = 1
)