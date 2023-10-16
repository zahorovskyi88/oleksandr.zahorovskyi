package com.zahorovskyi.crypto.modes;

import com.zahorovskyi.crypto.central.Constants;

import java.io.IOException;
import java.util.List;

public class BruteForce {
    public int findKey(List<String> allText) throws IOException {
        HandlerCipher handlerCipher = new HandlerCipher();
        int resultKey = 0;
        List<String> allTextModify = null;
        for (int i = 0; i < Constants.DICTIONARY.size(); i++) {
            resultKey = i;
            allTextModify = handlerCipher.transformation(allText, i, Constants.DECRYPT);
            if (isCorrectly(allTextModify)) {
                break;
            }
        }
        System.out.println("Key: " + resultKey);
        return resultKey;
    }
    private boolean isCorrectly (List<String> allTextModify) {
        for (String line : allTextModify) {
            char[] charsLine = line.toCharArray();
            if (charsLine.length > 0 && Constants.SIGN.contains(charsLine[0])) {
                return false;
            }
            if (charsLine.length > 20 && !line.contains(" ")) {
                return false;
            }
            for (int j = 0; j < charsLine.length; j++) {
                if (Constants.SIGN.contains(charsLine[j]) && j + 1 < charsLine.length) {
                    if (charsLine[j + 1] != ' ') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

