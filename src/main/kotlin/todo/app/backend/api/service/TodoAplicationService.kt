package todo.app.backend.api.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.domain.TodoService
import todo.app.backend.api.presentation.request.TodoForm
import todo.app.backend.api.presentation.responce.ApiResponceTodoIndex

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
        todoRepository.register(todoForm)
    }

    @Suppress("SENSELESS_COMPARISON", "FoldInitializerAndIfToElvis")
    @Transactional
    fun edit(todoId: Long, todoForm: TodoForm) {
        val editTodo = todoService.findTodo(todoId.toString())
        if (editTodo == null) throw Error("存在しないtodo idです")
        todoRepository.edit(todoId.toString(), todoForm)
    }

    @Suppress("SENSELESS_COMPARISON", "FoldInitializerAndIfToElvis")
    fun delete(todoId: Long){
        val editTodo = todoService.findTodo(todoId.toString())
        if (editTodo == null) throw Error("存在しないtodo idです")
        todoRepository.delete(todoId.toString())
    }
}