package todo.app.backend.api.Infrastructure.datasource.adapter

import org.apache.ibatis.annotations.*
import todo.app.backend.api.Infrastructure.datasource.repository.TodoRepositoryIml
import todo.app.backend.api.domain.Todo
import todo.app.backend.api.presentation.request.TodoForm

@Mapper
interface IFTodoRepository {

    @SelectProvider(type = TodoRepositoryIml::class, method = "index")
    fun index():List<Todo>

    @InsertProvider(type = TodoRepositoryIml::class, method = "register")
    fun register(todoForm: TodoForm)

    @SelectProvider(type = TodoRepositoryIml::class, method = "findTodo")
    fun findTodo(todoId: String):String

    @UpdateProvider(type = TodoRepositoryIml::class, method = "update")
    fun edit(@Param("todoId") todoId: String, @Param("todoForm") todoForm: TodoForm)

    @DeleteProvider(type = TodoRepositoryIml::class, method = "delete")
    fun delete(todoId: String)
}