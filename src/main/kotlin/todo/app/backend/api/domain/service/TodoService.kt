package todo.app.backend.api.domain.service

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository

@Service
class TodoService(val todoRepository : IFTodoRepository) {

    fun findTodo(todoId:String): String {
        return todoRepository.findTodo(todoId)
    }

    fun exist(todoId:String): Boolean {
        val result = todoRepository.findTodo(todoId)
        if(result.isEmpty()) return false
        return false
    }
}