package com.zahorovskyi.crypto.utility;

import com.zahorovskyi.crypto.central.Constants;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Reviser {
     public void checkTwoArgs(String[] args) throws IllegalAccessException {
        if (args.length < 2) {
            throw new IllegalAccessException("You have to write the command, path to the file and key!");
        }
    }
    public void checkSourceFile(String fileName) throws NoSuchFileException {
        if (Files.notExists(Path.of(fileName))) {
            throw new NoSuchFileException("File " + fileName + " not exists!");
        }
    }
    public void checkCommand(String command) throws IllegalAccessException {
        if (!Constants.DECRYPT.equals(command) && !Constants.ENCRYPT.equals(command) && !Constants.BRUTE_FORCE.equals(command)) {
            throw new IllegalAccessException("Command is not correctly!");
        }
    }
    public void checkThreeArgs(String[] args) throws IllegalAccessException {
        if (args.length != 3) {
            throw new IllegalAccessException("Args must have 3 commands");
        }
    }
    public void checkKeyCorrectly(String strKey) throws NoSuchFileException {
        try {
            Integer.parseInt(strKey.trim());
        } catch (NumberFormatException e) {
            throw new NoSuchFileException("Key:" + strKey + " is not correctly!");
        }
    }
}
