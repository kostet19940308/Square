package figures;

/**
 * Created by Konstantin on 19.06.2016.
 */
import java.util.List;

/**
 *
 * @author Konstantin
 */
public class Triangle implements Figure{

    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }



    @Override
    public double square() {
        double p = (a + b +c)/2;
        return Math.sqrt(p * (p - a) * (p - b)* (p - c)); //Heron's Formula
    }

    @Override
    public String name() {
        return "Triangle";
    }

    @Override
    public String parameters() {
        return "sides a = " + a + ", b = " + b + " and c = " + c;
    }

    public static FigureFactory factory =
            new FigureFactory() {
                @Override
                public Figure getFigure(List<Double> args) {
                    return new Triangle(args.get(0), args.get(1), args.get(2));
                }
            };

}
