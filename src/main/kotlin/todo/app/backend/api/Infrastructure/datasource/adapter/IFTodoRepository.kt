package todo.app.backend.api.Infrastructure.datasource.adapter

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import todo.app.backend.api.Infrastructure.datasource.repository.TodoRepositoryIml

@Mapper
interface IFTodoRepository {

    @SelectProvider(type = TodoRepositoryIml::class, method = "index")
    fun index():String
}