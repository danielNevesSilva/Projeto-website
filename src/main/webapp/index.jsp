<html>
<body>
 <form action="/create-account" method="post">

                <!--FORMULÁRIO DE CADASTRO-->

                <form method="post" action="">
                    <h1>Cadastro</h1>

                    <p>
                        <label for="username">Nome</label>
                        <input id="username" name="username" required="required" type="text" placeholder="  nome"  value="${param.username}"/>
                    </p>

                      <p>
                        <label for="email">E-mail</label>
                        <input id="email" name="email" required="required" type="email"
                            placeholder="  contato@htmlecsspro.com"  value="${param.email}" />
                    </p>

                    <p>
                        <label for="cpf">CPF</label>
                        <input id="cpf" name="cpf" required="required" type="text"
                            placeholder="111.222.333-11"  value="${param.cpf}" />
                    </p>


                    <p>
                        <label for="password">Senha</label>
                        <input id="password" name="password" required="required" type="password" placeholder="********"  value="${param.password}" />
                    </p>

                    <input type="hidden" id="id" name="id" value="${param.id}">
                        <button class="botao-cadastro" input type="submit" value="Cadastrar" > Cadastrar</button>

                </form>
</body>
</html>
