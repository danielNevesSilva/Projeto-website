<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listagem de Produtos (Admin)</title>
        <link rel="stylesheet" href="styles/produtos.css">
    </head>

    <body>

        <!-- Botão Voltar -->
        <div class="voltar">
            <a href="#" class="btn-voltar" id="btn-voltar">Voltar</a>
        </div>

        <h1>Listagem de Produtos (Admin)</h1>

        <table class="product-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
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
            <div id="page-numbers"></div>
            <button id="next-page">Próxima</button>
        </div>

        <script src="javascript/teste.js"></script>
        <script src="javascript/voltar.js"></script>
        <script type="text/javascript" src="./javascript/index.js"></script>
    </body>

</html>