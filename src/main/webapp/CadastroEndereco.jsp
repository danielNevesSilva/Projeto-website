
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/CadastroCliente.css">
  <title>Cadastro do endereço</title>
</head>

<body>

<header>
  <div class="container">

  </div>
</header>

<div class="principal">

  <div class="cadastro">

    <form action="/cadastro-endereco" method="post" id="addressForm">
      <h1>Cadastro do Endereco</h1>
      <span>${requestScope.message}</span>


  <div id="addressInputs">

      <div class="maisEremove">
            <button class="botao-mais" type="button" onclick="duplicateAddress()">+</button>
            <button class="botao-remove" type="button" onclick="removeAddress(this)">-</button>
        </div>

        <p>
          <label for="cep">CEP</label>
          <input id="cep" name="cep" required="required" type="text" placeholder="Digite o CEP" maxlength="8" value="${param.cep}" />
        </p>

        <p>
          <label for="rua">Rua</label>
          <input id="rua" name="rua" required="required" type="text" placeholder="Nome da Rua" value="${param.rua}" />
        </p>
        <p>
          <label for="numero">Número</label>
          <input id="numero" name="numero" required="required" type="text" placeholder="Número" value="${param.numero}" />
        </p>
        <p>
          <label for="bairro">Bairro</label>
          <input id="bairro" name="bairro" required="required" type="text" placeholder="Nome do Bairro" value="${param.bairro}" />
        </p>

        <p>
          <label for="cidade">Cidade</label>
          <input id="cidade" name="cidade" required="required" type="text" placeholder="Nome da Cidade" value="${param.cidade}" />
        </p>

        <p>
          <label for="estado">UF</label>
          <input id="estado" name="estado" required="required" type="text" placeholder="Estado" value="${param.uf}" />
        </p>

        <p>
          <label for="bairro">Logradouro</label>
          <input id="bairro" name="bairro" required="required" type="text" placeholder="Complemento" value="${param.bairro}" />
        </p>


      <input type="hidden" id="id" name="id" value="${param.id}">
      <button class="botao-cadastro" type="submit" value="Cadastrar">Cadastrar</button>
    </form>
</div>
  </div>
</div>

<div class="footer"></div>

<script type="text/javascript" src="./javascript/index.js"></script>
<script src="javascript/voltar.js"></script>
<script src="javascript/buscaCep.js"></script>
<script src="javascript/enderecoFat.js"></script>
<script src="javascript/volarLogin.js"></script>
<script src="javascript/novoEndereco.js"></script>

</body>

</html>
