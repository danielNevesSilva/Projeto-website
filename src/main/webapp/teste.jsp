<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/CadastroCliente.css">
    <title>Cadastro de Endereco</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body class="p-3 m-0 border-0 bd-example m-0 border-0">

    <div class="principal">

        <div class="cadastro">

            <form action="/cadastro-endereco" method="post" id="addressForm">
                <h1>Cadastro do Endereco</h1>
                <span>${requestScope.message}</span>

                <p>
                    <label for="cep">CEP</label>
                    <input id="cep" name="cep" required="required" type="text" placeholder="Digite o CEP" maxlength="8"
                        value="${param.cep}" />
                </p>

                <p>
                    <label for="rua">Rua</label>
                    <input id="rua" name="rua" required="required" type="text" placeholder="Nome da Rua"
                        value="${param.rua}" />
                </p>

                <p>
                    <label for="numero">Número</label>
                    <input id="numero" name="numero" required="required" type="text" placeholder="Número"
                        value="${param.numero}" />
                </p>

                <p>
                    <label for="bairro">Bairro</label>
                    <input id="bairro" name="bairro" required="required" type="text" placeholder="Nome do Bairro"
                        value="${param.bairro}" />
                </p>

                <p>
                    <label for="cidade">Cidade</label>
                    <input id="cidade" name="cidade" required="required" type="text" placeholder="Nome da Cidade"
                        value="${param.cidade}" />
                </p>

                <p>
                    <label for="estado">UF</label>
                    <input id="estado" name="estado" required="required" type="text" placeholder="UF"
                        value="${param.uf}" />
                </p>

                <p>
                    <label for="logradouro">Logradouro</label>
                    <input id="logradouro" name="logradouro" required="required" type="text" placeholder="Complemento"
                        value="${param.bairro}" />
                </p>
            </form>
        </div>



        <!-- Example Code -->

        <p class="d-inline-flex gap-1">
            <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button"
                aria-expanded="false" aria-controls="collapseExample">
                Endereco para Fatura
            </a>
        </p>
        <div class="collapse" id="collapseExample">
            <div class="card card-body">


                <div class="principal">
                    <div class="cadastro">

                        <form action="/cadastro-endereco" method="post" id="addressForm">
                            <h1>Endereco da Fatura</h1>
                            <span>${requestScope.message}</span>

                            <p>
                                <label for="cep">CEP</label>
                                <input id="cep" name="cep" required="required" type="text" placeholder="Digite o CEP"
                                    maxlength="8" value="${param.cep}" />
                            </p>

                            <p>
                                <label for="rua">Rua</label>
                                <input id="rua" name="rua" required="required" type="text" placeholder="Nome da Rua"
                                    value="${param.rua}" />
                            </p>

                            <p>
                                <label for="numero">Número</label>
                                <input id="numero" name="numero" required="required" type="text" placeholder="Número"
                                    value="${param.numero}" />
                            </p>

                            <p>
                                <label for="bairro">Bairro</label>
                                <input id="bairro" name="bairro" required="required" type="text"
                                    placeholder="Nome do Bairro" value="${param.bairro}" />
                            </p>

                            <p>
                                <label for="cidade">Cidade</label>
                                <input id="cidade" name="cidade" required="required" type="text"
                                    placeholder="Nome da Cidade" value="${param.cidade}" />
                            </p>

                            <p>
                                <label for="estado">UF</label>
                                <input id="estado" name="estado" required="required" type="text" placeholder="UF"
                                    value="${param.uf}" />
                            </p>

                            <p>
                                <label for="logradouro">Logradouro</label>
                                <input id="logradouro" name="logradouro" required="required" type="text"
                                    placeholder="Complemento" value="${param.bairro}" />
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="principal">
            <div class="cadastro">

                <input type="hidden" id="id" name="id" value="${param.id}">
                <button class="botao-cadastro" type="submit" value="Cadastrar">Cadastrar</button>

            </div>
        </div>
        <script src="javascript/buscaCep.js"></script>
        <script src="javascript/novoEndereco.js"></script>
</body>

</html>