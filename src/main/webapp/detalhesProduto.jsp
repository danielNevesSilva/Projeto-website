<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Detalhes do Produto</title>
        <link rel="stylesheet" href="styles/produto-detalhes.css">
    </head>

    <body>

        <!-- Botão Voltar -->
        <div class="voltar">
            <a href="#" class="btn-voltar" id="btn-voltar">Voltar</a>
        </div>

        <h1>Detalhes do Produto</h1>

        <div class="product-details">
            <!-- Aqui você pode exibir os detalhes do produto selecionado -->
            <h2>Nome do Produto</h2>
            <p>Detalhes do produto...</p>
            <p>Valor: R$ 99.99</p>
            <p>Quantidade em Estoque: 10</p>
            <p>Avaliação:</p>
            <img src="img/20230904175019785.jpg" alt="Imagem do Produto">
        </div>

        <script src="javascript/voltar.js"></script>
    </body>

</html>