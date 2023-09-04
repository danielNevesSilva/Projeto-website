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
            <c:forEach var="Product" items="${Products}">
                <tr>
                    <td>${Product.id}</td>
                    <td>${Product.name}</td>
                    <td>${Product.amount}</td>
                    <td>R$ ${Product.price}</td>
                    <td>
                           <img style="width: 100px" src="img/ ${Product.image}" alt="${Product.name}">
            </a>

                    </td>
                    <td>
                        <a href="product-details?id=${Product.id}">Detalhes</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
