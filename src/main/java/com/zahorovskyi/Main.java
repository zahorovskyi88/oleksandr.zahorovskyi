package com.zahorovskyi;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        // java -jar myApp.jar command filePath key
        if (args.length == 3) {
            String command = args[0];
            String filePath = args[1];
            String key = args[2];
        } else {
            throw new IllegalAccessException("Args must have 3 commands");
        }
    }
}
