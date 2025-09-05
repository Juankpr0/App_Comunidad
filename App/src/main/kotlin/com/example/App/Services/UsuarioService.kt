package com.example.App.Services

import com.example.App.Modelos.Usuario
import com.example.App.Repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    fun getAll(): List<Usuario> = usuarioRepository.findAll()

    fun create(usuario: Usuario): Usuario {
        usuarioRepository.save(usuario)
        return usuario
    }
}
