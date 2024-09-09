package figures;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    public static double perimeter(double a, double b, double c) {
        return (a + b + c);
    }

    public static double area(double a, double b, double c) {
        double p = perimeter(a, b, c)/2;
        return (sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}


