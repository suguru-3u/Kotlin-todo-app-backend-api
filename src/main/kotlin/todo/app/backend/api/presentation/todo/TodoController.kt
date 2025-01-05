package todo.app.backend.api.presentation.todo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import todo.app.backend.api.presentation.todo.request.AddTodoRequest
import todo.app.backend.api.presentation.todo.request.EditTodoRequest
import todo.app.backend.api.presentation.todo.responce.SearchTodosResponse
import todo.app.backend.api.useCases.todo.TodoAddScenario
import todo.app.backend.api.useCases.todo.TodoDeleteScenario
import todo.app.backend.api.useCases.todo.TodoEditScenario
import todo.app.backend.api.useCases.todo.TodoSearchScenario

@RestController
class TodoController(
    val todoSearchScenario: TodoSearchScenario,
    val todoAddScenario: TodoAddScenario,
    val todoEditScenario: TodoEditScenario,
    val todoDeleteScenario: TodoDeleteScenario
) {
    @GetMapping("/search")
    fun search(): SearchTodosResponse {
        return todoSearchScenario.execute()
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody addTodoRequest: AddTodoRequest) {
        todoAddScenario.execute(addTodoRequest)
    }

    @PutMapping("/edit/{todoId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun edit(@PathVariable todoId: Long, @RequestBody editTodoRequest: EditTodoRequest) {
        todoEditScenario.execute(todoId, editTodoRequest)
    }

    @DeleteMapping("/delete/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable todoId: Long) {
        todoDeleteScenario.execute(todoId)
    }
}