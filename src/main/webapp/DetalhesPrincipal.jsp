<!DOCTYPE html>
<html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/produto-detalhes.css">
        <link rel="stylesheet" type="text/css"
            href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css">
        <link rel="stylesheet" type="text/css"
            href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css">
    </head>

    <body>

        <!-- Botão Voltar -->
       <div class="titulo">
                   <h1> Detalhes do produto </h1>
                   <a href="#" class="btn-voltar" id="btn-voltar">Voltar</a>
               </div>

        <c:if test="${not empty product}">
            <div class="product-details">
                <div class="images">
                    <div class="carousel-container">
                        <c:forEach var="imagePath" items="${product.imagePaths}">
                            <div class="carousel-item">
                               <img src="${pageContext.request.contextPath}/${imagePath}" alt="${product.name}">
                            </div>
                        </c:forEach>
                    </div>
                </div>



                <div class="description-box">
                    <h2>${product.name}</h2>
                    <p class =" ID">ID: ${product.id}</p>
                    <p class = "Quantidade">Quantidade: ${product.amount}</p>
                    <p class = "Preco">Preco: R$ ${product.price}</p>
                    <p class = "Avaliação">Avaliacao: ${product.avaliacao}</p>


                    <p class = "Descricao">Descricao: ${product.description}</p>
                    <form action="/comprar" method="post">
                        <input type="hidden" name="productId" value="${product.id}">
                        <button type="submit" disabled>Comprar</button>
                    </form>
                </div>
            </div>
        </c:if>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
        <script src="javascript/carrossel.js"></script>
        <script src="javascript/voltar.js"></script>


         <footer>
                <div class="rodape-container">
                    <div class="rodape-content">

                    </div>
                </div>
            </footer>

    </body>

</html>