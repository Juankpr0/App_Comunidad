package com.example.App.Controllers

import com.example.App.Modelos.Comunidad
import com.example.App.Services.ComunidadService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comunidades")
class ComunidadController(private val comunidadService: ComunidadService) {

    @GetMapping
    fun getAll(): List<Comunidad> = comunidadService.getAll()

    @PostMapping
    fun create(@RequestBody comunidad: Comunidad): Comunidad = comunidadService.create(comunidad)
}
