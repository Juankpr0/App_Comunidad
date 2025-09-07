package com.example.App.Services

import com.example.App.Modelos.Usuario
import com.example.App.Repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    fun getAll(): List<Usuario> = usuarioRepository.findAll()

    fun getById(id: Long): Usuario =
        usuarioRepository.findById(id)
            ?: throw NoSuchElementException("Usuario con id $id no encontrado")

    fun create(usuario: Usuario): Usuario =
        usuarioRepository.save(usuario)

    fun update(id: Long, usuario: Usuario): Usuario {
        val existente = getById(id)
        existente.setNombre(usuario.getNombre())
        existente.setEmail(usuario.getEmail())
        return usuarioRepository.save(existente)
    }

    fun delete(id: Long) {
        if (!usuarioRepository.existsById(id)) {
            throw NoSuchElementException("Usuario con id $id no encontrado")
        }
        usuarioRepository.deleteById(id)
    }
}
