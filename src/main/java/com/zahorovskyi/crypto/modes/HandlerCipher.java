package com.zahorovskyi.crypto.modes;


import com.zahorovskyi.crypto.central.Constants;

import java.util.ArrayList;
import java.util.List;

public class HandlerCipher {

    public List<String> transformation(List<String> allText, int key, String command) {
        key = key % Constants.DICTIONARY.size();
        if (Constants.DECRYPT.equals(command)) {
            key = Constants.DICTIONARY.size() - key;
        }
        List<String> allTextModify = new ArrayList<>();
        for (String line : allText) {
            char[] charsLine = line.toCharArray();
            for (int i = 0; i < charsLine.length; i++) {
                if (Constants.DICTIONARY.contains(charsLine[i])) {
                    int index = Constants.DICTIONARY.indexOf(charsLine[i]);
                    while (index + key >= Constants.DICTIONARY.size()) {
                        index = index - Constants.DICTIONARY.size();
                    }
                    charsLine[i] = Constants.DICTIONARY.get(index + key);
                }
            }
            line = String.valueOf(charsLine);
            allTextModify.add(line);
        }
        return allTextModify;
    }
}
