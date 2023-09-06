<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/teste2.css">
    <title>Funcionarios</title>
  </head>

  <body>
    <div>
      <!--
      <div class="navbar">
        <span>${sessionScope.nome}</span>
        <p> <a href="index.jsp">Inicio</a></p>
        <p> <a href="dashboard.jsp">Backoffice</a></p>
        <p> <a href="cadastro.jsp"> Adicione usuario</a></p>
        <p><a href="/funcionarios">Lista de Funcionarios</a></p>
        <p><a href="/logout">Logout</a></p>
      </div>
  -->

      <!-- Botão Voltar -->
      <div class="voltar">
        <a href="#" class="btn-voltar" id="btn-voltar">Voltar</a>
      </div>

      <h1 class="titulo">Funcionarios</h1>

      <table>

        <tr>
          <th> </th>
          <th>Nome</th>
          <th>Email</th>
          <th>Grupo</th>
          <th>Status</th>
        </tr>

        <form action="/filtrar-funcionarios" method="get">
          <h3 class="">Pesquisar Nome:</h3>
          <input id="username" name="username" required="required" type="text" placeholder="  nome"
            value="${param.username}" />
          <button type="submit">Pesquisar</button>

          <c:if test="${empty funcionarios}">
            <p>Nenhum funcionário encontrado.</p>
          </c:if>

          <c:if test="${not empty funcionarios}">

        </form>

        <c:forEach var="funcionario" items="${funcionarios}">
          <tr>
            <td></td>
            <td>${funcionario.username}</td>
            <td>${funcionario.email}</td>
            <td>${funcionario.funcao}</td>
            <Td>${funcionario.status}</td>

            <td>
              </a>
              <form action="/Alterar" method="post">
                <input type="hidden" id="id" name="id" value="${funcionario.id}">
                <button onclick="alterarStatus(${funcionario.id}, '${funcionario.status}')">Alterar Status</button>
                <button style="background-color: orange;"><a
                    href="cadastro.jsp?id=${funcionario.id}&username=${funcionario.username}&email=${funcionario.email}&cpf=${funcionario.cpf}">Alterar</a></button>
              </form>
            </td>
          </tr>
        </c:forEach>


        </form>
      </table>
    </div>
    </c:if>

    <div class="pagination">
      <button id="prevPage">Anterior</button>
      <button id="nextPage">Próxima</button>
    </div>

    <script type="text/javascript" src="./javascript/index.js"></script>
    <script src="javascript/voltar.js"></script>
    <script src="javascript/paginacao-funcionario.js"></script>
  </body>

</html>