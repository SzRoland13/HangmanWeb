function handleKeyPress(guessedChar) {

    let buttonId = "button_" + guessedChar;

    $.ajax({
        type: 'POST',
        url: '/game/handleGuess',
        data: {guessedChar: guessedChar},
        success: function (response) {
            console.log(response)
            var updatedViewOfSecretWord = response.viewOfSecretWord;
            var titleOfTopic = response.titleOfTopic;
            var numberOfMistakes = response.numberOfMistakes;
            var hasGuessBeenInTheWord = response.isSecretWordContainsGuess;
            var hasRemainingMistakes = response.hasRemainingMistakes;
            $('#viewOfSecretWord').text(updatedViewOfSecretWord);
            $('#titleOfTopic').text(titleOfTopic);
            $('#numberOfMistakes').text(numberOfMistakes);
            setButtonAfterGuess(buttonId, hasGuessBeenInTheWord);
            checkIfGameIsOverAndActIfYes(updatedViewOfSecretWord, hasRemainingMistakes);
        },
        error: function (error) {
            console.error('Error' + error);
        }
    })
}

function setButtonAfterGuess(buttonId, buttonCharWasInTheSecretWord) {
    var button = document.getElementById(buttonId);
    if (button) {
        if (buttonCharWasInTheSecretWord) {
            button.classList.remove('virtual-key');
            button.classList.add('disableBecauseGuessFound');
        } else {
            button.classList.remove('virtual-key');
            button.classList.add('disableBecauseGuessNotFound');
        }
    }
}

function checkIfGameIsOverAndActIfYes(updatedViewOfSecretWord, hasRemainingMistakes) {
    if (updatedViewOfSecretWord.indexOf('_') === -1 || !hasRemainingMistakes) {
        setGameOverText(updatedViewOfSecretWord)
        gameOver();
    }
}

function showModal() {
    var modal = document.getElementById('modal');
    modal.style.display = 'flex';
}

function hideModal() {
    var modal = document.getElementById('modal');
    modal.style.display = 'none';
}

function gameOver() {
    showModal();
    document.getElementById('playAgainButton').addEventListener('click', function () {
        hideModal();
        window.location.href = '/game/chooseTopic';
    })
    document.getElementById('homePageButton').addEventListener('click', function () {
        hideModal();
        window.location.href = '/nav/start';
    })
    //document.getElementById('recordsButton').addEventListener('click', function (){
    //hideModal();
    // window.location.href = '/game/records';
    // })
}
function setGameOverText(viewOfWord){
    if (viewOfWord.indexOf('_') === -1){
        setGameOverTextWhenWin();
    }else setGameOverTextWhenLose()
}

function setGameOverTextWhenLose() {
    document.getElementById('gameOverText').textContent = 'Game Over';
}

function setGameOverTextWhenWin() {
    document.getElementById('gameOverText').textContent = 'Congratulations';
}