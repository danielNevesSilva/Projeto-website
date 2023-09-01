<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/login.css">

    <title>Login</title>
</head>
<body>
<!--Inicio Menu-->
<header>
    <div class="container">

        <div class="logo">
            <a href="./index.html"><img src="./assets/images/urso_logo.png" alt=""></a>
        </div>

        <div class="menu">
            <nav>
          <!-- <a href="index.jsp">INICIO</a>
                <a href="https://web.whatsapp.com/send?phone=5599111112222" target="_blank">CONTATO</a>
                <a href="/Oferta-de-camisas">CAMISAS</a>
                <a href="/Lista-de-camisas">ADMIN</a> -->


            </nav>
        </div>

        <div class="login">
            <a href="./login.jsp"> <img src="./assets/images/login.svg" alt=""></a>
        </div>

    </div>

</header>

<!--Final Menu-->

      <div class="principal">
          <div class="cadastro">

                      <span>${requestScope.message}</span>

                  <form action="/login" method="post">
                      <h1>Acesse sua conta</h1>

                      <p>
                          <label for="email">Email</label>
                          <input id="email" name="email" required="required" type="text" placeholder="Email" />
                      </p>


                      <p>
                          <label for="password">Senha</label>
                          <input id="password" name="password" required="required" type="password" placeholder="********" />
                      </p>

                            <button class="botao-login" input type="submit" value="Login">Login</button>

                  </form>

          </div>
          </form>

      </div>


</body>

</html>