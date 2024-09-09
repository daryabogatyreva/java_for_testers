package geometry;

import figures.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;

public class TriangleTests {

    static double a = 5.0;
    static double b = 5.0;
    static double c = 5.0;
    static double p = (a + b + c) / 2;
    private static double expectedPerimeter = a + b + c;
    private static double expectedArea = sqrt(p * (p - a) * (p - b) * (p - c));

    @Test
    public void calculatePerimeter() {

        double result = Triangle.perimeter(a, b, c);
        Assertions.assertEquals(expectedPerimeter, result);
    }

    @Test
    void calculateArea() {

        double result = Triangle.area(a, b, c);
        Assertions.assertEquals(expectedArea, result);
    }
}
