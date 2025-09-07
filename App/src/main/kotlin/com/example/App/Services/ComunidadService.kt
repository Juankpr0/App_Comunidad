package com.example.App.Services

import com.example.App.Modelos.Comunidad
import org.springframework.stereotype.Service

@Service
class ComunidadService {

    private val comunidades = mutableListOf<Comunidad>()

    fun getAll(): List<Comunidad> = comunidades

    fun create(comunidad: Comunidad): Comunidad {
        comunidades.add(comunidad)
        return comunidad
    }

    fun getById(id: Long): Comunidad? {
        return comunidades.find { it.getId() == id }
    }
}
