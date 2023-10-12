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
                <input id="username" name="username" required="required" type="text" placeholder="nome" value="${param.username}" />
            </p>

            <p>
                <label for="email">E-mail</label>
                <input id="email" name="email" required="required" type="email" placeholder="contato@htmlecsspro.com" value="${param.email}" />
            </p>

            <p>
                <label for="cpf">CPF</label>
                <input id="cpf" name="cpf" required="required" type="text" placeholder="111.222.333-11" oninput="formatarCPF(this)" onblur="validarCPF(this.value)" value="${param.cpf}" />
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
                <label for="password">Senha</label>
                <input id="password" name="password" required onchange="validarSenhas()" type="password" placeholder="********" value="${param.password}" />
            </p>

            <p>
                <label for="confirmPassword">Confirme a Senha</label>
                <input id="confirmPassword" name="confirmPassword" required onchange="validarSenhas()" type="password" placeholder="********" />
            </p>

            <input type="hidden" id="id" name="id" value="${param.id}">
            <button class="botao-cadastro" type="submit" value="Cadastrar">Cadastrar</button>

        </form>
        <p class="link">
            <a href="#"><button class="botao-login">Login</button>  </a>
        </p>


<div class="footer"></div>
<script type="text/javascript" src="./javascript/index.js"></script>
<script src="javascript/voltar.js"></script>
        <script src="javascript/buscaCep.js"></script>

</body>

</html>