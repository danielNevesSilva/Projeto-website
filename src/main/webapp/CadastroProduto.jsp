<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produto</title>
</head>
<body>
    <h1>Cadastro de Produto</h1>
    <form action="create-product" method="post" enctype="multipart/form-data">
        <label for="name">Nome do Produto:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="description">Descrição:</label>
        <textarea id="description" name="description" rows="4" required></textarea><br><br>

        <label for="amount">Quantidade:</label>
        <input type="number" id="amount" name="amount" step="1" required><br><br>

        <label for="price">Preço:</label>
        <input type="number" id="price" name="price" step="0.01" required><br><br>


        <label for="images">Imagens do Produto:</label>
        <input type="file" id="images" name="images[]" accept="image/*" multiple required><br><br>

        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
