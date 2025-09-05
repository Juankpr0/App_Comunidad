package com.example.App.Repository


import com.example.App.Modelos.Aviso
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class AvisoRepository(private val jdbcTemplate: JdbcTemplate) {

    private val rowMapper = RowMapper { rs, _ ->
        Aviso(
            rs.getLong("id"),
            rs.getString("mensaje")
        )
    }

    fun findAll(): List<Aviso> =
        jdbcTemplate.query("SELECT * FROM aviso", rowMapper)

    fun save(aviso: Aviso): Int =
        jdbcTemplate.update(
            "INSERT INTO aviso (id, mensaje) VALUES (?, ?)",
            aviso.getId(), aviso.getMensaje()
        )
}
