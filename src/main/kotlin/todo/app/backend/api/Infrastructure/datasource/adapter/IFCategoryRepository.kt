package todo.app.backend.api.Infrastructure.datasource.adapter

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import todo.app.backend.api.Infrastructure.datasource.repository.CategoryRepositoryIml
import todo.app.backend.api.domain.entities.Category

@Mapper
interface IFCategoryRepository {

    @SelectProvider(type = CategoryRepositoryIml::class, method = "add")
    fun add(category: Category)
}