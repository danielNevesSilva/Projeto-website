<!DOCTYPE html>
<html>

<head>
    <title>Endereço de entrega</title>
    <link rel="stylesheet" type="text/css" href="CadastroCliente.css">
    <link rel="stylesheet" href="styles/CadastroCliente.css">
    <title>Cadastro de Endereco</title>

     <style>
            /* Estilos para o link "Cadastrar endereco para Faturamento" */
            a.cadastrar-faturamento {
                display: inline-block;
                padding: 12px 20px;
                background-color: var(--cor-preta);
                color: var(--cor-branca);
                font-size: 16px;
                font-weight: bold;
                text-decoration: none;
                border-radius: 5px;
                margin-top: 20px;
                transition: background-color 0.3s ease-in-out;
            }

            a.cadastrar-faturamento:hover {
                background-color: var(--cor-cinza-escuro);
            }
        </style>

</head>

<body>
    <div class="principal">
        <div class="cadastro">
            <h1>Endereco de entrega</h1>

            <form action="/create-endereco-entrega" method="post">
                <label for="cep">CEP:</label>
                <input type="text" id="cep" name="cep" required maxlength="8" value="${param.cep}"><br>

                <label for="rua">Rua:</label>
                <input type="text" id="rua" name="rua" required value="${param.rua}"><br>

                <label for="numero">Numero:</label>
                <input type="text" id="numero" name="numero" required value="${param.numero}"><br>

                <label for="bairro">Bairro:</label>
                <input type="text" id="bairro" name="bairro" required value="${param.bairro}"><br>

                <label for="cidade">Cidade:</label>
                <input type="text" id="cidade" name="cidade" required value="${param.cidade}"><br>

                <label for="uf">UF:</label>
                <input type="text" id="uf" name="uf" required value="${param.uf}"><br>

                <label for="logradouro">Logradouro:</label>
                <input type="text" id="logradouro" name="logradouro" value="${param.logradouro}"><br>

                <input type="hidden" id="id" name="id" value="${param.id}">
                <button class="botao-cadastro" type="submit" onclick="exibirMensagem()">Cadastrar</button>

                 <!-- Link para cadastrar endereço de faturamento -->
                 <a class="cadastrar-faturamento" href="CadastroEnderecoFaturamento.jsp">Cadastrar endereco para Faturamento</a>

            </form>

  </div>
    </div>

    <script src="javascript/buscaCep.js"></script>

         <script>
            function exibirMensagem() {
                alert("Endereco cadastrado!");
            }
        </script>


</body>

</html>
