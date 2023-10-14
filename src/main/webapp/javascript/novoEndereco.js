function duplicateAddress() {
        var addressInputs = document.getElementById('addressInputs');
        var clonedInputs = addressInputs.cloneNode(true);

        // Limpa os valores dos campos clonados e remove os IDs
        var inputFields = clonedInputs.querySelectorAll('input');
        inputFields.forEach(function (input) {
            input.value = '';
            input.removeAttribute('id');
        });

        // Adiciona os campos clonados antes do botão de cadastro
        addressInputs.parentNode.insertBefore(clonedInputs, document.querySelector('.botao-cadastro').parentNode);
    }

    function removeAddress(button) {
        button.parentNode.parentNode.remove();
    }