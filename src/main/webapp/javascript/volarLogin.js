    function redirectToLoginPage() {
    window.location.href = "../LoginCliente.jsp";
}
    document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();
    redirectToLoginPage();
});

