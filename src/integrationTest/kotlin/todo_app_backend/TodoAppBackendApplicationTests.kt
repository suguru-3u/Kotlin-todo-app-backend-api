package todo_app_backend

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.test.web.servlet.client.MockMvcWebTestClient
import org.testcontainers.junit.jupiter.Testcontainers
import todo.app.backend.api.TodoAppBackendApplication
import todo.app.backend.api.domain.Todo
import todo.app.backend.api.presentation.controller.TodoController
import todo.app.backend.api.presentation.responce.ApiResponceTodoIndex
import todo.app.backend.api.service.TodoApplicationService
import kotlin.test.junit5.JUnit5Asserter.assertNotNull


@Testcontainers
@SpringBootTest(
    classes = [TodoAppBackendApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class TodoAppBackendApplicationTests() {

    @Autowired
    lateinit var todoApplicationService: TodoApplicationService

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    // CRUDのテストコードを正常系1本づつ作成する

    // 一覧取得API
    @Test
    fun index() {

        // 共通化させたい
        val webClient = MockMvcWebTestClient.bindToController(
            TodoController(todoApplicationService)
        ).build()

        val sql = "INSERT INTO todo (title) VALUES (?)"
        jdbcTemplate.update(sql, "integrationTest1")
        jdbcTemplate.update(sql, "integrationTest2")
        jdbcTemplate.update(sql, "integrationTest3")

        val todoList = listOf<Todo>(
            Todo(title = "integrationTest1"),
            Todo(title = "integrationTest2"),
            Todo(title = "integrationTest3"),
        )
        val assertTodoList = ApiResponceTodoIndex(todoList = todoList)

        val result = webClient
            .get().uri("/index")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String::class.java) // ボディを取得
            .returnResult()
            .responseBody

        assertNotNull(result, "Response body should not be null")

        val objectMapper = jacksonObjectMapper()
        val response = objectMapper.readValue<ApiResponceTodoIndex>(result!!)

        assertEquals(
            assertTodoList,
            response,
            "一覧取得APIのレスポンスが予期しない値でした"
        )

        jdbcTemplate.execute("DELETE FROM todo")
    }

//    @Test
//    fun contextLoads() {
//        println("テスト実行開始")
//    }
//
//    @Test
//    fun exampleTest() {
//        val webClient = MockMvcWebTestClient.bindToController(
//            TodoController(todoApplicationService)
//        ).build()
//
//        webClient
//            .get().uri("/")
//            .exchange()
//            .expectStatus().isOk
//            .expectBody<String>().isEqualTo("Hello World")
//    }

//    @Test
//    fun exampleTest2() {
//        val webClient = MockMvcWebTestClient.bindToController(
//            TodoController(todoApplicationService)
//        ).build()
//
//        val result = webClient
//            .get().uri("/index")
//            .exchange()
//            .expectBody(String::class.java) // ボディを取得
//            .returnResult()
//            .responseBody
//
//        println("result: $result")
//    }
}
