package todo.app.backend.api.Infrastructure.datasource.repository

import org.apache.ibatis.jdbc.SQL
import todo.app.backend.api.domain.entities.Category
import todo.app.backend.api.domain.entities.Todo

class CategoryRepositoryIml {

    @Suppress("unused", "UNUSED_PARAMETER")
    fun add(category: Category): String = SQL().run {
        INSERT_INTO("categories")
        VALUES("name", "#{category.name}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun find(categoryId: Long): String = SQL().run {
        SELECT(
            "name"
        )
        FROM("categories")
        WHERE("id = #{categoryId}")
        toString()
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    fun edit(categoryId: Long, category: Category): String = SQL().run {
        UPDATE("categories")
        SET("name = #{category.name.value}")
        WHERE("id = #{categoryId}")
        toString()
    }
}