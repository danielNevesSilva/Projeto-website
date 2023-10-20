<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/login.css">
    <title>Login do Cliente</title>
</head>

<body>

<!-- Início Menu -->
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

<div class="principal">
    <div class="cadastro">
        <form action="/loginCliente" method="post">
            <h1>Acesse a sua conta</h1>

            <span>${requestScope.message}</span>

            <p>
                <label for="email">Email</label>
                <input id="email" name="email" required="required" type="text" placeholder="Email" />
            </p>

            <p>
                <label for="password">Senha</label>
                <input id="password" name="password" required="required" type="password" placeholder="********" />
            </p>

            <button class="botao-login" type="submit">Login</button>
        </form>

        <p class="link">
            <a href="CadastroCliente.jsp">Cadastre-se</a>
        </p>

    </div>
</div>

<div class="footer"></div><!-- Fim do Formulário de Login -->

<div class="footer"></div>

<script type="text/javascript" src="./javascript/index.js"></script>
<script src="javascript/voltar.js"></script>
<script src="javascript/buscaCep.js"></script>

</body>

</html>
