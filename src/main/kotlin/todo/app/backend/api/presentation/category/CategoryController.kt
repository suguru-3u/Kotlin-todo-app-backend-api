package todo.app.backend.api.presentation.category

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import todo.app.backend.api.useCases.category.CategoryAddScenario

@RestController
@RequestMapping("/api/category")
class CategoryController(
    val categoryAddScenario: CategoryAddScenario
) {

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun add(addCategoryRequest: AddCategoryRequest) {
        categoryAddScenario.execute(addCategoryRequest)
    }
}