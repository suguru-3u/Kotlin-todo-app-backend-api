package todo.app.backend.api.useCases

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.service.TodoService
import todo.app.backend.api.presentation.todo.AddTodoRequest
import todo.app.backend.api.presentation.todo.EditTodoRequest


@Service
class TodoEditScenario(
    val todoService: TodoService,
    val todoRepository: IFTodoRepository
) {

    fun execute(todoId: Long, editTodoRequest: EditTodoRequest) {
        if (todoService.exist(todoId)) throw Error("存在しないtodo idです")
        todoRepository.edit(todoId.toString(), editTodoRequest)
    }
}