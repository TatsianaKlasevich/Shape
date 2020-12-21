package test.klasevich.quadrangle.repository;

import com.klasevich.quadrangle.creator.QuadrangleCreator;
import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.exception.ReaderException;
import com.klasevich.quadrangle.factory.impl.QuadrangleFactory;
import com.klasevich.quadrangle.parser.PointParser;
import com.klasevich.quadrangle.reader.QuadrangleReader;
import com.klasevich.quadrangle.repository.impl.QuadrangleRepository;
import com.klasevich.quadrangle.repository.specification.impl.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class QuadrangleRepositoryTest {
    QuadrangleRepository repository = QuadrangleRepository.getInstance();

    @BeforeMethod
    public void setUp() throws ReaderException {
        QuadrangleReader reader = new QuadrangleReader();
        List<String> list = reader.readingFromFile("data/shape.txt");

        PointParser parser = new PointParser();
        QuadrangleFactory factory = new QuadrangleFactory();
        QuadrangleCreator creator = new QuadrangleCreator();

        for (int i = 0; i <list.size() ; i++) {
            List<Double>coordinates = parser.parseLines(list.get(i));
            Optional<Quadrangle> quadrangle =factory.createShape(coordinates);
            creator.createQuadrangle(quadrangle);
        }
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testQuery1() {
        double minArea = 10;
        double maxArea = 26;
        List<Quadrangle>expected = new ArrayList<>();
        expected.add(repository.get(1));
        expected.add(repository.get(3));
        AreaRateSpecification areaRateSpecification = new AreaRateSpecification(minArea,maxArea);
        List<Quadrangle>actual = repository.query(areaRateSpecification);
        aassertEquals(actual, expected);
    }

    @Test
    public void testQuery2() {
        double minX = 2.0;
        double maxX = 4.0;
        double minY =0.0;
        double maxY =4.0;
        List<Quadrangle>expected = new ArrayList<>();
        expected.add(repository.get(1));
        expected.add(repository.get(2));
        CoordinateRangeSpecification specification = new CoordinateRangeSpecification(minX,maxX,minY,maxY);
        List<Quadrangle>actual = repository.query(specification);
        aassertEquals(actual, expected);
    }

    @Test
    public void testQuery3() {
        List<Quadrangle>expected = new ArrayList<>();
        expected.add(repository.get(0));
        IsSquareSpecification specification = new IsSquareSpecification();
        List<Quadrangle>actual = repository.query(specification);
        aassertEquals(actual, expected);
    }

    @Test
    public void testQuery4() {
        List<Quadrangle>expected = new ArrayList<>();
        expected.add(repository.get(1));
        expected.add(repository.get(2));
        IsConvexQuadrangleSpecification specification = new IsConvexQuadrangleSpecification();
        List<Quadrangle>actual = repository.query(specification);
        aassertEquals(actual, expected);
    }

    @Test
    public void testQuery5() {
        List<Quadrangle>expected = new ArrayList<>();
        expected.add(repository.get(0));
        expected.add(repository.get(1));
        expected.add(repository.get(3));
        PositiveXSpecification specification = new PositiveXSpecification();
        List<Quadrangle>actual = repository.query(specification);
        aassertEquals(actual, expected);
    }
}