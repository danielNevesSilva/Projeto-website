<!DOCTYPE html>
<html>
<head>
    <title>Endereço de entrega</title>
        <link rel="stylesheet" type="text/css" href="CadastroCliente.css">

</head>

    <h1> Endereco de entrega</h1>
    <form action="/create-endereco-entrega" method="post">

        <label for="cep">CEP:</label>
        <input type="text" id="cep" name="cep" value="${param.cep}"><br>

        <label for="rua">Rua:</label>
        <input type="text" id="rua" name="rua" value="${param.rua}"><br>

        <label for="numero">Numero:</label>
        <input type="text" id="numero" name="numero" value="${param.numero}"><br>

        <label for="bairro">Bairro:</label>
        <input type="text" id="bairro" name="bairro" value="${param.bairro}"><br>

        <label for="cidade">Cidade:</label>
        <input type="text" id="cidade" name="cidade" value="${param.cidade}"><br>

        <label for="uf">UF:</label>
        <input type="text" id="uf" name="uf" value="${param.uf}"><br>

        <label for="logradouro">Logradouro:</label>
        <input type="text" id="logradouro" name="logradouro" value="${param.logradouro}"><br>

       <input type="hidden" id="id" name="id" value="${param.id}">
       <button class="botao-cadastro" type="submit" value="Cadastrar">Cadastrar</button>
    </form>


</body>
</html>