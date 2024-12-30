package todo.app.backend.api.Infrastructure.datasource.repository

import org.apache.ibatis.jdbc.SQL
import todo.app.backend.api.domain.entities.Todo
import todo.app.backend.api.presentation.todo.TodoForm

class TodoRepositoryIml {

    @Suppress("unused")
    fun index(): String = SQL().run {
        SELECT(
            "title",
            "category"
        )
        FROM("todo")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun register(todo: Todo): String = SQL().run {
        INSERT_INTO("todo")
        VALUES("title", "#{title}")
        VALUES("category", "#{category}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun findTodo(todoId: String): String = SQL().run {
        SELECT(
            "title"
        )
        FROM("todo")
        WHERE("id = #{todoId}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun update(todoId: String, todoForm: TodoForm): String = SQL().run {
        UPDATE("todo")
        SET("title = #{todoForm.title}")
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