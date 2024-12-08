package todo.app.backend.api.domain

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository

@Service
class TodoService(val todoRepository : IFTodoRepository) {

    fun findTodo(todoId:String): String {
        return todoRepository.findTodo(todoId)
    }
}