package figures;

/**
 * Created by Konstantin on 19.06.2016.
 */
import java.util.List;

public interface FigureFactory {
    Figure getFigure(List<Double> args);
}