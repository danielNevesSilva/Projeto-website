<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listagem de Produtos (Admin)</title>
</head>
<body>
    <h1>Listagem de Produtos (Admin)</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Quantidade</th>
                <th>Preço</th>
                <th>Imagem Principal</th>
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
                    <td>R$ ${product.price}</td>
                    <td>
                    <img src="${pageContext.request.contextPath}/img/20230904183216137.jpg" alt="${product.name}">

                        <img src="img/ ${product.images[0]}" alt="${product.name}">
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/product-details?id=${product.id}">Detalhes</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
