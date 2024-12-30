package todo.app.backend.api.domain.service

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository

@Service
class TodoService(val todoRepository : IFTodoRepository) {

    fun exist(todoId:Long): Boolean {
        return todoRepository.existTodo(todoId).isEmpty()
    }
}