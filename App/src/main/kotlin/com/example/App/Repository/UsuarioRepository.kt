package com.example.App.Repository

import com.example.App.Modelos.Usuario
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class UsuarioRepository(private val jdbcTemplate: JdbcTemplate) {

    private val rowMapper = RowMapper { rs, _ ->
        Usuario(
            rs.getLong("id"),
            rs.getString("nombre"),
            rs.getString("email")
        )
    }

    fun findAll(): List<Usuario> =
        jdbcTemplate.query("SELECT * FROM usuario", rowMapper)

    fun save(usuario: Usuario): Int =
        jdbcTemplate.update(
            "INSERT INTO usuario (id, nombre, email) VALUES (?, ?, ?)",
            usuario.getId(), usuario.getNombre(), usuario.getEmail()
        )
}
