
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <body>

        <form action="/update" method="post">

                   <h1>Alterar</h1>

          <input type="hidden" name="id" id="id" value="${param.id}" />

           <p>
               <label for="username">Nome</label>
                 <input id="username" name="username" required="required" type="text" placeholder="  nome" value="${param.username}" />
           </p>


                   <select id="funcao" name="funcao" required="required"
                    <option value="${param.funcao}"></option>
                      <option value="Estoquista">Estoquista</option>
                      <option value="Admin">Admin</option>
                   </select>

                   <select id="status" name="status" required="required">
                      <option value="Ativo">Ativo</option>
                      <option value="Desativado">Desativado</option>
                   </select>

                 <button type="submit">Salvar</button>

             <a href="funcionarios.jsp"></a>
        </form>
    </body>
</html>