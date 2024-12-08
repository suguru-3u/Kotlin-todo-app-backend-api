package todo.app.backend.api.Infrastructure.datasource.repository

import org.apache.ibatis.jdbc.SQL
import todo.app.backend.api.presentation.controller.request.TodoForm

class TodoRepositoryIml {

    fun index(): String = SQL().run {
        SELECT(
            "title"
        )
        FROM("todo")
        toString()
    }

    fun register(todoForm: TodoForm): String = SQL().run {
        INSERT_INTO("todo")
        VALUES("title", "#{title}")
        toString()
    }

    fun findTodo(todoId: String): String = SQL().run {
        SELECT(
            "title"
        )
        FROM("todo")
        WHERE("id = #{todoId}")
        toString()
    }

    fun update(todoId: String, todoForm: TodoForm): String = SQL().run {
        UPDATE("todo")
        SET("title = #{todoForm.title}")
        WHERE("id = #{todoId}")
        toString()
    }
}