<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/cadastroProduto.css">
    <title>Cadastro de Produto</title>
</head>

<body>

    <!-- Botão Voltar -->
    <div class="voltar">
        <a href="#" class="btn-voltar" id="btn-voltar">Voltar</a>
    </div>

    <h1>Cadastro de Produto</h1>
    <form action="create-product" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Nome do Produto:</label>
            <input type="text" id="name" name="name"  value="${param.name}" required />
        </div>

        <div class="form-group">
            <label for="description">Detalhes do Produto:</label>
            <textarea id="description" name="description" rows="4" value="${param.description}" required></textarea>
        </div>

        <div class="form-group">
            <label for="amount">Quantidade:</label>
            <input type="number" id="amount" name="amount" step="1" value="${param.amount}" required>
        </div>

        <div class="form-group">
            <label for="price">Valor:</label>
            <input type="number" id="price" name="price" step="0.01" value="${param.price}" required>
        </div>

        <div class="form-group">
        <label for="rating">Avaliação:</label>
        <input type="number" id="rating" name="rating" step="1" value="${param.avaliacao}" readonly>
        <button type="button" id="decrease-rating">-</button>
        <button type="button" id="increase-rating">+</button>
        </div>

    <div class="form-group">
        <label>Imagens do Produto:</label>
        <input type="file" id="images" name="mainImage" accept="image/*" multiple required>
        <small>Segure a tecla Ctrl (Windows) ou Command (Mac) para selecionar diversas imagens.</small>
    </div>
</div>

<div class="form-group">
    <label for="mainImages">Imagens Principais:</label>
    <input type="hidden" id="mainImage" name="mainImage" value="0">
    <div id="mainImages">
             <c:forEach var="image" items="${images}">
                            <option value="${image.index}">${image.fileName}</option>
             </c:forEach>
    </div>


    <div class="form-group">
    <input type="hidden" id="id" name="id" value="${param.id}">
        <input type="submit" id="btn-cadastrar" value="Cadastrar">
    </div>

    <a href="/products"><button type="button" style="background-color: red;" >Cancelar cadastro</button>  </a>

    </form>

    <script src="javascript/avaliacao.js"></script>
    <script src="javascript/voltar.js"></script>
    <script src="javascript/ImagemPrincipal.js" deref></script>
</body>

</html>