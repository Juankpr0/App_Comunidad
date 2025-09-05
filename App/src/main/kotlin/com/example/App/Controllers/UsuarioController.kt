package com.example.App.Controllers

import com.example.App.Modelos.Usuario
import com.example.App.Services.UsuarioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val usuarioService: UsuarioService) {

    @GetMapping
    fun getAll(): List<Usuario> = usuarioService.getAll()

    @PostMapping
    fun create(@RequestBody usuario: Usuario): Usuario = usuarioService.create(usuario)
}
