package com.example.App.Repository

import com.example.App.Modelos.Aviso
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class AvisoRepository(private val jdbcTemplate: JdbcTemplate) {

    private val rowMapper = RowMapper<Aviso> { rs, _ ->
        Aviso(
            rs.getLong("id"),
            rs.getString("mensaje")
        )
    }

    fun findAll(): List<Aviso> =
        jdbcTemplate.query("SELECT id, mensaje FROM aviso", rowMapper)

    fun findById(id: Long): Aviso? =
        jdbcTemplate.query("SELECT id, mensaje FROM aviso WHERE id = ?", rowMapper, id)
            .firstOrNull()

    fun save(aviso: Aviso): Aviso {
        if (aviso.getId() == null) {
            jdbcTemplate.update(
                "INSERT INTO aviso (mensaje) VALUES (?)",
                aviso.getMensaje()
            )
        } else {
            jdbcTemplate.update(
                "UPDATE aviso SET mensaje = ? WHERE id = ?",
                aviso.getMensaje(), aviso.getId()
            )
        }
        return aviso
    }

    fun existsById(id: Long): Boolean =
        jdbcTemplate.queryForObject("SELECT COUNT(*) FROM aviso WHERE id = ?", Long::class.java, id)!! > 0

    fun deleteById(id: Long) {
        jdbcTemplate.update("DELETE FROM aviso WHERE id = ?", id)
    }
}
