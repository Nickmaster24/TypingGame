package com.gmail.nickmaster24;

/**
 * @author nickm_000
 * @since 12/7/2015.
 */
public class Word {

    public static final short HOME_ROW_KEY_SCORE = 1;
    public static final short NORMAL_KEY_SCORE = 2;

    private String text;
    private int scoreValue;
    private static char[] homeKeys = {'a', 's', 'd', 'f', 'j', 'k', 'l'}; //Ignore ';'

    public Word(String text) {
        this.text = text;
        this.scoreValue = 0;
        for (char c : text.toCharArray()) {
            short value = NORMAL_KEY_SCORE;
            for (char hc : homeKeys) {
                if (c == hc) {
                    value = HOME_ROW_KEY_SCORE;
                    break;
                }
            }
            this.scoreValue += value; //Add each character's value
        }
    }

    public String getWord() {
        return this.text;
    }

    public int getScoreValue() {
        return this.scoreValue;
    }

    @Override
    public boolean equals(Object obj) { //Is another object the same Word?
        return obj instanceof Word && obj.toString().equals(this.toString()) ||
                obj instanceof String && obj.toString().equals(this.toString());

    }

    @Override
    public String toString() {
        return this.text;
    }

}
