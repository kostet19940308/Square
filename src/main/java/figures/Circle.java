package figures;

/**
 * Created by Konstantin on 19.06.2016.
 */
import java.util.List;

/**
 *
 * @author Konstantin
 */
public class Circle implements Figure{

    double r;

    public Circle(double r) {
        this.r = r;
    }


    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }



    @Override
    public double square() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public String name() {
        return "Circle";
    }

    @Override
    public String parameters() {
        return "radius r = " + r;
    }

    public static FigureFactory factory =
            new FigureFactory() {
                @Override
                public Figure getFigure(List<Double> args) {
                    return new Circle(args.get(0));
                }
            };

}