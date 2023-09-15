<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Cadastrar Produto</title>
  <link rel="stylesheet" href="styles/cadastroProduto.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <style>
    .destaque {
      border: 2px solid red;
    }

    .imgthumbnail:hover {
      cursor: pointer;
      opacity: 0.7;
    }
  </style>
</head>
<body>

    <h1>Cadastro de Produto</h1>

<form action="create-product" method="post" enctype="multipart/form-data">
<div class="form-group">
    <label for="name">Nome do Produto:</label>
    <input type="text" id="name" name="name" value="${param.name}"  required>
</div>
<div class="form-group">
    <label for="description">Detalhes do Produto:</label>
    <textarea id="description" name="description" rows="4" cols="50"  required>${param.description}</textarea>
</div>

<div class="form-group">
    <label for="amount">Quantidade:</label>
    <input type="number" id="amount" name="amount" step="1" value="${param.amount}" required>
</div>

<div class="form-group">
    <label for="price">Valor:</label>
    <input type="number" id="price" name="price" step="0.01" value="${param.price}"  required>
</div>

<div class="form-group">
    <label for="rating">Avaliação:</label>
    <input type="number" id="rating" name="rating" step="1" value="${param.avaliacao}" required>
    <button type="button" id="decrease-rating">-</button>
    <button type="button" id="increase-rating">+</button>
</div>

</div>
    <div class="mb-3">
      <label for="images" class="form-label">Selecione imagens</label>
      <input class="form-control" type="file" id="images" name="images[]" accept="image/*" multiple onchange="handleFiles(this.files)"/>
    </div>



    <div class="row mt-3" id="thumbnails"></div>
    <input type="hidden" id="selectedImage" name="selectedImage" value="${product.imageDefault}"/>
    <input type="hidden" id="id" name="id" value="${param.id}">
       <input type="submit" id="btn-cadastrar" value="Cadastrar">
    <a href="/products"" class="btn btn-secondary">Cancelar</a>
  </form>
</div>

<script>
  function handleFiles(files) {
    const thumbnailsDiv = document.getElementById("thumbnails");

    // Limpa a área de miniaturas
    thumbnailsDiv.innerHTML = "";

    // Loop através das imagens carregadas
    for (let i = 0; i < files.length; i++) {
      const file = files[i];

      const thumbnail = document.createElement("div");
      thumbnail.className = "col-3";

      // Cria um elemento de imagem
      const image = document.createElement("img");
      image.className = "img-thumbnail imgthumbnail";
      image.src = URL.createObjectURL(file);
      console.log(image.className + file.name)

      image.onclick = function () {
        image.classList.add("destaque");
        document.getElementById("selectedImage").value = file.name;
      }

      thumbnail.appendChild(image);

      // Adiciona a miniatura à área de miniaturas
      thumbnailsDiv.appendChild(thumbnail);
    }
  }
</script>


<script src="javascript/avaliacao.js"></script>
<script src="javascript/voltar.js"></script>
<script src="javascript/ImagemPrincipal.js" deref></script>
</body>
</html>