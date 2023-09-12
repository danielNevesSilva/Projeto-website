<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <!-- Seu código para o cabeçalho da página -->
    <link rel="stylesheet" href="styles/produto-detalhes.css">
</head>
<body>
    <div class="container">

        <h1>Detalhes do Produto</h1>

        <c:if test="${not empty product}">
            <h2>${product.name}</h2>
            <!-- Adicione outros detalhes do produto conforme necessário -->

            <!-- Exibição de Imagens com Carrossel -->
            <h3>Imagens do Produto</h3>
            <div class="carousel-container">
                <div class="carousel-content">
                    <c:forEach var="image" items="${product.imagePaths}">
                        <div class="carousel-item">
                            <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${image}"
                                alt="${product.name}">
                        </div>
                    </c:forEach>
                </div>
            </div>

            <!-- Botão de Compra -->
            <form action="/comprar" method="post">
                <input type="hidden" name="productId" value="${product.id}">
                <button type="submit">Comprar</button>
            </form>
        </c:if>

        <a href="/Produtos.jsp"><button class="btn">Voltar</button></a>

    </div>

    <script src="javascript/carrossel.js"></script>

</body>
</html>
