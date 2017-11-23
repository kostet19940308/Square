package figures;

/**
 * Created by Konstantin on 19.06.2016.
 */
import java.util.List;


public class CreateFigure {

    public static Figure create(String name, List<Double> args){

        if((name == null) || (args == null) || (args.size() == 0)){
            throw new IllegalArgumentException("No arguments");
        }

        for(Double d: args){
            if(d <= 0.0){
                throw new IllegalArgumentException("Parameters of figure should be bigger then 0");
            }
        }

        if(name.equalsIgnoreCase("rectangle")){
            if(args.size() != 2){
                throw new IllegalArgumentException("Wrong number of arguments for rectangle");
            }
            FigureFactory fac = Rectangle.factory;
            return fac.getFigure(args);
        }

        if(name.equalsIgnoreCase("circle")){
            if(args.size() != 1){
                throw new IllegalArgumentException("Wrong number of arguments for circle");
            }
            FigureFactory fac = Circle.factory;
            return fac.getFigure(args);
        }

        if(name.equalsIgnoreCase("triangle")){
            if(args.size() != 3){
                throw new IllegalArgumentException("Wrong number of arguments for triangle");
            }
            if((args.get(0) + args.get(1) <= args.get(2)) ||
                    (args.get(1) + args.get(2) <= args.get(0)) ||
                    (args.get(0) + args.get(2) <= args.get(1))){
                throw new IllegalArgumentException("Sum of two sides should be bigger than last one");
            }
            FigureFactory fac = Triangle.factory;
            return fac.getFigure(args);
        }

        if(name.equalsIgnoreCase("ellipse")){
            if(args.size() != 2){
                throw new IllegalArgumentException("Wrong number of arguments for ellipse");
            }
            FigureFactory fac = Ellipse.factory;
            return fac.getFigure(args);
        }

        if(name.equalsIgnoreCase("trapezium")){
            if(args.size() != 3){
                throw new IllegalArgumentException("Wrong number of arguments for trapezium");
            }
            FigureFactory fac = Trapezium.factory;
            return fac.getFigure(args);
        }

        return null;
    }

}
