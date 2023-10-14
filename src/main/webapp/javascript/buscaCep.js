document.addEventListener('DOMContentLoaded', function() {
    var cepInput = document.getElementById('cep');
    cepInput.addEventListener('blur', function() {
        var cep = cepInput.value;
        if (cep.length === 8) {
            fetch(`https://viacep.com.br/ws/${cep}/json/`)
                .then(response => response.json())
                .then(data => {
                    document.getElementById('rua').value = data.logradouro;
                    document.getElementById('bairro').value = data.bairro;
                    document.getElementById('cidade').value = data.localidade;
                    document.getElementById('estado').value = data.uf;
                })
                .catch(error => console.error('Erro:', error));
        }
    });
});

/*endereco diferente */

function showPopup() {
    document.getElementById('popup').style.display = 'block';
}

function closePopup() {
    document.getElementById('popup').style.display = 'none';
}

function salvarEndereco() {
    // Adicione aqui a lógica para salvar o endereço
    alert('Endereço salvo com sucesso!');
    closePopup(); // Feche o pop-up após salvar
}
