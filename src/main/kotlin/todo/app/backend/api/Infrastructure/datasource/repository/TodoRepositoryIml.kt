package todo.app.backend.api.Infrastructure.datasource.repository

import org.apache.ibatis.jdbc.SQL
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository

class TodoRepositoryIml: IFTodoRepository {

    override fun index():String =  SQL().run {
        SELECT(
            "title"
        )
        FROM("todo")
        toString()
    }
}