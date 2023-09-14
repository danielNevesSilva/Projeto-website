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
      <div class="titulo">
      <c:if test="${sessionScope.tipoUsuario   eq 'Admin'}">
                <a href="/CadastroProduto.jsp" class="btn-cadastrar" id="btn-cadastrar">Cadastrar</a>
                </c:if>
                <h1>Listagem de Produtos</h1>
                <a href="#" class="btn-voltar" id="btn-voltar">Voltar</a>
            </div>

    <table class="product-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Quantidade</th>
                <c:if test="${sessionScope.tipoUsuario   eq 'Estoquista'}">
                <th>Preço</th>
                </c:if>
                <c:if test="${sessionScope.tipoUsuario   eq 'Admin'}">
                <th>Preço</th>
                <th>Status</th>
                <th>Detalhes</th>
                                        </c:if>

            </tr>
        </thead>
        <tbody>
            <!-- Itere sobre a lista de produtos e exiba cada produto -->
            <c:forEach var="product" items="${Products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.amount}</td>
                    <td>
                    <c:if test="${sessionScope.tipoUsuario   eq 'Estoquista'}">
                ${product.amount}
            <button class="open-quantity-modal-button" data-product-id="${product.id}">Alterar Quantidade</button>
                                    </c:if><td>
                    <td class="price">R$ ${product.price}</td>

                    <c:if test="${sessionScope.tipoUsuario   eq 'Admin'}">
                    <td>${product.status}</td>
                    <td>
                        <a href="/product-details?id=${product.id}">Detalhes</a>
                <!-- Modal -->

                        </c:if>
                    </td>
             <td>
               <form action="alterarStatusProduct" method="post">
                <input type="hidden" id="id" name="id" value="${product.id}">

                <c:if test="${sessionScope.tipoUsuario   eq 'Admin'}">

                <button onclick="alterarStatusProduct(${product.id}, '${product.status}')">Alterar Status</button>
                <button style="background-color: orange;"><a
                  href="CadastroProduto.jsp?id=${product.id}&name=${product.name}&description=${product.description}&amount=${product.amount}&price=${product.price}&avaliacao=${product.avaliacao}&image=${product.image}${sessionScope.tipoUsuario}">Alterar</a></button>
    </c:if>
                  </form>
                 </td>
        </tr>
            </c:forEach>


        </tbody>
    </table>
    <div id="quantity-modal" class="modal">
        <div class="modal-content">
        <form action="atualizar-quantidade" method="post">
            <span class="close" id="close-modal-button">&times;</span>
            <h2>Alterar Quantidade</h2>
            <label for="amount">Nova Quantidade:</label>
            <input type="hidden" id="id" name="id" value="${param.id}">
            <input type="number" id="amount" name="amount" step="1" value="${param.amount}" required>
            <button type="submit" id="save-quantity-button">Salvar</button>
            </form>
        </div>
    </div>

    <div class="pagination">
        <button id="prev-page">Anterior</button>
        <div id="page-numbers"></div>
        <button id="next-page">Próxima</button>
    </div>

    <script src="javascript/estoquista.js"></script>
    <script src="javascript/teste1.js"></script>
    <script src="javascript/voltar.js"></script>
    <script type="text/javascript" src="./javascript/index.js"></script>
</body>

</html>
        <button id="open-modal-button">Alterar Quantidade</button>
