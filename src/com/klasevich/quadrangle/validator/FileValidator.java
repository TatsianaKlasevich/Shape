package com.klasevich.quadrangle.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {
    private static final Logger logger = LogManager.getLogger();

    public static boolean isFileExist(Path path) {
        long size = 0L;
        try {
            size = Files.size(path);
        } catch (IOException e) {
            logger.error(e);
        }
        return size < 0;
    }
}
