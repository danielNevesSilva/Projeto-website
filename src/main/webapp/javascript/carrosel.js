const slides = document.querySelectorAll('.slide');
const autoBtns = document.querySelectorAll('.auto-btn');

let currentSlide = 0;
let autoPlay;

function showSlide(slideIndex) {
    slides.forEach((slide, index) => {
        if (index === slideIndex) {
            slide.style.display = 'block';
        } else {
            slide.style.display = 'none';
        }
    });

    autoBtns.forEach((btn, index) => {
        if (index === slideIndex) {
            btn.classList.add('active');
        } else {
            btn.classList.remove('active');
        }
    });
}

autoBtns.forEach((btn, index) => {
    btn.addEventListener('click', () => {
        currentSlide = index;
        showSlide(currentSlide);
    });
});

showSlide(currentSlide);

function nextSlide() {
    currentSlide = (currentSlide + 1) % slides.length;
    showSlide(currentSlide);
}

function prevSlide() {
    currentSlide = (currentSlide - 1 + slides.length) % slides.length;
    showSlide(currentSlide);
}

document.getElementById('radio1').addEventListener('click', () => {
    currentSlide = 0;
    showSlide(currentSlide);
});

document.getElementById('radio2').addEventListener('click', () => {
    currentSlide = 1;
    showSlide(currentSlide);
});

document.getElementById('radio3').addEventListener('click', () => {
    currentSlide = 2;
    showSlide(currentSlide);
});

// Função para iniciar o autoplay
function startAutoPlay() {
    autoPlay = setInterval(nextSlide, 3000); // Avança a cada 3 segundos
}

// Função para parar o autoplay
function stopAutoPlay() {
    clearInterval(autoPlay);
}

// Inicia o autoplay
startAutoPlay();

// Adiciona event listeners para pausar o autoplay quando o mouse estiver sobre o slider
const slider = document.querySelector('.slider');
slider.addEventListener('mouseenter', stopAutoPlay);
slider.addEventListener('mouseleave', startAutoPlay);
