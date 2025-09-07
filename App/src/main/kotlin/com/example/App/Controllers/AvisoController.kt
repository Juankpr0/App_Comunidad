package com.example.App.Controllers

import com.example.App.Modelos.Aviso
import com.example.App.Services.AvisoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/avisos")
class AvisoController(private val avisoService: AvisoService) {

    @GetMapping
    fun getAll(): List<Aviso> = avisoService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Aviso =
        avisoService.getById(id)

    @PostMapping
    fun create(@RequestBody aviso: Aviso): Aviso =
        avisoService.create(aviso)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody aviso: Aviso): Aviso =
        avisoService.update(id, aviso)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        avisoService.delete(id)
    }
}
