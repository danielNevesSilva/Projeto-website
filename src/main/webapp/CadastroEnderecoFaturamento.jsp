<!DOCTYPE html>
<html>
<head>
    <title>Endereco de Faturamento</title>
</head>
<body>
    <h1> Endereco de Faturamento</h1>
    <form action="/create-endereco-faturamento" method="post">


        <label for="cep">CEP:</label>
        <input type="text" id="cep" name="cep" value="${param.cep}"><br>

        <label for="rua">Rua:</label>
        <input type="text" id="rua" name="rua" value="${param.rua}"><br>

        <label for="numero">Número:</label>
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
