package com.zahorovskyi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IllegalAccessException, IOException {
        // java -jar myApp.jar command filePath key
        if (args.length < 2) {
            throw new IllegalAccessException("You have to write the command, path to the file and key!");
        }
        String command = args[0].trim();
        String fileName = args[1].trim();
        if (Files.notExists(Path.of(fileName))) {
            throw new NoSuchFileException("file " + fileName + " not exists!");
        }
        if (Constants.BRUTE_FORCE.equals(command)) {
            brute(fileName);
        } else if (args.length != 3) {
            throw new IllegalAccessException("Args must have 3 commands");
        } else if (!Constants.DECRYPT.equals(command) && !Constants.ENCRYPT.equals(command)) {
            throw new IllegalAccessException("Commands is not correctly!");
        } else {
            int key;
            String strKey = args[2];
            try {
                key = Integer.parseInt(strKey.trim());
                key = key % Constants.DICTIONARY.size();

            } catch (NumberFormatException e) {
            throw new NoSuchFileException("Key: " + strKey + " - is not correct!");
            }
            FileService service = new FileService();
            List<String> allText = service.read(fileName);
            HandlerCipher cipher = new HandlerCipher();
            List<String> allTextModify = cipher.transformation(allText, key, command);
            service.write(command, fileName, allTextModify);
            }
    }
    public static void brute(String filename) throws IOException {
        FileService serviceBrute = new FileService();
        HandlerCipher cipher = new HandlerCipher();
        int resultKey = 0;
        List<String> allText = serviceBrute.read(filename);
        for (int i = 0; i < Constants.DICTIONARY.size(); i++) {
        List<String> allTextModify = cipher.transformation(allText, i, Constants.DECRYPT);

            System.out.println(allTextModify);
            for (String line : allTextModify) {
                char[] charsLine = line.toCharArray();
                for (int j = 0; j < charsLine.length; j++) {
                    if (Constants.SIGN.contains(charsLine[j])) {
                        if ((j == charsLine.length - 1) || (j + 1 < charsLine.length && ' ' == charsLine[j+1])) {

                            resultKey = i;
                            break;

                        }
                    }
                }
            }
        }
        System.out.println("resultKey: " + resultKey);
    }
}
