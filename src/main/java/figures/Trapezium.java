package figures;

import java.util.List;

/**
 * Created by Konstantin on 20.06.2016.
 */
public class Trapezium implements Figure {
    private double a;
    private double b;
    private double h;

    public Trapezium(final double b,final double h,final double a) {
        this.b = b;
        this.h = h;
        this.a = a;
    }

    @Override
    public double square() {
        return (a + b) * h / 2;
    }

    @Override
    public String name() {
        return "Trapezium";
    }

    @Override
    public String parameters() {
        return "sides a = " + a + " and b = " + b + " and height h = " + h ;
    }

    public static FigureFactory factory =
            new FigureFactory() {
                @Override
                public Figure getFigure(List<Double> args) {
                    return new Trapezium(args.get(0), args.get(1), args.get(2));
                }
            };
}
