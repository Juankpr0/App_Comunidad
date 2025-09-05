package com.example.App.Services

import com.example.App.Modelos.Aviso
import com.example.App.Repository.AvisoRepository
import org.springframework.stereotype.Service

@Service
class AvisoService(private val avisoRepository: AvisoRepository) {

    fun getAll(): List<Aviso> = avisoRepository.findAll()

    fun create(aviso: Aviso): Aviso {
        avisoRepository.save(aviso)
        return aviso
    }
}
