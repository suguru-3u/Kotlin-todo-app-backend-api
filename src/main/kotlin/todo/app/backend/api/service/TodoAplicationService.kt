package todo.app.backend.api.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ResponseStatus
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

    @Transactional
    fun edit(todoId: Long, todoForm: TodoForm) {
        if (todoService.exist(todoId.toString())) throw Error("存在しないtodo idです")
        todoRepository.edit(todoId.toString(), todoForm)
    }

    fun delete(todoId: Long) {
        if (todoService.exist(todoId.toString())) throw Error("存在しないtodo idです")
        todoRepository.delete(todoId.toString())
    }
}