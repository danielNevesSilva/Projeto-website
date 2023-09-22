    <!DOCTYPE html>
    <html lang="pt-br">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listagem de Produtos (Admin)</title>
    </head>

    <body>


            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                </tr>
            </thead>

            <form action="/produtos" method="get">
                <h3 class="">Pesquisar Nome:</h3>
                <input id="name" name="name" type="text" placeholder="  nome"
                    value="${param.name}" />

                <button type="submit">Pesquisar</button>

                <c:if test="${empty Products}">
                    <p>Nenhum Produto encontrado.</p>
                </c:if>
                    <c:forEach var="product" items="${Products}">
                        <tr>
                            <td>${product.name}</td>
                            <td>${product.amount}</td>

                                <td class="price">R$ ${product.price}</td>
                                <td>
                                </td>

                            <c:forEach var="imagePath" items="${product.images}">
                                                      <img style="width: 150px; height: 50px" src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${imagePath}" alt="${product.name}">
                            </c:forEach>
            <input type="hidden" id="id" name="id" value="${product.id}">
                                    <a href="/product-detailsPrincipal?id=${product.id}">Detalhes</a>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
    </body>
    </html>
