package figures;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;
        double[] sides1 = {this.a, this.b, this.c};
        double[] sides2 = {triangle.a, triangle.b, triangle.c};
        Arrays.sort(sides1);
        Arrays.sort(sides2);
        return Arrays.equals(sides1, sides2);
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(a);
        result = 31 * result + Double.hashCode(b);
        result = 31 * result + Double.hashCode(c);
        return result;
    }

    public void check() {
        if (a < 0 || b < 0 || c < 0) {
            throw new AssertionError("Стороны треугольника должны быть положительными числами");
        } else if (a + b < c || a + c < b || b + c < a) {
            throw new AssertionError("Сумма сторон треугольника должна быть не меньше третьей стороны");
        }
    }

    public double perimeter() {
        return (this.a + this.b + this.c);
    }

    public double area() {
        double p = perimeter() / 2;
        return (sqrt(p * (p - this.a) * (p - this.b) * (p - this.c)));
    }
}
