package todo.app.backend.api.service

import org.springframework.stereotype.Service
import todo.app.backend.api.Infrastructure.datasource.adapter.IFTodoRepository

@Service
class TodoApplicationService(
    val todoRepositoryIml : IFTodoRepository
) {

    fun index(){
        val result = todoRepositoryIml.index()
        println("取得結果: $result")
    }
}