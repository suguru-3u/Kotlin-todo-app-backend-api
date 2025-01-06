package todo.app.backend.api.presentation.category

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import todo.app.backend.api.presentation.todo.request.EditTodoRequest
import todo.app.backend.api.useCases.category.CategoryAddScenario
import todo.app.backend.api.useCases.category.CategoryEditScenario

@RestController
@RequestMapping("/api/category")
class CategoryController(
    val categoryAddScenario: CategoryAddScenario,
    val categoryEditScenario: CategoryEditScenario
) {

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun add(addCategoryRequest: AddCategoryRequest) {
        categoryAddScenario.execute(addCategoryRequest)
    }

    @PutMapping("/edit/{categoryId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun edit(@PathVariable categoryId: Long, @RequestBody editCategoryRequest: EditCategoryRequest) {
        categoryEditScenario.execute(categoryId, editCategoryRequest)
    }
}