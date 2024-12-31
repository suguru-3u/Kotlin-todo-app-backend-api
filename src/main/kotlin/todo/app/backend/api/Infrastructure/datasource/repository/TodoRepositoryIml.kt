package todo.app.backend.api.Infrastructure.datasource.repository

import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.jdbc.SQL
import todo.app.backend.api.domain.entities.Todo
import todo.app.backend.api.domain.valueObjects.TodoKind
import todo.app.backend.api.domain.valueObjects.TodoTitle
import todo.app.backend.api.presentation.todo.AddTodoRequest
import todo.app.backend.api.presentation.todo.EditTodoRequest

class TodoRepositoryIml {

    @Suppress("unused")
    fun search(): String = SQL().run {
        SELECT(
            "title",
            "kind",
            "categories_id",
            "create_time"
        )
        FROM("todos")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun add(todo: Todo): String = SQL().run {
        INSERT_INTO("todos")
        VALUES("title", "#{title.title}")
        VALUES("kind", "#{kind.kindName}")
        VALUES("categories_id", "#{category}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun existTodo(todoId: Long): String = SQL().run {
        SELECT(
            "title"
        )
        FROM("todos")
        WHERE("id = #{todoId}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun edit(todoId: String, todo: Todo): String = SQL().run {
        UPDATE("todos")
        SET("title = #{todo.title.title}")
        SET("kind = #{todo.kind.kindName}")
        SET("categories_id = #{todo.category}")
        WHERE("id = #{todoId}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun delete(todoId: String):String = SQL().run {
        DELETE_FROM("todos")
        WHERE("id = #{todoId}")
        toString()
    }
}