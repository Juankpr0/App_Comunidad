package com.example.App.Modelos

class Aviso() {

    private var id: Long? = null
    private var mensaje: String? = null

    constructor(id: Long?, mensaje: String?) : this() {
        this.id = id
        this.mensaje = mensaje
    }

    fun getId(): Long? = id
    fun setId(id: Long?) {
        this.id = id
    }

    fun getMensaje(): String? = mensaje
    fun setMensaje(mensaje: String?) {
        this.mensaje = mensaje
    }
}
