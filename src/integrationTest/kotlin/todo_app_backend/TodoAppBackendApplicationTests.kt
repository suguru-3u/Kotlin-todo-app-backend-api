package todo_app_backend

import TestConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import org.springframework.test.web.servlet.client.MockMvcWebTestClient
import org.testcontainers.junit.jupiter.Testcontainers
import todo.app.backend.api.TodoAppBackendApplication
import todo.app.backend.api.presentation.controller.TodoController
import todo.app.backend.api.service.TodoApplicationService

@Testcontainers
@SpringBootTest(
    classes = [TodoAppBackendApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class TodoAppBackendApplicationTests {

    @Autowired
    lateinit var todoApplicationService: TodoApplicationService

//    @Autowired
//    private lateinit var webClient: WebTestClient

//    lateinit var webTestClientBuilder: WebTestClient

    @Test
    fun contextLoads() {
        println("テスト実行開始")
    }

    @Test
    fun exampleTest() {
        val webClient = MockMvcWebTestClient.bindToController(
            TodoController(todoApplicationService)
        ).build()

        webClient
            .get().uri("/")
            .exchange()
            .expectStatus().isOk
            .expectBody<String>().isEqualTo("Hello World")
    }

    @Test
    fun exampleTest2() {
        val webClient = MockMvcWebTestClient.bindToController(
            TodoController(todoApplicationService)
        ).build()

        val result = webClient
            .get().uri("/index")
            .exchange()
            .expectStatus().isOk

        println("result $result")
    }
}
