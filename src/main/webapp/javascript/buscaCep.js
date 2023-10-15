async function getAddressByCEP() {
    const cep = document.getElementById('cep').value.replace(/\D/g, '');

    if (cep.length === 8) {
        try {
            const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
            const data = await response.json();

            if (!data.erro) {
                document.getElementById('rua').value = data.logradouro;
                document.getElementById('bairro').value = data.bairro;
                document.getElementById('cidade').value = data.localidade;
                document.getElementById('uf').value = data.uf;

            } else {
                alert('CEP não encontrado. Por favor, verifique o CEP inserido.');
            }
        } catch (error) {
            console.error('Erro ao buscar endereço:', error);
        }
    }
}

