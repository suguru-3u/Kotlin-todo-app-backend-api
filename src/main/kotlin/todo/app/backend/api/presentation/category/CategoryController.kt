package todo.app.backend.api.presentation.category

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController {

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun add() {
        print("Hello Category Controller")
    }
}