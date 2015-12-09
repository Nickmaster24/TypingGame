package com.gmail.nickmaster24;

/**
 * @author nickm_000
 * @since 12/7/2015.
 */
public class Word {

    private String text;
    private int scoreValue;
    private static char[] homeKeys = {'a', 's', 'd', 'f', 'j', 'k', 'l'};

    public Word(String text) {
        this.text = text;
        this.scoreValue = 0;
        for (char c : text.toCharArray()) {
            short value = 2; //value of non home row keys
            for (char hc : homeKeys) {
                if (c == hc) {
                    value = 1; //Value of home row keys
                }
            }
            this.scoreValue += value; //Add each characters value
        }
    }

    public String getWord() {
        return text;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    @Override
    public boolean equals(Object obj) { //Is another object the same Word?
        if (obj.getClass() == getClass()) { //Is the other object a Word
            Word other = (Word) obj;
            if (other.getWord().equals(getWord())) //Are word fields equal?
                return true;
        } else if (obj instanceof String) {
            String other = (String) obj;
            if (other.equals(text)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
