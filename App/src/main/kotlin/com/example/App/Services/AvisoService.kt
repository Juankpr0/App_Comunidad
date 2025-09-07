package com.example.App.Services

import com.example.App.Modelos.Aviso
import com.example.App.Repository.AvisoRepository
import org.springframework.stereotype.Service

@Service
class AvisoService(private val avisoRepository: AvisoRepository) {

    fun getAll(): List<Aviso> = avisoRepository.findAll()

    fun getById(id: Long): Aviso =
        avisoRepository.findById(id)
            ?: throw NoSuchElementException("Aviso con id $id no encontrado")

    fun create(aviso: Aviso): Aviso =
        avisoRepository.save(aviso)

    fun update(id: Long, aviso: Aviso): Aviso {
        val existente = getById(id)
        existente.setMensaje(aviso.getMensaje())
        return avisoRepository.save(existente)
    }

    fun delete(id: Long) {
        if (!avisoRepository.existsById(id)) {
            throw NoSuchElementException("Aviso con id $id no encontrado")
        }
        avisoRepository.deleteById(id)
    }
}