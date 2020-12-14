package com.epam.shape.model.reader;

import com.epam.shape.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleReader {
    private final static Logger logger = LogManager.getLogger();

    public List<String> readDataFromFile(String path) {
        List<String> lines = new ArrayList<>();
        Path filePath = Paths.get(path);
        if (FileValidator.isFileExist(path) && !FileValidator.isFileEmpty(filePath)) {
            try (Stream<String> lineStream = Files.lines(filePath)) {
                lines = lineStream.collect(Collectors.toList());
            } catch (IOException e) {
                logger.log(Level.ERROR, e);
            }
        }
        return lines;
    }
}
