import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.WebTestClient.Builder

@Configuration
class TestConfig {

    @Bean
    fun webTestClientBuilder(): Builder {
        return WebTestClient.bindToServer()
    }
}
