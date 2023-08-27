function validarSenhas() {
    const senha1 = document.getElementById('password');
    const senha2 = document.getElementById('confirmPassword');

    if (senha1.value === senha2.value) {
        senha2.setCustomValidity(''); // Senhas conferem
    } else {
        senha2.setCustomValidity('As senhas não conferem');
    }
}

function formatarCPF(campo) {
    var cpf = campo.value.replace(/\D/g, ''); // Remove todos os caracteres não numéricos

    if (cpf.length > 11) {
        cpf = cpf.slice(0, 11);
    }

    cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');

    campo.value = cpf;
}