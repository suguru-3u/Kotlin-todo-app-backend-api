package todo.app.backend.api.presentation.todo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import todo.app.backend.api.useCases.TodoAddScenario
import todo.app.backend.api.useCases.TodoDeleteScenario
import todo.app.backend.api.useCases.TodoEditScenario
import todo.app.backend.api.useCases.TodoSearchScenario

@RestController
class TodoController(
    val todoSearchScenario: TodoSearchScenario,
    val todoAddScenario: TodoAddScenario,
    val todoEditScenario: TodoEditScenario,
    val todoDeleteScenario: TodoDeleteScenario
) {
    // Todo: TodoをCRUDするAPIを作成する

    // 一覧取得API
    @GetMapping("/index")
    fun index(): ApiResponceTodoIndex {
        return todoSearchScenario.index()
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody todoForm: TodoForm) {
        todoAddScenario.register(todoForm)
    }

    @PutMapping("/edit/{todoId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun edit(@PathVariable todoId: Long, @RequestBody todoForm: TodoForm) {
        todoEditScenario.edit(todoId, todoForm)
    }

    @DeleteMapping("/delete/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable todoId: Long) {
        todoDeleteScenario.delete(todoId)
    }
}