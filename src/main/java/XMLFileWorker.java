/**
 * Created by Konstantin on 19.06.2016.
 */
import java.io.*;
import java.util.*;
import nu.xom.*;
import figures.*;


class XMLFileWorker {
    Document doc;

    public XMLFileWorker(String path) throws ParsingException, ValidityException, IOException {
        File file = new File(path);
        doc = new Builder().build(file);
    }

    public List<Figure> listOfFigure(){
        Elements elements = doc.getRootElement().getChildElements();
        List<Figure> figures = new ArrayList<>();

        for(int i = 0; i < elements.size(); i++){
            Element element = elements.get(i);

            String name = element.getLocalName();

            Element parameter = element.getFirstChildElement("parameters");
            List<Double> parameters  = new ArrayList<>();

            try{
                for(int j = 0; j < parameter.getAttributeCount(); j++){
                    String stringValue = parameter.getAttribute(j).getValue();

                    double value = Double.parseDouble(stringValue);
                    parameters.add(value);
                }

                figures.add(CreateFigure.create(name, parameters));

            } catch (NumberFormatException ex){
                System.out.println("[ERROR]Wrong format of parameters of " + (i + 1) +"  figure");
                System.out.println();
            } catch(IllegalArgumentException ex){
                System.out.println("[ERROR]Figure " + (i + 1) + ": " + ex.getMessage());
                System.out.println();
            }
        }

        return figures;
    }


}