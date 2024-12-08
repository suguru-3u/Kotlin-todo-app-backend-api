package todo.app.backend.api.presentation.controller

import org.springframework.web.bind.annotation.*
import todo.app.backend.api.presentation.controller.request.TodoForm
import todo.app.backend.api.service.TodoApplicationService

@RestController
class TodoController(
    val todoApplicationService: TodoApplicationService
) {
    // Todo: TodoをCRUDするAPIを作成する

    // 一覧取得API
    @GetMapping("/index")
    fun index() {
        todoApplicationService.index()
    }

    @PostMapping("/register")
    fun register(@RequestBody todoForm: TodoForm) {
        todoApplicationService.register(todoForm)
    }

    @PutMapping("/edit/{todoId}")
    fun edit(@PathVariable todoId: Long, @RequestBody todoForm: TodoForm) {
        todoApplicationService.edit(todoId, todoForm)
    }
}