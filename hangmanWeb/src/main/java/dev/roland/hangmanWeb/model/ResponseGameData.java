package dev.roland.hangmanWeb.model;

public class ResponseGameData {

    private String viewOfSecretWord;
    private int numberOfMistakes;
    private String titleOfTopic;
    private boolean isSecretWordContainsGuess;
    private boolean hasRemainingMistakes;

    public ResponseGameData() {

    }

    public ResponseGameData(String viewOfSecretWord, int numberOfMistakes, String titleOfTopic, boolean isSecretWordContainsGuess, boolean hasRemainingMistakes) {
        this.viewOfSecretWord = viewOfSecretWord;
        this.numberOfMistakes = numberOfMistakes;
        this.titleOfTopic = titleOfTopic;
        this.isSecretWordContainsGuess = isSecretWordContainsGuess;
        this.hasRemainingMistakes = hasRemainingMistakes;
    }

    public String getViewOfSecretWord() {
        return viewOfSecretWord;
    }

    public void setViewOfSecretWord(String viewOfSecretWord) {
        this.viewOfSecretWord = viewOfSecretWord;
    }

    public int getNumberOfMistakes() {
        return numberOfMistakes;
    }

    public void setNumberOfMistakes(int numberOfMistakes) {
        this.numberOfMistakes = numberOfMistakes;
    }

    public String getTitleOfTopic() {
        return titleOfTopic;
    }

    public void setTitleOfTopic(String titleOfTopic) {
        this.titleOfTopic = titleOfTopic;
    }

    public boolean getIsSecretWordContainsGuess() {
        return isSecretWordContainsGuess;
    }

    public void setIsSecretWordContainsGuess(boolean secretWordContainsGuess) {
        isSecretWordContainsGuess = secretWordContainsGuess;
    }

    public boolean getHasRemainingMistakes() {
        return hasRemainingMistakes;
    }

    public void setHasRemainingMistakes(boolean hasRemainingMistakes) {
        this.hasRemainingMistakes = hasRemainingMistakes;
    }

    @Override
    public String toString() {
        return "ResponseGameData{" +
                "viewOfSecretWord='" + viewOfSecretWord + '\'' +
                ", numberOfMistakes=" + numberOfMistakes +
                ", titleOfTopic='" + titleOfTopic + '\'' +
                ", isSecretWordContainsGuess=" + isSecretWordContainsGuess +
                ", hasRemainingMistakes=" + hasRemainingMistakes +
                '}';
    }
}
