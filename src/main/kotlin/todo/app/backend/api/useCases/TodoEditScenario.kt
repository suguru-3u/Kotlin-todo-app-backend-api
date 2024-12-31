package todo.app.backend.api.useCases

import jdk.jfr.Category
import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.entities.Todo
import todo.app.backend.api.domain.service.ExistTodoService
import todo.app.backend.api.domain.service.TodoFactory
import todo.app.backend.api.domain.valueObjects.TodoKind
import todo.app.backend.api.domain.valueObjects.TodoTitle
import todo.app.backend.api.presentation.todo.EditTodoRequest


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