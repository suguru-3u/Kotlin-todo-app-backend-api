package todo.app.backend.api.Infrastructure.datasource.adapter

import org.apache.ibatis.annotations.SelectProvider
import todo.app.backend.api.Infrastructure.datasource.repository.TodoRepositoryIml

interface IFCategoryRepository {

    @SelectProvider(type = TodoRepositoryIml::class, method = "existCategory")
    fun existCategory(todoId: Long):String
}