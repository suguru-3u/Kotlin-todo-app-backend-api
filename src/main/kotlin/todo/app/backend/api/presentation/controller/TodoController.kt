package todo.app.backend.api.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController {

    // Todo: TodoをCRUDするAPIを作成する

    @GetMapping("/index")
    fun index(){
        println("Hello World")
    }
}