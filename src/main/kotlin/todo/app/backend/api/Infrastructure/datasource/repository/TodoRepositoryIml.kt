package todo.app.backend.api.Infrastructure.datasource.repository

import org.apache.ibatis.jdbc.SQL
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository
import todo.app.backend.api.presentation.controller.request.TodoForm

class TodoRepositoryIml : IFTodoRepository {

    override fun index(): String = SQL().run {
        SELECT(
            "title"
        )
        FROM("todo")
        toString()
    }

    override fun register(todoForm: TodoForm): String = SQL().run {
        INSERT_INTO("todo");
        VALUES("title", "#{title}")
        toString()
    }
}