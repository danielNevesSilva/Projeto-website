<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="stylesheet" href="Dashbord.css">
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
    <p><a href="/Cadastros">Lista de Usuarios</a></p>
    <p><a href="/Lista-de-camisas">Lista de produtos</a></p>
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
      <c:forEach var="Funcionario" items="${Funcionarios}">
                      <tr>
                          <td></td>
                          <td>${Funcionario.username}</td>
                          <td>${Funcionario.email}</td>
                          <td>${Funcionario.funcao}</td>
                         <td>
                                             </a>
                                             <form action="/Alterar" method="post">
             <input type="hidden" id="id" name="id" value="${Funcionario.id}">
                   <button type="submit">Delete</button>
                    <span> | </span>
              <button style="background-color: orange;"><a href="produto.jsp?id=${Produto.id}&ano_camisa=${Produto.anoCamisa}&nome_camisa=${Produto.nomeCamisa}&tamanho=${Produto.tamanho}&valor_produto=${Produto.valorProduto}&quantidade=${Produto.quantidade}&image=${Produto.image}">Alterar</a>   </button>                                                                                                        </form>
                         </td>
                      </tr>
                   </c:forEach>
    </table>
  </div>
</body>
</html>