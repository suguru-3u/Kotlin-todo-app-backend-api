package todo.app.backend.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["todo.app.backend.api","todo_app_backend_integration_test"])
class TodoAppBackendApplication

fun main(args: Array<String>) {
	runApplication<TodoAppBackendApplication>(*args)
}
