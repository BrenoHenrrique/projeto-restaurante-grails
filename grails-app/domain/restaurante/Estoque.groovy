package restaurante

class Estoque {

    Integer quantidade //cria a coluna com o tipo da variavel
    Integer quantidadeMinima
    Produto produto //instancia do cominio produto

    //metodo para dizer que esta classe pertence a 'Produto' fazendo com que salve em cascata
    static belongsTo = [Produto]

    //validações no banco
    static constraints = {
        quantidade min: 0
        quantidadeMinima min: 0
        produto nullable: false, blank: false
    }
}
