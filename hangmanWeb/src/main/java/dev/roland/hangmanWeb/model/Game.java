package dev.roland.hangmanWeb.model;

public class Game {

    private String secretWord;
    private StringBuilder viewOfSecretWord;
    private int mistakes;
    private static final int MAX_MISTAKES = 10;
    private int idOfTopic;

    public Game() {
    }

    public Game(String secretWord, int topicId) {
        setSecretWord(secretWord);
        generateViewOfSecretWord();
        setMistakesToZero();
        setIdOfTopic(topicId);
    }

    public void setIdOfTopic(int topicId) {
        this.idOfTopic = topicId;
    }

    public void setSecretWord(String word) {
        this.secretWord = word;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public String getViewOfSecretWord() {
        return viewOfSecretWord.toString();
    }

    public int getIdOfTopic() {
        return idOfTopic;
    }

    public void generateViewOfSecretWord() {
        viewOfSecretWord = new StringBuilder("_".repeat(secretWord.length()));
        revealSpacesInWord();
    }

    private void revealSpacesInWord() {
        int i = 0;
        if (secretWord.contains(" ")) {
            while (secretWord.toLowerCase().indexOf(" ", i) != -1) {
                viewOfSecretWord.setCharAt(secretWord.toLowerCase().indexOf(" ", i), ' ');
                i = secretWord.toLowerCase().indexOf(' ', i) + 1;
            }
        }
    }

    public void updateViewOfSecretWord(char guessedChar) {
        guessedChar = Character.toLowerCase(guessedChar);
        int index = secretWord.toLowerCase().indexOf(guessedChar);
        while (index != -1) {
            viewOfSecretWord.setCharAt(index, secretWord.charAt(index));
            index = secretWord.toLowerCase().indexOf(guessedChar, index + 1);
        }
    }

    public boolean isSecretWordContainsGuess(char guessedChar) {
        int index = secretWord.toLowerCase().indexOf(Character.toLowerCase(guessedChar));
        return (index != -1);
    }

    public void setMistakesToZero() {
        mistakes = 0;
    }

    public void mistakeHasBeenMade() {
        mistakes++;
    }

    public int getNumberOfMistakes() {
        return mistakes;
    }

    public boolean hasRemainingMistakes() {
        return mistakes < MAX_MISTAKES;
    }

    public boolean isGameWon() {
        return !viewOfSecretWord.toString().contains("_");
    }


    @Override
    public String toString() {
        return "Game{" +
                "secretWord='" + secretWord + '\'' +
                ", viewOfSecretWord=" + viewOfSecretWord +
                ", mistakes=" + mistakes +
                ", idOfTopic=" + idOfTopic +
                '}';
    }
}

