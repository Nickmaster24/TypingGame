package com.gmail.nickmaster24;

import java.io.IOException;

/**
 * @author nickm_000
 * @since 12/7/2015.
 */
public class GameController {

    public static void main(String[] args) {
        String lastInput = "";
        while (!lastInput.toLowerCase().equals("exit")) {
            WordSource curWords = new WordSource();
            try {
                curWords.addWords("sample.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

            ConsoleInputTask inputTask = new ConsoleInputTask(curWords);
            new Thread(inputTask).start();
            new Thread(new TimerTask(inputTask, null, 10000)).run();
        }
    }
}
