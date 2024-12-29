package todo.app.backend.api.presentation.todo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import todo.app.backend.api.useCases.TodoApplicationService

@RestController
class TodoController(
    val todoApplicationService: TodoApplicationService
) {
    // Todo: TodoをCRUDするAPIを作成する

    // 一覧取得API
    @GetMapping("/index")
    fun index(): ApiResponceTodoIndex {
        return todoApplicationService.index()
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody todoForm: TodoForm) {
        todoApplicationService.register(todoForm)
    }

    @PutMapping("/edit/{todoId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun edit(@PathVariable todoId: Long, @RequestBody todoForm: TodoForm) {
        todoApplicationService.edit(todoId, todoForm)
    }

    @DeleteMapping("/delete/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable todoId: Long) {
        todoApplicationService.delete(todoId)
    }
}