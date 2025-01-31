<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Gerenciamento de Produtos</title>
        <g:javascript library="jquery" /> <!--import jquery-->

        <script type="text/javascript">
            function carregarLista() {
                <g:remoteFunction controller="produto" action="lista" update="divLista" />
            }
            
            function excluir(id) {
                if(confirm("Deseja realmente excluir?")){
                    //'+id+' é uma concatenação para o jquery reconhecer a variavel id da função e não um texto
                    <g:remoteFunction controller="produto" action="excluir" update="divLista" id="'+id+'"/>
                }
            }

            function cancelar(){
                jQuery("#divForm").html("")
            }
        </script>
    </head>

    <body>
        <g:remoteLink controller="produto" action="adicionar" update="divForm">Adicionar</g:remoteLink>

        <div id="divLista">
            <g:render template="lista" model="[produtos: produtos]" />
        </div>

        <div id="divForm">

        </div>
    </body>
</html>