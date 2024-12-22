package todo_app_backend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class DBacsessHelper {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun getLatstGeneralId(): Long? {
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long::class.java)
    }
}