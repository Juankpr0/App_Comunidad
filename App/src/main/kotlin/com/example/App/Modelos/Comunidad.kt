package com.example.App.Modelos

class Comunidad(
    id: Long? = null,
    nombre: String? = null
) {
    private var id: Long? = id
    private var nombre: String? = nombre

    fun getId(): Long? = id
    fun setId(id: Long?) {
        this.id = id
    }

    fun getNombre(): String? = nombre
    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }
}
