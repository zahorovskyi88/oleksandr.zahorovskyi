package com.zahorovskyi.crypto.central;

import com.zahorovskyi.crypto.modes.BruteForce;
import com.zahorovskyi.crypto.modes.HandlerCipher;
import com.zahorovskyi.crypto.utility.Reviser;
import com.zahorovskyi.crypto.utility.FileService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Reviser reviser = new Reviser();
        reviser.checkTwoArgs(args);
        String command = args[0].trim();
        String fileName = args[1].trim();
        reviser.checkSourceFile(fileName);
        reviser.checkCommand(command);
        FileService fileService = new FileService();
        HandlerCipher handlerCipher = new HandlerCipher();
        if (Constants.BRUTE_FORCE.equals(command)) {
            initBruteCoder(fileService, handlerCipher, fileName);
        } else {
            reviser.checkThreeArgs(args);
            String strKey = args[2];
            reviser.checkKeyCorrectly(strKey);
            initSimpleCoder(fileService, handlerCipher, strKey, fileName, command);
        }
    }
    static void initBruteCoder(FileService fileService, HandlerCipher handlerCipher, String fileName) throws IOException {
        BruteForce bruteForce = new BruteForce();
        List<String> allText = fileService.read(fileName);
        int key = bruteForce.findKey(allText);
        List<String> allTextModify = handlerCipher.transformation(allText, key, Constants.DECRYPT);
        fileService.write(Constants.DECRYPT, fileName, allTextModify);
    }
    static void initSimpleCoder(FileService fileService, HandlerCipher handlerCipher, String strKey, String fileName, String command) throws IOException {
        int key = Integer.parseInt(strKey.trim());
        List<String> allText = fileService.read(fileName);
        List<String> allTextModify = handlerCipher.transformation(allText, key, command);
        fileService.write(command, fileName, allTextModify);
    }
}

