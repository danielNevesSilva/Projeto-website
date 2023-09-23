    <!DOCTYPE html>
    <html lang="pt-br">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/menu.css">
        <link rel="stylesheet" href="styles/carrossel.css">
        <title>Listagem de Produtos (Admin)</title>
    </head>

    <body>

    <header>
        <div class="container">

            <div class="logo">
                <a href="./index.html"><img src="./img-logo/Logo_1.jpg" alt=""></a>
            </div>

            <div class="menu">
                <nav>
                    <a href="/Oferta-de-camisas">CAMISAS</a>
                    <a href="https://web.whatsapp.com/send?phone=5511996701549" target="_blank">CONTATO</a>
                    <a href="/Avaliacoes">AVALIACOES</a>
                    <a href="./time.html">QUEM SOMOS</a>
                </nav>
            </div>

            <div>
                <%--Pesquisa de Produtos se inicia a partir desse ponto--%>
<div>
                <form action="/produtos" method="get">

                    <div class="buscar_produtos">
<%--                    <h3 class="">Buscar produtos:</h3>--%>

                    <input id="name" name="name" type="text" placeholder="  Nome do produto"
                           value="${param.name}" />

                    <button type="submit">Pesquisar</button>
                    </div>

                    <c:if test="${empty Products}">
                       <div class="status_busca">
                        <p>Nenhum Produto encontrado.</p>
                       </div>
                    </c:if>
                    <c:forEach var="product" items="${Products}">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.amount}</td>

                        <td class="price">R$ ${product.price}</td>
                        <td>
                        </td>
</div>

                        <c:forEach var="imagePath" items="${product.images}">
                        <img style="width: 150px; height: 50px" src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${imagePath}" alt="${product.name}">
                        </c:forEach>
                        <input type="hidden" id="id" name="id" value="${product.id}">
                        <a href="/product-detailsPrincipal?id=${product.id}">Detalhes</a>
                </form>
                </td>
                </tr>
                </c:forEach>
                <%--    Pesquisa de Produto é finalizada nesse ponto.--%>
            </div>

            <div class="login">
                <a href="./login.jsp"> <img src="./assets/images/login.svg" alt=""></a>
            </div>

        </div>

    </header>

    <section class="slider">
        <div class="slider-content">
            <!--Radio Buttons-->
            <input type="radio" name="radio-btn" id="radio1">
            <input type="radio" name="radio-btn" id="radio2">
            <input type="radio" name="radio-btn" id="radio3">

            <div class="slide-box">
                <div class="slide">
                    <img class="img-desktop" src="img-logo/helldivers.png" alt="">
                </div>
                <div class="slide">
                    <img class="img-desktop" src="img-logo/NBA.png" alt="">
                </div>
                <div class="slide">
                    <img class="img-desktop" src="img-logo/honkai.png" alt="">
                </div>
            </div>

            <div class="nav-auto">
                <div class="auto-btn1"></div>
                <div class="auto-btn2"></div>
                <div class="auto-btn3"></div>
            </div>

            <div class="nav-manual">
                <label for="radio1" class="manual-btn"></label>
                <label for="radio2" class="manual-btn"></label>
                <label for="radio3" class="manual-btn"></label>
            </div>
        </div>
    </section>

    <h1> LEO, SEU CODIGO INICIA AQUI</h1>


    <script src="javascript/carrosel.js"></script>

    </body>
    </html>
