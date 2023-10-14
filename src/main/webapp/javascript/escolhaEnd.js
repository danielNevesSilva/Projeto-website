
function toggleEndereco(formId) {
    var enderecoInputs = document.querySelectorAll('#' + formId + ' .endereco-inputs input');
    var mesmoEnderecoRadio = document.getElementById('mesmo_endereco_' + formId);

    if (mesmoEnderecoRadio.checked) {
        enderecoInputs.forEach(function(input) {
            input.setAttribute('disabled', 'disabled');
        });
    } else {
        enderecoInputs.forEach(function(input) {
            input.removeAttribute('disabled');
        });
    }
}

