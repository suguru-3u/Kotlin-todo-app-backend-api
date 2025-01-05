package todo.app.backend.api.useCases.todo

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.service.TodoFactory
import todo.app.backend.api.presentation.todo.request.AddTodoRequest


@Service
class TodoAddScenario(
    val todoFactory : TodoFactory,
    val todoRepository: IFTodoRepository
) {
    fun execute(addTodoRequest: AddTodoRequest) {
        val todo = todoFactory.execute(addTodoRequest)
        todoRepository.add(todo)
    }
}