package com.example.App.Controllers

import com.example.App.Modelos.Usuario
import com.example.App.Services.UsuarioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val usuarioService: UsuarioService) {

    @GetMapping
    fun getAll(): List<Usuario> = usuarioService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Usuario =
        usuarioService.getById(id)

    @PostMapping
    fun create(@RequestBody usuario: Usuario): Usuario =
        usuarioService.create(usuario)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody usuario: Usuario): Usuario =
        usuarioService.update(id, usuario)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        usuarioService.delete(id)
    }
}
