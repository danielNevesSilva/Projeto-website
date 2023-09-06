document.addEventListener("DOMContentLoaded", function() {
    const funcionarios = document.querySelectorAll(".funcionario");
    const itemsPerPage = 10;
    let currentPage = 0;

    function showPage(page) {
      for (let i = 0; i < funcionarios.length; i++) {
        if (i >= page * itemsPerPage && i < (page + 1) * itemsPerPage) {
          funcionarios[i].style.display = "table-row";
        } else {
          funcionarios[i].style.display = "none";
        }
      }
    }

    function updateButtons() {
      document.getElementById("prevPage").disabled = currentPage === 0;
      document.getElementById("nextPage").disabled =
        currentPage === Math.ceil(funcionarios.length / itemsPerPage) - 1;
    }

    function initPagination() {
      showPage(currentPage);
      updateButtons();
    }

    function prevPage() {
      if (currentPage > 0) {
        currentPage--;
        showPage(currentPage);
        updateButtons();
      }
    }

    function nextPage() {
      if (currentPage < Math.ceil(funcionarios.length / itemsPerPage) - 1) {
        currentPage++;
        showPage(currentPage);
        updateButtons();
      }
    }

    initPagination();

    document.getElementById("prevPage").addEventListener("click", prevPage);
    document.getElementById("nextPage").addEventListener("click", nextPage);
  });