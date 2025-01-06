package todo.app.backend.api.Infrastructure.datasource.adapter

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import todo.app.backend.api.Infrastructure.datasource.repository.CategoryRepositoryIml
import todo.app.backend.api.Infrastructure.datasource.repository.TodoRepositoryIml
import todo.app.backend.api.domain.entities.Category
import todo.app.backend.api.domain.entities.Todo

@Mapper
interface IFCategoryRepository {

    @SelectProvider(type = CategoryRepositoryIml::class, method = "add")
    fun add(category: Category)

    @SelectProvider(type = CategoryRepositoryIml::class, method = "find")
    fun find(categoryId: Long): String

    @UpdateProvider(type = CategoryRepositoryIml::class, method = "edit")
    fun edit(@Param("categoryId") categoryId: Long, @Param("category") category: Category)
}