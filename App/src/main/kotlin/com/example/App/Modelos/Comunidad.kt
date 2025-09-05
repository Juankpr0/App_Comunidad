package com.example.App.Modelos

class Comunidad() {

    private var id: Long? = null
    private var nombre: String? = null

    constructor(id: Long?, nombre: String?) : this() {
        this.id = id
        this.nombre = nombre
    }

    fun getId(): Long? = id
    fun setId(id: Long?) {
        this.id = id
    }

    fun getNombre(): String? = nombre
    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }
}