package todo.app.backend.api.service

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.presentation.controller.request.TodoForm

@Service
class TodoApplicationService(
    val todoRepository : IFTodoRepository
) {

    fun index(){
        val result = todoRepository.index()
        println("取得結果: $result")
    }

    fun register(todoForm: TodoForm){
        todoRepository.register(todoForm)
    }
}