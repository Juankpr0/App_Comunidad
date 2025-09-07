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

    fun findById(id: Long): Usuario? =
        jdbcTemplate.query("SELECT * FROM usuario WHERE id = ?", rowMapper, id)
            .firstOrNull()

    fun save(usuario: Usuario): Usuario {
        jdbcTemplate.update(
            "INSERT INTO usuario (id, nombre, email) VALUES (?, ?, ?)",
            usuario.getId(), usuario.getNombre(), usuario.getEmail()
        )
        return usuario
    }

    fun update(usuario: Usuario): Usuario {
        jdbcTemplate.update(
            "UPDATE usuario SET nombre = ?, email = ? WHERE id = ?",
            usuario.getNombre(), usuario.getEmail(), usuario.getId()
        )
        return usuario
    }

    fun deleteById(id: Long): Int =
        jdbcTemplate.update("DELETE FROM usuario WHERE id = ?", id)

    fun existsById(id: Long): Boolean =
        jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM usuario WHERE id = ?",
            Long::class.java,
            id
        )!! > 0
}
