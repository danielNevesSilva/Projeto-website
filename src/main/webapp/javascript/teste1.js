  // Variáveis para controle da paginação
  let currentPage = 1; // Página atual
  const productsPerPage = 10; // Produtos por página

  // Elementos da tabela e botões de paginação
  const table = document.querySelector(".product-table");
  const prevButton = document.getElementById("prev-page");
  const nextButton = document.getElementById("next-page");
  const pageNumbers = document.getElementById("page-numbers");

  // Função para exibir os produtos com base na página atual
  function displayProducts() {
    const rows = table.querySelectorAll("tbody tr");

    // Esconde todas as linhas da tabela
    rows.forEach((row) => {
      row.style.display = "none";
    });

    // Calcula o índice de início e fim dos produtos na página atual
    const startIndex = (currentPage - 1) * productsPerPage;
    const endIndex = Math.min(startIndex + productsPerPage, rows.length);

    // Exibe as linhas dos produtos da página atual
    for (let i = startIndex; i < endIndex; i++) {
      rows[i].style.display = "";
    }
  }

  // Função para atualizar os botões de página
  function updatePageButtons() {
    prevButton.disabled = currentPage === 1;
    nextButton.disabled = currentPage * productsPerPage >= table.rows.length;
  }

  // Função para criar os números de página
  function createPageNumbers() {
    const totalPages = Math.ceil(table.rows.length / productsPerPage);
    pageNumbers.innerHTML = "";

    for (let i = 1; i <= totalPages; i++) {
      const button = document.createElement("button");
      button.textContent = i;
      button.addEventListener("click", () => {
        currentPage = i;
        displayProducts();
        updatePageButtons();
      });
      pageNumbers.appendChild(button);
    }
  }

  // Evento para ir para a página anterior
  prevButton.addEventListener("click", () => {
    if (currentPage > 1) {
      currentPage--;
      displayProducts();
      updatePageButtons();
    }
  });

  // Evento para ir para a próxima página
  nextButton.addEventListener("click", () => {
    if (currentPage * productsPerPage < table.rows.length) {
      currentPage++;
      displayProducts();
      updatePageButtons();
    }
  });

  // Inicializa a exibição dos produtos e os botões de página
  displayProducts();
  updatePageButtons();
  createPageNumbers();

