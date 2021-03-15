package edu.utdallas.cs6301.resolutionprover.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileIOService {
    private final List<String> inputLines = new ArrayList<>();

    public FileIOService(String inputFile) throws IOException {
        List<String> inputLines = Files.readAllLines(FileSystems.getDefault().getPath(inputFile));
        inputLines.forEach(line -> this.inputLines.add(line.trim()));
    }

    public List<String> getInputLines() {
        return Collections.unmodifiableList(inputLines);
    }
}
