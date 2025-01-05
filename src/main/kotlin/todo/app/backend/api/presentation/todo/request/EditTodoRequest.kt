package todo.app.backend.api.presentation.todo.request

data class EditTodoRequest(
    override val title: String,
    override val category: Int = 1,
    override val kind: String
) : BaseTodoRequest(
    title = title,
    kind = kind
)