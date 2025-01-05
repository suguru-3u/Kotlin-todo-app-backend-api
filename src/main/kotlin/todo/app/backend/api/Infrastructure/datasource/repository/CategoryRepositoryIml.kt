package todo.app.backend.api.Infrastructure.datasource.repository

import org.apache.ibatis.jdbc.SQL
import todo.app.backend.api.domain.entities.Category

class CategoryRepositoryIml {

    @Suppress("unused", "UNUSED_PARAMETER")
    fun add(category: Category):  String = SQL().run {
        INSERT_INTO("categories")
        VALUES("name", "#{category.name}")
        toString()
    }
}