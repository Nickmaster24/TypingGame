package com.gmail.nickmaster24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author nickm_000
 * @since 12/7/2015.
 */
public class ConsoleInputTask implements Runnable, TriggerHandler {

    private boolean stopped;
    private int score;
    private WordSource words;

    public ConsoleInputTask(WordSource wordSource) {
        words = wordSource;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        score = 0;
        System.out.println("Type out each word and press enter:");
        while (!stopped) {
            try {
                Word currentWord = words.nextWord();
                System.out.println(currentWord);
                String input = reader.readLine();
                if (!stopped) {//Don't process responses after thread is stopped
                    if (input.trim().toLowerCase().equals(currentWord.toString())) {
                        score += currentWord.getScoreValue();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopTask() {
        stopped = true;
        System.out.println("Your score was: " + getScore());
    }

    @Override
    public void trigger(String[] args) {
        stopTask();
    }

    public int getScore() {
        return score;
    }
}
