package test.klasevich.quadrangle.parser;

import com.klasevich.quadrangle.parser.PointParser;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PointParserTest {
    private static final String SEPARATOR = " ";
    PointParser parser = new PointParser();

    @Test
    public void testParseLines() {
        String line = "-3.0 -1.0 -2.0 2.0 3.0 2.0 4.0 -2.0";
        List<Double> actual = parser.parseLines(line);
        List<Double> expected = new ArrayList<>();
        expected.add(-3.0);
        expected.add(-1.0);
        expected.add(-2.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(2.0);
        expected.add(4.0);
        expected.add(-2.0);
        assertEquals(actual, expected);
    }
}