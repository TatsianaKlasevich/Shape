package com.klasevich.quadrangle.reader;

import com.klasevich.quadrangle.exception.ReaderException;
import com.klasevich.quadrangle.validator.FileValidator;
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

public class QuadrangleReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_FILE = "data/shape.txt";

    public List<String> readingFromFile(String fileName) throws ReaderException {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(fileName);

        if (!FileValidator.isFileExist(path)) {
            path = Paths.get(DEFAULT_FILE);
        }

        try (Stream<String> stream = Files.lines(path)) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e);
            throw new ReaderException(e);
        }
        return lines;
    }
}
