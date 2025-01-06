package todo.app.backend.api.domain.service

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFCategoryRepository

@Service
class ExistCategoryService(val categoryRepository: IFCategoryRepository) {

    fun execute(categoryId: Long): Boolean {
        return categoryRepository.find(categoryId).isEmpty()
    }
}