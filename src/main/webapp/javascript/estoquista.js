// Obtém o elemento da modal
var quantityModal = document.getElementById("quantity-modal");

// Obtém todos os botões "Alterar Quantidade"
var openQuantityModalButtons = document.querySelectorAll(".open-quantity-modal-button");

// Adiciona um evento a cada botão
openQuantityModalButtons.forEach(function (button) {
    button.addEventListener("click", function () {
        // Encontra o botão clicado
        var clickedButton = event.target;

        // Encontra o ID do produto a partir do atributo de dados
        var productId = clickedButton.getAttribute("data-product-id");

        console.log("ID do Produto:", productId);

        // Pode usar productId para preencher os campos do formulário na modal
        document.getElementById("id").value = productId;

        // Exibe a modal
        quantityModal.style.display = "block";
    });
});
