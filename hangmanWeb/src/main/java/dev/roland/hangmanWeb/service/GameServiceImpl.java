package dev.roland.hangmanWeb.service;

import dev.roland.hangmanWeb.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private Game game;

    @Override
    public void initializeGame(String secretWord, int topicId) {
        game = new Game(secretWord, topicId);
        System.out.println(game);
    }

    @Override
    public void makeGuess(char guessedChar) {
        System.out.println(game);
        if (!isGameWon() && game.hasRemainingMistakes()) {
            if (game.isSecretWordContainsGuess(guessedChar)) {
                game.updateViewOfSecretWord(guessedChar);
            } else {
                game.mistakeHasBeenMade();
            }
        }
    }

    @Override
    public boolean isGameWon() {
        return game.isGameWon();
    }

    @Override
    public String getViewOfSecretWord() {
        return game.getViewOfSecretWord();
    }

    @Override
    public boolean hasRemainingMistakes() {
        return game.hasRemainingMistakes();
    }

    @Override
    public int getNumberOfMistakes() {
        return game.getNumberOfMistakes();
    }

    @Override
    public int getIdOfTopic() {
        return game.getIdOfTopic();
    }

    @Override
    public boolean isSecretWordContainsGuess(char guessedChar) {
        return game.isSecretWordContainsGuess(guessedChar);
    }

}
