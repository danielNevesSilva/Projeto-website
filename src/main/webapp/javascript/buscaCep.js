document.getElementById('cep').addEventListener('blur', function() {
    let cep = this.value.replace(/\D/g, '');

    if (cep.length !== 8) {
        alert('O CEP deve conter exatamente 8 dígitos.');
        return;
    }

    fetch(`https://viacep.com.br/ws/${cep}/json/`)
        .then(response => response.json())
        .then(data => {
            if (!data.erro) {
                document.getElementById('rua').value = data.logradouro;
                document.getElementById('bairro').value = data.bairro;
                document.getElementById('localidade').value = data.localidade;
                document.getElementById('estado').value = data.uf;
                document.getElementById('cidade').value = data.cidade;
            } else {
                alert('CEP não encontrado. Verifique se o CEP está correto.');
            }
        })
        .catch(error => console.error('Erro ao buscar CEP:', error));
});
