package todo.app.backend.api.domain.service

import org.springframework.stereotype.Service
import todo.app.backend.api.domain.entities.Todo
import todo.app.backend.api.domain.valueObjects.TodoKind
import todo.app.backend.api.domain.valueObjects.TodoTitle
import todo.app.backend.api.presentation.todo.request.BaseTodoRequest

@Service
class TodoFactory {
    fun execute(request: BaseTodoRequest): Todo {
        val todoTitle = TodoTitle(title = request.title)
        val todoKind = TodoKind.findCategory(value = request.kind)
        return Todo(title = todoTitle, kind = todoKind)
    }
}