package com.epam.shape.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileValidator {
    private final static Logger logger = LogManager.getLogger();

    public static boolean isFileExist(String path) {
        Path filePath = Paths.get(path);
        return Files.exists(filePath);
    }

    public static boolean isFileEmpty(Path filePath) {
        long size = 0L;
        try {
            size = Files.size(filePath);
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
        }
        return size < 0;
    }
}
