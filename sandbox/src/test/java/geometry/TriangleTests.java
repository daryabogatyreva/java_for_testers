package geometry;

import figures.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;

public class TriangleTests {

    static double a = 5.0;
    static double b = 8.0;
    static double c = 8.0;
    static double p = (a + b + c) / 2;
    private static double expectedPerimeter = a + b + c;
    private static double expectedArea = sqrt(p * (p - a) * (p - b) * (p - c));

    @Test
    void checkNegativeTriangle() {
        var triangle = new Triangle(a, b, c);
        triangle.check();
    }

    @Test
    void calculatePerimeter() {
        var p = new Triangle(a, b, c);
        double actualPerimeter = p.perimeter();
        Assertions.assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    void calculateArea() {

        var s = new Triangle(a, b, c);
        double actualArea = s.area();
        Assertions.assertEquals(expectedArea, actualArea);
    }

}
