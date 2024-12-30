package todo.app.backend.api.Infrastructure.datasource.adapter

import org.apache.ibatis.annotations.*
import todo.app.backend.api.Infrastructure.datasource.repository.TodoRepositoryIml
import todo.app.backend.api.domain.entities.Todo
import todo.app.backend.api.presentation.todo.AddTodoRequest
import todo.app.backend.api.presentation.todo.EditTodoRequest

@Mapper
interface IFTodoRepository {

    @SelectProvider(type = TodoRepositoryIml::class, method = "search")
    fun search():List<Todo>

    @InsertProvider(type = TodoRepositoryIml::class, method = "add")
    fun add(todo: Todo)

    @SelectProvider(type = TodoRepositoryIml::class, method = "existTodo")
    fun existTodo(todoId: Long):String

    @UpdateProvider(type = TodoRepositoryIml::class, method = "edit")
    fun edit(@Param("todoId") todoId: String, @Param("editTodoRequest") editTodoRequest: EditTodoRequest)

    @DeleteProvider(type = TodoRepositoryIml::class, method = "delete")
    fun delete(todoId: String)
}