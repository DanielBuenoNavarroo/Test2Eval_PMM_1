package com.example.test2eval_pmm_1

import java.io.Serializable

class Libro(
    private val titulo : String?,
    private val numpag : String?,
    private val nombreAutor : String?,
    private val anioPublicacion : String?
) : Serializable{
    override fun toString(): String {
        return "Libro(\n\tTítulo=$titulo\n\tNumero de Páginas=$numpag\n\tNombre del Autor=$nombreAutor\n\tAño de Publicacion=$anioPublicacion)\n"
    }
}