<html>
<body>
 <form action="/create-account" method="post">

    <!-- FORMULÁRIO DE CADASTRO -->
    <form method="post" action="">
        <h1>Cadastro</h1>

        <p>
            <label for="username">Nome</label>
            <input id="username" name="username" required="required" type="text" placeholder="  nome" value="${param.username}" />
        </p>

        <p>
            <label for="email">E-mail</label>
            <input id="email" name="email" required="required" type="email" placeholder="  contato@htmlecsspro.com" value="${param.email}" />
        </p>

        <p>
            <label for="cpf">CPF</label>
            <input id="cpf" name="cpf" required="required" type="text" placeholder="111.222.333-11" oninput="formatarCPF(this)" value="${param.cpf}" />
        </p>

        <script>
            function formatarCPF(campo) {
                var cpf = campo.value.replace(/\D/g, ''); // Remove todos os caracteres não numéricos

                if (cpf.length > 11) {
                    cpf = cpf.slice(0, 11);
                }

                cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');

                campo.value = cpf;
            }
        </script>

        <p>
            <label for="password">Senha</label>
            <input id="password" name="password" required onchange="validarSenhas()" type="password" placeholder="********" value="${param.password}" />
        </p>

        <p>
            <label for="confirmPassword">Confirme a Senha</label>
            <input id="confirmPassword" name="confirmPassword" required onchange="validarSenhas()" type="password" placeholder="********" />
        </p>

        <script>
            function validarSenhas() {
                const senha1 = document.getElementById('password');
                const senha2 = document.getElementById('confirmPassword');

                if (senha1.value === senha2.value) {
                    senha2.setCustomValidity(''); // Senhas conferem
                } else {
                    senha2.setCustomValidity('As senhas não conferem');
                }
            }
        </script>

        <input type="hidden" id="id" name="id" value="${param.id}">
        <button class="botao-cadastro" type="submit" value="Cadastrar">Cadastrar</button>
    </form>
</body>
</html>
