package todo.app.backend.api.useCases

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.valueObjects.Category
import todo.app.backend.api.domain.entities.Todo
import todo.app.backend.api.domain.service.TodoService
import todo.app.backend.api.presentation.todo.AddTodoRequest


@Service
class TodoAddScenario(
    val todoRepository: IFTodoRepository
) {

    fun execute(todoForm: AddTodoRequest) {
        val category = Category.findCategory(todoForm.category)
        val todo = Todo(title = todoForm.title, category = category)
        todoRepository.add(todo)
    }
}