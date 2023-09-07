const ratingInput = document.getElementById('rating');
const increaseRatingBtn = document.getElementById('increase-rating');
const decreaseRatingBtn = document.getElementById('decrease-rating');

let currentRating = 0;

// Função de validação
function validateRating(value) {
    const floatValue = parseFloat(value);
    if (!isNaN(floatValue) && floatValue >= 0 && floatValue <= 5) {
        return parseFloat(floatValue.toFixed(1));
    }
    return null;
}

// Atualizar o campo de avaliação com base no valor atual
function updateRatingField() {
    ratingInput.value = currentRating.toFixed(1);
}

increaseRatingBtn.addEventListener('click', () => {
    if (currentRating < 5) {
        currentRating += 0.5;
        updateRatingField();
    }
});

decreaseRatingBtn.addEventListener('click', () => {
    if (currentRating > 0) {
        currentRating -= 0.5;
        updateRatingField();
    }
});

// Validação no lado do cliente ao inserir o valor
ratingInput.addEventListener('input', () => {
    const inputValue = ratingInput.value;
    const validatedValue = validateRating(inputValue);

    if (validatedValue !== null) {
        currentRating = validatedValue;
        updateRatingField();
    }
});
