package todo.app.backend.api.useCases.category

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import todo.app.backend.api.Infrastructure.datasource.adapter.IFCategoryRepository
import todo.app.backend.api.domain.entities.Category
import todo.app.backend.api.domain.service.ExistCategoryService
import todo.app.backend.api.domain.valueObjects.CategoryName
import todo.app.backend.api.presentation.category.EditCategoryRequest
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

class CategoryEditScenario(
    private val existCategoryService: ExistCategoryService,
    private val categoryRepository: IFCategoryRepository
) {

    fun execute(categoryId: Long, editCategoryRequest: EditCategoryRequest) {
        if (existCategoryService.execute(categoryId)) throw Error("不正なカテゴリIDがリクエストされました")
        val category = Category(name = CategoryName(editCategoryRequest.name))
        categoryRepository.edit(categoryId, category)
    }
}