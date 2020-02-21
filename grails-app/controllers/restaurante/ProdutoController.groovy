package restaurante

class ProdutoController {

    def index() {

        def lista = Produto.list()

        render(view:"index", model: [produtos: lista])
    }

    def adicionar() {

        Produto novoProduto = new Produto()
        novoProduto.preco = 0
        novoProduto.estoque = new Estoque()
        novoProduto.estoque.quantidade = 0
        novoProduto.estoque.quantidadeMinima = 0

        render(template: "/produto/form", model: [produto: novoProduto])
    }

    def alterar(){
        Produto produto = Produto.get(params.id)
        render(template:"/produto/form", model: [produto: produto])
    }

    def lista(){
        def lista = Produto.list()
        render(template:"/produto/lista", model: [produtos: lista])
    }

    def salvar() {
        Produto produto = null

        if(params.id){
            produto = Produto.get(params.id) //para pegar um dado do banco, proximo do comando conexao.rs.getString(coluna)
        }else{
            produto = new Produto()
            produto.estoque = new Estoque()
        }

        produto.nome = params.nome
        produto.preco = params.preco.toDouble()
        produto.estoque = new Estoque()
        produto.estoque.quantidade = params.quantidade.toInteger()
        produto.estoque.quantidadeMinima = params.quantidadeMinima.toInteger()

        produto.validate()
        if (!produto.hasErrors()) {
            produto.save(flush: true)
            render("Salvo com sucesso!")
        } else {
            render("Erro ao salvar!")
        }
    }

    def excluir() {
        Produto produto = Produto.get(params.id)
        produto.delete(flush: true)

        def lista = Produto.list()
        render(template:"/produto/lista", model: [produtos: lista])
    }
}
