package todo.app.backend.api.useCases.todo

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.service.ExistTodoService


@Service
class TodoDeleteScenario(
    val existTodoService: ExistTodoService,
    val todoRepository: IFTodoRepository
) {

    fun execute(todoId: Long) {
        if (existTodoService.execute(todoId)) throw Error("存在しないtodo idです")
        todoRepository.delete(todoId.toString())
    }
}