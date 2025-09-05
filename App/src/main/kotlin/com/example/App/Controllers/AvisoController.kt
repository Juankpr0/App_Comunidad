package com.example.App.Controllers

import com.example.App.Modelos.Aviso
import com.example.App.Services.AvisoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/avisos")
class AvisoController(private val avisoService: AvisoService) {

    @GetMapping
    fun getAll(): List<Aviso> = avisoService.getAll()

    @PostMapping
    fun create(@RequestBody aviso: Aviso): Aviso = avisoService.create(aviso)
}
