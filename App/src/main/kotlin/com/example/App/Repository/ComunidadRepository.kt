package com.example.App.Repository

import com.example.App.Modelos.Comunidad
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class ComunidadRepository(private val jdbcTemplate: JdbcTemplate) {

    private val rowMapper = RowMapper { rs, _ ->
        Comunidad(
            rs.getLong("id"),
            rs.getString("nombre")
        )
    }

    fun findAll(): List<Comunidad> =
        jdbcTemplate.query("SELECT * FROM comunidad", rowMapper)

    fun save(comunidad: Comunidad): Int =
        jdbcTemplate.update(
            "INSERT INTO comunidad (id, nombre) VALUES (?, ?)",
            comunidad.getId(), comunidad.getNombre()
        )
}
