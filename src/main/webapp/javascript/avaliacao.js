const ratingInput = document.getElementById('rating');
const increaseRatingBtn = document.getElementById('increase-rating');
const decreaseRatingBtn = document.getElementById('decrease-rating');

let currentRating = 0;

increaseRatingBtn.addEventListener('click', () => {
    if (currentRating < 5) {
        currentRating += 0.5;
        ratingInput.value = currentRating;
    }
});

decreaseRatingBtn.addEventListener('click', () => {
    if (currentRating > 0) {
        currentRating -= 0.5;
        ratingInput.value = currentRating;
    }
});