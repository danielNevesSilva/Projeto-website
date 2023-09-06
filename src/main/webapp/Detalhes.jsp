<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <!-- Seu código para o cabeçalho da página -->
</head>
<body>
    <h1>Detalhes do Produto</h1>

    <c:if test="${not empty product}">
        <h2>${product.name}</h2>
        <p>ID: ${product.id}</p>
        <p>Quantidade: ${product.amount}</p>
        <p>Preço: R$ ${product.price}</p>
        <p>Descrição: ${product.description}</p>
        <p>Avaliação: ${product.avaliacao}</p>

        <!-- Exibição de Imagens -->
        <h3>Imagens do Produto</h3>

        <c:forEach var="image" items="${product.imagePaths}">
            <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${image}"
                alt="${product.name}">
        </c:forEach>



        <!-- Botão de Compra -->
        <form action="/comprar" method="post">
            <input type="hidden" name="productId" value="${product.id}">
            <button type="submit">Comprar</button>
        </form>
    </c:if>

    <a href="/lista-de-produtos">Voltar para a lista de produtos</a>
</body>
</html>
