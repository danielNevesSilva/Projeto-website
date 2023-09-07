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
            <input type="text" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label for="description">Detalhes do Produto:</label>
            <textarea id="description" name="description" rows="4" required></textarea>
        </div>

        <div class="form-group">
            <label for="amount">Quantidade:</label>
            <input type="number" id="amount" name="amount" step="1" required>
        </div>

        <div class="form-group">
            <label for="price">Valor:</label>
            <input type="number" id="price" name="price" step="0.01" required>
        </div>

        <div class="form-group">
        <label for="rating">Avaliação:</label>
        <input type="number" id="rating" name="rating" step="1" readonly>
        <button type="button" id="decrease-rating">-</button>
        <button type="button" id="increase-rating">+</button>
        </div>

        <div class="form-group">
            <label for="images">Imagens do Produto:</label>
            <input type="file" id="images" name="images[]" accept="image/*" multiple required>
            <small>Segure a tecla Ctrl (Windows) ou Command (Mac) para selecionar diversas imagens.</small>
        </div>

        <div class="form-group">
            <input type="submit" id="btn-cadastrar" value="Cadastrar">
        </div>
    </form>

    <script src="javascript/avaliacao.js"></script>
    <script src="javascript/voltar.js"></script>
</body>

</html>