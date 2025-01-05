package todo.app.backend.api.useCases.category

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFCategoryRepository
import todo.app.backend.api.domain.entities.Category
import todo.app.backend.api.domain.valueObjects.CategoryName
import todo.app.backend.api.presentation.category.AddCategoryRequest

@Service
class CategoryAddScenario(
        val categoryRepository: IFCategoryRepository
) {

    fun execute(addCategoryRequest: AddCategoryRequest) {
        val category = Category(name = CategoryName(addCategoryRequest.name))
        categoryRepository.add(category)
    }
}