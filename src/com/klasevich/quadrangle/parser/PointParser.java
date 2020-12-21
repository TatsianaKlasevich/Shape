package com.klasevich.quadrangle.parser;

import com.klasevich.quadrangle.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PointParser {
    private static Logger logger = LogManager.getLogger();
    private static final String SEPARATOR = " ";

    public List<Double> parseLines(String line) {
        List<Double> digits = new ArrayList<>();
        if (DataValidator.isCorrectLine(line)) {
            String[] temp = line.split(SEPARATOR);
            for (String string : temp) {
                digits.add(Double.parseDouble(string));
            }
        }
        return digits;
    }
}

