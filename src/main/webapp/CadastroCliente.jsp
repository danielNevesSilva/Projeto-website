<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/CadastroCliente.css">
    <title>Cadastro Cliente</title>
</head>

<body>

<!--Inicio Menu-->
<header>
    <div class="container">

        <div class="logo">
            <a href="./index.html"><img src="./assets/images/urso_logo.png" alt=""></a>
        </div>

        <div class="login">
            <a href="./login.jsp"> <img src="./assets/images/login.svg" alt=""></a>
        </div>

    </div>

</header>

<!-- Botão Voltar -->
<div class="voltar">
    <a href="#" class="btn-voltar" id="btn-voltar">Voltar</a>
</div>

<!--Final Menu-->

<div class="principal">
    <div class="cadastro">

        <form action="/create-accountcliente" method="post">
            <h1>Cadastro do Cliente</h1>
            <span>${requestScope.message}</span>

            <p>
                <label for="username">Nome</label>
                <input id="username" name="username" required="required" type="text" placeholder="Nome de Usuário" minlength="3" value="${param.username}" />
            </p>
            
            <p>
                <label for="email">E-mail</label>
                <input id="email" name="email" required="required" type="email" placeholder="Insira sei e-mail" value="${param.email}" />
            </p>

            <p>
                <label for="cpf">CPF</label>
                <input id="cpf" name="cpf" required="required" type="text" placeholder="Insira o CPF" oninput="formatarCPF(this)" onblur="validarCPF(this.value)" value="${param.cpf}" />
                <span class="error-message"></span>
            </p>

            <p>
                <label for="gender">Gênero:</label>
                <select id="gender" name="gender">
                  <option value="M">M</option>
                  <option value="F">F</option>
                </select>

            </p>

            <p>
                <label for="birthdate">Data de Nascimento</label>
                <input id="birthdate" name="birthdate" required="required" type="date" value="${param.birthdate}" />
            </p>

            <p>
                <label for="password">Senha</label>
                <input id="password" name="password" required onchange="validarSenhas()" type="password" placeholder="********" value="${param.password}" />
            </p>

            <p>
                <label for="confirmPassword">Confirme a Senha</label>
                <input id="confirmPassword" name="confirmPassword" required onchange="validarSenhas()" type="password" placeholder="********" />
            </p>


                  <%--         <label for="cep">CEP:</label>
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

                        --%>
                    <input type="hidden" id="id" name="id" value="${param.id}">
                   <button class="botao-cadastro" type="submit" value="Cadastrar">Cadastrar</button>

        </form>



<div class="footer"></div>
<script type="text/javascript" src="./javascript/index.js"></script>
<script src="javascript/voltar.js"></script>
        <script src="javascript/buscaCep.js"></script>

</body>

</html>