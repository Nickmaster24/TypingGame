package com.gmail.nickmaster24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author nickm_000
 * @since 12/9/2015.
 */
public class WordSource {

    private ArrayList<Word> masterList;
    private ArrayList<Word> workingList;

    private Random random;

    public WordSource() {
        masterList = new ArrayList<Word>();
        workingList = new ArrayList<Word>(masterList);
        random = new Random();
    }

    public void addWords(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while (reader.ready()) {
            masterList.add(new Word(reader.readLine().trim().toLowerCase()));
        }
        if (workingList.size() == 0) {
            workingList = new ArrayList<Word>(masterList);
        }
    }

    public Word getAnyWord() {
        return masterList.get(random.nextInt(masterList.size()));
    }

    public Word nextWord() {
        if (workingList.size() == 0) {
            workingList = new ArrayList<Word>(masterList);
        }
        int i = random.nextInt(workingList.size());
        Word toReturn = workingList.get(i);
        workingList.remove(i);
        return toReturn;
    }
}
