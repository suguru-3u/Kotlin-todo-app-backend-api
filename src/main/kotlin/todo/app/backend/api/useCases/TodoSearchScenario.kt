package todo.app.backend.api.useCases

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.presentation.todo.SearchTodosResponse


@Service
class TodoSearchScenario(
    val todoRepository: IFTodoRepository
) {

    fun execute(): SearchTodosResponse {
        val result = todoRepository.search()
        return SearchTodosResponse(
            todoList = result
        )
    }
}