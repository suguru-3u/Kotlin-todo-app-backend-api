import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.Category
import todo.app.backend.api.domain.Todo
import todo.app.backend.api.domain.TodoService
import todo.app.backend.api.presentation.todo.ApiResponceTodoIndex
import todo.app.backend.api.presentation.todo.TodoForm


@Service
class TodoSearchScenario(
    val todoService: TodoService,
    val todoRepository: IFTodoRepository
) {

    fun index(): ApiResponceTodoIndex {
        val result = todoRepository.index()
        return ApiResponceTodoIndex(
            todoList = result
        )
    }
}