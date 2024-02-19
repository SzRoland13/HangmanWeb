package dev.roland.hangmanWeb.service;

public interface GameService {

    void initializeGame(String secretWord, int topicId);

    void makeGuess(char guessedChar);

    boolean isGameWon();

    String getViewOfSecretWord();

    boolean hasRemainingMistakes();

    int getNumberOfMistakes();

    int getIdOfTopic();

    boolean isSecretWordContainsGuess(char guessedChar);

}
