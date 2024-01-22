package com.mowitnow.demo.infrastracture;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Component
@Getter
public class FileReader {

    private List<String> lines;

    private List<String> readFile() throws IOException {
        Path path = Paths.get("src/main/resources/TestFile.txt");
        lines = Files.lines(path).toList();
        return lines;
    }

    public List<String> getLines() throws IOException {
        return Optional.ofNullable(lines).orElse(readFile());
    }
}
