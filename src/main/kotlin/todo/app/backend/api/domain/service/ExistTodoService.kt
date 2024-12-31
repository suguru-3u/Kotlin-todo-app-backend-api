package todo.app.backend.api.domain.service

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository

@Service
class ExistTodoService(val todoRepository : IFTodoRepository) {

    fun execute(todoId:Long): Boolean {
        return todoRepository.existTodo(todoId).isEmpty()
    }
}