package figures;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

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
