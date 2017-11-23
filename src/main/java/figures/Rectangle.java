package figures;

/**
 * Created by Konstantin on 19.06.2016.
 */
import java.util.List;

/**
 *
 * @author Konstantin
 */
public class Rectangle implements Figure{
    private double a;
    private double b;

    public Rectangle(final double a, final double b) {
        this.a = a;
        this.b = b;
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

    @Override
    public double square() {
        return a*b;
    }

    @Override
    public String name() {
        return "Rectangle";
    }

    @Override
    public String parameters() {
        return "sides a = " + a + " and b = " + b;
    }

    public static FigureFactory factory =
            new FigureFactory() {
                @Override
                public Figure getFigure(List<Double> args) {
                    return new Rectangle(args.get(0), args.get(1));
                }
            };



}
