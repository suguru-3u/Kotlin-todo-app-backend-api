package todo.app.backend.api.Infrastructure.datasource.adapter

import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import todo.app.backend.api.Infrastructure.datasource.repository.TodoRepositoryIml
import todo.app.backend.api.domain.Todo
import todo.app.backend.api.presentation.controller.request.TodoForm

@Mapper
interface IFTodoRepository {

    @SelectProvider(type = TodoRepositoryIml::class, method = "index")
    fun index():List<Todo>

    @InsertProvider(type = TodoRepositoryIml::class, method = "register")
    fun register(todoForm: TodoForm)
}