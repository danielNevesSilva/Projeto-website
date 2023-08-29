<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/editar.css">
    <title>Alterar</title>
</head>

<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="principal">
    <form action="/update" method="post">

        <h1 class="alterar">Alterar</h1>

        <input type="hidden" name="id" id="id" value="${param.id}" />

        <div class="secao1">

            <div class="name">
                <p>
                    <label for="username">Nome</label>
                    <input id="username" name="username" required="required" type="text" placeholder="  nome"
                           value="${param.username}" />
                </p>
            </div>

            <div class="funcao_1">
                <select id="funcao" name="funcao" required="required" <option value="${param.funcao}"></option>
                <option value="Estoquista">Estoquista</option>
                <option value="Admin">Admin</option>
                </select>
            </div>

            <div class="status_1">
                <select id="status" name="status" required="required">
                    <option value="Ativo">Ativo</option>
                    <option value="Desativado">Desativado</option>
                </select>
            </div>

            <div class="btn">
                <button type="submit">Salvar</button>
            </div>

        </div>

        <a href="funcionarios.jsp"></a>
    </form>
</div>
</body>

</html>