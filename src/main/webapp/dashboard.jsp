<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/teste.css">
    <title>Backoffice</title>
  </head>

  <body>
    <div class="geral">
      <header class="topo">
        <h1>Bem-vindo ao Backoffice</h1>
      </header>

      <div class="principal">
        <div class>
          <nav>

            <c:if test="${sessionScope.tipoUsuario   eq 'Admin'}">
              <a href="/funcionarios"><button class="btn">Funcionarios</button></a>
              <a href="cadastro.jsp"><button class="btn">Novo funcionario</button></a>
              <a href="Produtos.jsp"><button class="btn">Lista de produtos</button></a>
              <a href="CadastroProduto.jsp"><button class="btn">Novo produtos</button></a>


            </c:if>
            <c:if test="${sessionScope.tipoUsuario   eq 'Estoquista'}">
              <a href="CadastroProduto.jsp"><button class="btn">Produtos</button></a>
            </c:if>

          </nav>

          <section>
            <figure>
              <img src="img-logo/logo_PT4.png" alt="logo">
            </figure>
          </section>
          </section>

        </div>
      </div>

      
  </body>

</html>