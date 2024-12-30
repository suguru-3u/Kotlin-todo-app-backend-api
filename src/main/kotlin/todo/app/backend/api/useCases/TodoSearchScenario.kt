package todo.app.backend.api.useCases

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.presentation.todo.ApiResponceTodoIndex


@Service
class TodoSearchScenario(
    val todoRepository: IFTodoRepository
) {

    fun index(): ApiResponceTodoIndex {
        val result = todoRepository.index()
        return ApiResponceTodoIndex(
            todoList = result
        )
    }
}