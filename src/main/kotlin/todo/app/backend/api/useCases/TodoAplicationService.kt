package todo.app.backend.api.useCases

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.Category
import todo.app.backend.api.domain.Todo
import todo.app.backend.api.domain.TodoService
import todo.app.backend.api.presentation.todo.TodoForm
import todo.app.backend.api.presentation.todo.ApiResponceTodoIndex

@Service
class TodoApplicationService(
    val todoService: TodoService,
    val todoRepository: IFTodoRepository
) {

    fun index(): ApiResponceTodoIndex {
        val result = todoRepository.index()
        return ApiResponceTodoIndex(
            todoList = result
        )
    }

    fun register(todoForm: TodoForm) {
        val category = Category.findCategory(todoForm.category)
        val todo = Todo(title = todoForm.title, category = category)
        todoRepository.register(todo)
    }

    fun edit(todoId: Long, todoForm: TodoForm) {
        if (todoService.exist(todoId.toString())) throw Error("存在しないtodo idです")
        todoRepository.edit(todoId.toString(), todoForm)
    }

    fun delete(todoId: Long) {
        if (todoService.exist(todoId.toString())) throw Error("存在しないtodo idです")
        todoRepository.delete(todoId.toString())
    }
}