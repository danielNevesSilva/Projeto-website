    <!DOCTYPE html>
    <html lang="pt-br">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/landing.css">
        <link rel="stylesheet" href="styles/carrossel.css">
        <link rel="stylesheet" href="styles/index.css">
        <link rel="stylesheet" href="styles/cards.css">
        <title>Listagem de Produtos (Admin)</title>
    </head>

    <body>

    <header>
        <div class="container">

            <div class="logo">
                <a href="#"><img src="./img-logo/Logo_1.jpg" alt=""></a>
            </div>

            <div class="menu">
                <nav>
                    <a href="/Oferta-de-camisas"></a>
                    <a href="https://web.whatsapp.com/send?phone=5511996701549" target="_blank"></a>
                    <a href="/Avaliacoes"></a>
                    <a href="./time.html"></a>
                </nav>

                <div class="car">
                    <a href="#"><img src="img-logo/shopping-cart.png"></a>
                </div>

                <div class="login">
                    <a href="./LoginCliente.jsp"><img src="img-logo/login-.png" alt=""></a>
                </div>

            </div>


            <div>
<%--                &lt;%&ndash;Pesquisa de Produtos se inicia a partir desse ponto&ndash;%&gt;--%>
<%--<div>--%>
<%--                <form action="/produtos" method="get">--%>

<%--                    <div class="buscar_produtos">--%>
<%--&lt;%&ndash;                    <h3 class="">Buscar produtos:</h3>&ndash;%&gt;--%>

<%--                    <input id="name" name="name" type="text" placeholder="  Nome do produto"--%>
<%--                           value="${param.name}" />--%>

<%--                    <button type="submit">Pesquisar</button>--%>
<%--                    </div>--%>

<%--                    <c:if test="${empty Products}">--%>
<%--                       <div class="status_busca">--%>
<%--                        <p>Nenhum Produto encontrado.</p>--%>
<%--                       </div>--%>
<%--                    </c:if>--%>
<%--                    <c:forEach var="product" items="${Products}">--%>
<%--                    <tr>--%>
<%--                        <td>${product.name}</td>--%>
<%--                        <td>${product.amount}</td>--%>

<%--                        <td class="price">R$ ${product.price}</td>--%>
<%--                        <td>--%>
<%--                        </td>--%>
<%--</div>--%>

<%--                        <c:forEach var="imagePath" items="${product.images}">--%>
<%--                        <img style="width: 150px; height: 50px" src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${imagePath}" alt="${product.name}">--%>
<%--                        </c:forEach>--%>
<%--                        <input type="hidden" id="id" name="id" value="${product.id}">--%>
<%--                        <a href="/product-detailsPrincipal?id=${product.id}">Detalhes</a>--%>
<%--                </form>--%>
<%--                </td>--%>
<%--                </tr>--%>
<%--                </c:forEach>--%>
<%--                &lt;%&ndash;    Pesquisa de Produto é finalizada nesse ponto.&ndash;%&gt;--%>
<%--            </div>--%>




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

    <div>
        <h1>Adquira nossos jogos!</h1>
    </div>


    <form action="/produtos" method="get">
        <c:if test="${empty Products}">
            <div class="status_busca">
                <p>Nenhum Produto encontrado.</p>
            </div>
        </c:if>
        <div class="row">
            <c:forEach var="product" items="${Products}">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${product.images[0]}" class="card-img-top" alt="${product.name}">
                        <div class="card-body">
                            <h3 class="card-title">${product.name}</h3>
                            <h5 class="card-text">R$ ${product.price}</h5>
                            <a href="/product-detailsPrincipal?id=${product.id}" class="btn btn-primary">Detalhes</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </form>

    <script src="javascript/carrosel.js"></script>

    </body>
    </html>
