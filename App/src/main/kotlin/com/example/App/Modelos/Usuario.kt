package com.example.App.Modelos

class Usuario(
    private var id: Long? = null,
    private var nombre: String? = null,
    private var email: String? = null
) {

    fun getId(): Long? = id
    fun setId(id: Long?) {
        this.id = id
    }

    fun getNombre(): String? = nombre
    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }

    fun getEmail(): String? = email
    fun setEmail(email: String?) {
        this.email = email
    }
}
