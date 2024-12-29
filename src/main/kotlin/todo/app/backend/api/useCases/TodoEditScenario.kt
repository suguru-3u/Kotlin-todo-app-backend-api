import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.Category
import todo.app.backend.api.domain.Todo
import todo.app.backend.api.domain.TodoService
import todo.app.backend.api.presentation.todo.TodoForm


@Service
class TodoEditScenario(
    val todoService: TodoService,
    val todoRepository: IFTodoRepository
) {

    fun edit(todoId: Long, todoForm: TodoForm) {
        if (todoService.exist(todoId.toString())) throw Error("存在しないtodo idです")
        todoRepository.edit(todoId.toString(), todoForm)
    }
}