package cl.desafiolatam.kotlindesafio2


sealed class TipoLibro {
    class Digital : TipoLibro()
    class Impreso : TipoLibro()
}

class LibrosEscolares {
    val nombreLibro: String
    val iSBN: Int
    val añoPublicacion: Int
    val editorial: String
    val paginas: Int
    val precio: Int
    var autor: String
    val tipoLibro:TipoLibro

    constructor(
        nombreLibro: String,
        iSBN: Int,
        añoPublicacion: Int,
        editorial: String,
        paginas: Int,
        precio: Int,
        autor: String,
        tipoLibro: TipoLibro
    ) {
        this.nombreLibro = nombreLibro
        this.iSBN = iSBN
        this.añoPublicacion = añoPublicacion
        this.editorial = editorial
        this.paginas = paginas
        this.precio = precio
        this.autor = autor
        this.tipoLibro = tipoLibro
    }

    constructor()
    {
        this.nombreLibro = "A"
        this.iSBN = 0
        this.añoPublicacion = 0
        this.editorial = "A"
        this.paginas = 0
        this.precio = 0
        this.autor = "A"
        this.tipoLibro = TipoLibro.Digital()
    }
}

fun LibrosEscolares.print() {
    println("Título: $nombreLibro \n" +
            "ISBN: $iSBN \n" +
            "Año de Publicacion: $añoPublicacion \n" +
            "Editorial: $editorial \n" +
            "Paginas: $paginas \n" +
            "Precio: ${agregarPeso()} \n" +
            "Autor: $autor \n" +
            "Tipo de Libro: $tipoLibro \n" +
            "[===============================]"
    )
}

fun LibrosEscolares.agregarPeso () : String {
    return "$$precio"
}

fun main () {
    val texto1 = LibrosEscolares("nombre", 4,1990,"Santillana", 10, 9990, "Sin identificar", TipoLibro.Impreso())
    val texto2 = LibrosEscolares()
    val texto3 = LibrosEscolares("Pera", 11111, 2001, "Frutera", 50, 32990, "Don Roberto", TipoLibro.Digital())
    var texto4 = LibrosEscolares("Guia ilustrada", 3214, 2013, "Austral", 210, 15990, "Sekien", TipoLibro.Impreso())
    texto4.autor = "Sekien Toriyama"

    texto1.print()
    texto2.print()
    texto3.print()
    texto4.print()
}



