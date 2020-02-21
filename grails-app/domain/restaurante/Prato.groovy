package restaurante

class Prato extends Produto{

    Integer quantidadePessoa

    static constraints = {
        quantidadePessoa min: 1
    }

    static mapping = {
        discriminator value: "PRATO"
    }
}
