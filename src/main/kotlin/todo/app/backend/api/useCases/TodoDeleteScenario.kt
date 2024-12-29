import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.Category
import todo.app.backend.api.domain.Todo
import todo.app.backend.api.domain.TodoService
import todo.app.backend.api.presentation.todo.TodoForm


@Service
class TodoDeleteScenario(
    val todoService: TodoService,
    val todoRepository: IFTodoRepository
) {

    fun delete(todoId: Long) {
        if (todoService.exist(todoId.toString())) throw Error("存在しないtodo idです")
        todoRepository.delete(todoId.toString())
    }
}