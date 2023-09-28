$(document).ready(function () {
    $('.carousel-container').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true, // Habilita o autoplay
        autoplaySpeed: 2000, // Intervalo de tempo em milissegundos (ajuste conforme necessário)
        arrows: true, // Adiciona setas de navegação
        prevArrow: '<button type="button" class="slick-prev">&#9664;</button>',
        nextArrow: '<button type="button" class="slick-next">&#9654;</button>',
    });
});
