package com.zahorovskyi.crypto.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {

    public List<String> read(String fileName) throws IOException {
        Path sourceFile = Path.of(fileName);
        return Files.readAllLines(sourceFile);
    }
    public void write(String command, String fileName, List<String> allTextModify) throws IOException {
        Path fileDest = createNameFileDest(command, fileName);
        Files.write(fileDest, allTextModify);
    }
    private Path createNameFileDest (String command, String fileName) {
        String labelCommand = "["+command+"ED]";
        String destBegin = fileName.replaceAll("\\.\\w+$", "");
        String destEnd = fileName.substring(destBegin.length());
        return Path.of(destBegin + labelCommand + destEnd);
    }
}
