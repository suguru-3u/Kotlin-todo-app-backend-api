package todo.app.backend.api.useCases.todo

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.service.ExistTodoService
import todo.app.backend.api.domain.service.TodoFactory
import todo.app.backend.api.presentation.todo.request.EditTodoRequest


@Service
class TodoEditScenario(
    val existTodoService: ExistTodoService,
    val todoFactory : TodoFactory,
    val todoRepository: IFTodoRepository
) {

    fun execute(todoId: Long, editTodoRequest: EditTodoRequest) {
        if (existTodoService.execute(todoId)) throw Error("存在しないtodo idです")
        val todo = todoFactory.execute(editTodoRequest)
        todoRepository.edit(todoId.toString(), todo)
    }
}