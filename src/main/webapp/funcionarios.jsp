<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="stylesheet" href="./styles/funcionario.css">
    <meta charset="UTF-8">
    <title>Funcionarios</title>
</head>
<body>
  <div>
  <div class = "navbar">
   <span>${sessionScope.nome}</span>
 <p>  <a href="index.jsp">INICIO</a></p>
 <p>  <a href="produto.jsp">Adicione Produto</a></p>
 <p> <a href="cadastro.jsp"> Adicione usuario</a></p>
    <p><a href="/funcionarios">Lista de Funcionarios</a></p>
    <p><a href="/produtos">Lista de produtos</a></p>
         <p><a href="/logout">Logout</a></p>

</div>
    <h1>Funcionarios</h1>

    <table>

        <tr>
        <th> </th>
            <th>Nome</th>
            <th>Email</th>
            <th>Grupo</th>
            <th>Status</th>
        </tr>

         <form action="/filtrar-funcionarios" method="get">
                <h3>Pesquisar Nome:</h3>
                <input id="username" name="username" required="required" type="text" placeholder="  nome" value="${param.username}"/>
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
              <button style="background-color: orange;"><a href="alterar.jsp?id=${funcionario.id}&username=${funcionario.username}&funcao=${funcionario.funcao}&status=${funcionario.status}">Alterar</a></button>                                                                                                        </form>
                         </td>
                      </tr>
                   </c:forEach>


               </form>
    </table>
  </div>
  </c:if>
<script type="text/javascript" src="./javascript/index.js">

</script>
</body>
</html>