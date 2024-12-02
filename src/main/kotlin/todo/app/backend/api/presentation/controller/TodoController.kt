package todo.app.backend.api.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import todo.app.backend.api.service.TodoApplicationService

@RestController
class TodoController(
    val todoApplicationService : TodoApplicationService
) {
    // Todo: TodoをCRUDするAPIを作成する

    // 一覧取得API
    @GetMapping("/index")
    fun index(){
        todoApplicationService.index()
    }
}