package todo.app.backend.api.Infrastructure.datasource.repository

import org.apache.ibatis.jdbc.SQL
import todo.app.backend.api.domain.entities.Todo
import todo.app.backend.api.presentation.todo.AddTodoRequest
import todo.app.backend.api.presentation.todo.EditTodoRequest

class TodoRepositoryIml {

    @Suppress("unused")
    fun search(): String = SQL().run {
        SELECT(
            "title",
            "category"
        )
        FROM("todo")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun add(todo: Todo): String = SQL().run {
        INSERT_INTO("todo")
        VALUES("title", "#{title}")
        VALUES("category", "#{category}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun existTodo(todoId: Long): String = SQL().run {
        SELECT(
            "title"
        )
        FROM("todo")
        WHERE("id = #{todoId}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun edit(todoId: String, editTodoRequest: EditTodoRequest): String = SQL().run {
        UPDATE("todo")
        SET("title = #{editTodoRequest.title}")
        WHERE("id = #{todoId}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun delete(todoId: String):String = SQL().run {
        DELETE_FROM("todo")
        WHERE("id = #{todoId}")
        toString()
    }
}