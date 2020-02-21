package restaurante

class Produto {

    String nome
    Double preco

    Estoque estoque

    static hasMany = [clientesPreferidos:Cliente, itens:ItemPedido]

    static belongsTo = [Cliente]

    static constraints = {
        nome nullable: false, blank: false
        preco min: new Double(0)
    }

    //metodo para mapear a tabela e fazer mudanças
    static mapping = {
        discriminator column: "tipo", value: "GERAL"
        estoque column: "id_estoque"
        clientes joinTable: [name:"preferencias_cliente", key: "id_produto", column: "id_cliente"]
    }
}
