<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listagem de Produtos</title>
        <link rel="stylesheet" href="styles/produtos.css">
    </head>

    <body>

        <!-- Botão Voltar -->
        <div class="titulo">
            <a href="/CadastroProduto.jsp" class="btn-cadastrar" id="btn-cadastrar">Cadastrar</a>
            <h1>Listagem de Produtos</h1>
            <a href="#" class="btn-voltar" id="btn-voltar">Voltar</a>
        </div>

        <table class="product-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Valor</th>
                    <th>Status</th>
                    <th>Detalhes</th>
                </tr>
            </thead>
            <tbody>
                <!-- Itere sobre a lista de produtos e exiba cada produto -->
<c:forEach var="product" items="${Products}">
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.amount}</td>
        <td class="price">R$ ${product.price}</td>
        <td>${product.status}</td>
        <td class="product-image">

        <td>

            <a href="/product-details?id=${product.id}">Detalhes</a>

        </td>
    </tr>
</c:forEach>

            </tbody>
        </table>

        <div class="pagination">
            <button id="prev-page">Anterior</button>
            <button id="next-page">Seguinte</button>
        </div>
        <script src="javascript/paginacao.js"></script>
        <script src="javascript/voltar.js"></script>
        <script type="text/javascript" src="./javascript/index.js"></script>
    </body>

</html>