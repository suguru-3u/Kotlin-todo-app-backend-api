package todo.app.backend.api.presentation.todo

data class AddTodoRequest(
    override val title: String,
    override val category: Int,
    override val kind: String
) : BaseTodoRequest(
    title = title,
    kind = kind,
    category = category
)