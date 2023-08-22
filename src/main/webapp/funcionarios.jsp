<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="stylesheet" href="./styles/funcionario.css">
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
  <div>
  <div class = "navbar">
   <span>${sessionScope.nome}</span>
 <p>  <a href="index.html">INICIO</a></p>
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
            <th>status</th>
            <th>Grupo</th>

        </tr>
      <c:forEach var="funcionario" items="${funcionarios}">
                      <tr>
                          <td></td>
                          <td>${funcionario.username}</td>
                          <td>${funcionario.email}</td>
                          <td>${funcionario.funcao}</td>
                          <TD>${funcionario.status}</td>
                          <td>
                              <button type="button" onclick="alterarStatus(${funcionario.id}, '${funcionario.status}')">${funcionario.status}</button>
                          </td>


                         <td>
                                             </a>
                                             <form action="/Alterar" method="post">
             <input type="hidden" id="id" name="id" value="${funcionario.id}">
                   <button type="submit">Delete</button>
                    <span> | </span>
              <button style="background-color: orange;"><a href="index.jsp?id=${funcionario.id}&username=${funcionario.username}&email=${funcionario.email}">Alterar</a>   </button>                                                                                                        </form>
                         </td>
                      </tr>
                   </c:forEach>

                   <script>
                       function alterarStatus(id, statusAtual) {

                           var url = "/alterarStatusFuncionario?id=" + id;
                   </script>

    </table>
  </div>
</body>
</html>