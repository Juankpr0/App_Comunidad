package com.example.App.Services

import com.example.App.Modelos.Comunidad
import com.example.App.Repository.ComunidadRepository
import org.springframework.stereotype.Service

@Service
class ComunidadService(private val comunidadRepository: ComunidadRepository) {

    fun getAll(): List<Comunidad> = comunidadRepository.findAll()

    fun create(comunidad: Comunidad): Comunidad {
        comunidadRepository.save(comunidad)
        return comunidad
    }
}