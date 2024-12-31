package todo.app.backend.api.Infrastructure.datasource.entity

import java.sql.Timestamp

class TodoEntity(
    val title:String,
    val kind: String,
    val categoriesId: Int,
    val createTime: Timestamp
){
}