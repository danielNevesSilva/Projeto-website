<!DOCTYPE html>
<html>

<head>
    <title>Endereço de entrega</title>
    <link rel="stylesheet" type="text/css" href="CadastroCliente.css">
    <link rel="stylesheet" href="styles/CadastroCliente.css">
    <title>Cadastro de Endereco</title>
    <style>
        /* Estilos para a caixa de diálogo modal */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.7);
        }

        .modal-content {
            background-color: #fff;
            text-align: center;
            padding: 20px;
            border-radius: 5px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        .modal-buttons {
            margin-top: 20px;
        }
    </style>
</head>

<body>
    <div class="principal">
        <div class="cadastro">
            <h1>Endereço de entrega</h1>

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
            </form>

            <!-- Div para exibir a mensagem após o cadastro -->
            <div id="mensagemCadastro" style="display: none; color: green;">
                Cadastro concluído. Deseja inserir um novo endereço?
            </div>


        </div>
    </div>

    <!-- Modal de confirmação -->
    <div id="modalConfirmacao" class="modal">
        <div class="modal-content">
            <p>Cadastro concluído. Deseja inserir um novo endereco?</p>
            <div class="modal-buttons">
                <button type="button" onclick="redirecionarParaCadastroEnderecoFaturamento()">Não</button>
                <button type="submit" onclick="redirecionar()">Sim</button>
            </div>
        </div>
    </div>

    <script src="javascript/buscaCep.js"></script>
    <script>
        function exibirMensagem() {
            const modal = document.getElementById("modalConfirmacao");
            modal.style.display = "block";
        }

        function fecharModal() {
            const modal = document.getElementById("modalConfirmacao");
            modal.style.display = "none";
        }

        function redirecionar() {
            window.location.href = "/CadastroEnderecoEntrega.jsp";
        }

          function redirecionarParaCadastroEnderecoFaturamento() {
                window.location.href = "/CadastroEnderecoFaturamento.jsp";
            }
    </script>

    function exibirMensagem() {
        const modal = document.getElementById("modalConfirmacao");


        setTimeout(function () {
            modal.style.display = "block";
        }, 1000000000);
    }
</body>

</html>
