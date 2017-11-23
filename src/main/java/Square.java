/**
 * Created by Konstantin on 19.06.2016.
 */
import java.io.*;
import java.util.*;

import figures.CreateFigure;
import figures.Figure;
import nu.xom.*;


public class Square {

    private static void inputByConsole(Scanner scan, TXTFileWorker txt){
        while(true){

            String[] setOfString = "circle ellipse rectangle triangle trapezium exit".split(" ");
            Set<String> wordEquals = new HashSet<String>(Arrays.asList(setOfString));

            String fig;

            while(true){
                System.out.println("Choose figure");
                System.out.println("Write name of figure(circle, ellipse, rectangle, triangle, trapezium)");
                System.out.println("or command \"exit\" to return in start menu");

                fig = scan.nextLine();
                System.out.println();
                if(wordEquals.contains(fig)){
                    break;
                } else {
                    System.out.println("Wrong command. Try again.");
                }
            }

            if(fig.equals("exit")){
                break;
            }

            Figure figure = null;
            List<Double> param = new ArrayList<Double>();

            while(true){
                switch (fig){
                    case "rectangle":
                        System.out.println("Enter two sides - a and b");
                        break;
                    case "triangle":
                        System.out.println("Enter three sides - a, b and c");
                        break;
                    case "ellipse":
                        System.out.println("Enter two semiaxis - a and b");
                        break;
                    case "circle":
                        System.out.println("Enter radius - r");
                        break;
                    case "trapezium":
                        System.out.println("Enter two sides - a and b and height - h");
                        break;
                }

                String input = scan.nextLine();
                String[] splitInput = input.split(" ");

                try{
                    for (String num:splitInput){
                        double a = Double.parseDouble(num);
                        param.add(a);
                    }
                } catch (NumberFormatException ex){
                    System.out.println("Wrong format of parameters: don't use letters");
                    continue;
                }


                try{
                    figure = CreateFigure.create(fig,param);
                } catch (IllegalArgumentException ex){
                    System.out.println("Wrong format of parameters: " + ex.getMessage());
                    param.clear();
                    continue;
                }

                break;

            }


            System.out.println();
            System.out.println(answer(figure));
            System.out.println();

            if(txt != null){
                try {
                    txt.write(answer(figure));
                    txt.write("\n");
                } catch (IOException ex) {
                    System.out.println("Can't write to the file");
                }
            }

        }
    }

    public static void inputByXML(Scanner scan, TXTFileWorker txt){
        while(true){
            System.out.println("Write full path to XML file or comand \"exit\" to return in start menu");

            String path = scan.nextLine();

            if(path.equals("exit")){
                break;
            }

            XMLFileWorker xml;

            try {
                xml = new XMLFileWorker(path);
            } catch (ValidityException ex){
                System.out.println("XML is invalid. Try again");
                continue;
            } catch (ParsingException ex) {
                System.out.println("XML is malformed. Try again");
                continue;
            } catch (IOException ex) {
                System.out.println("Can't find the file. Try again");
                continue;
            }

            List<Figure> figures = xml.listOfFigure();

            for(Figure figure :figures){
                String answer = answer(figure);
                System.out.println(answer);

                if(txt != null){
                    try {
                        txt.write(answer);
                        txt.write("\n");
                    } catch (IOException ex) {
                        System.out.println("Can't write to the file");
                    }
                }

            }
        }
    }


    public static String answer(Figure f){
        return "Square of " + f.name() + " with " + f.parameters() + " is " + f.square();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Choose input");
            System.out.println("con - console, xml - XML, exit - exit from programm");
            String input = scan.nextLine();
            if(!input.equals("con") && !input.equals("xml") && !input.equals("exit")){
                System.out.println("Wrong command. Try again");
                continue;
            }
            if(input.equals("exit")){
                break;
            }

            String output = null;
            boolean correctOutput = true;

            while(correctOutput){
                System.out.println("Choose output");
                System.out.println("con - console, txt - console and TXT");
                output = scan.nextLine();
                if(output.equals("con") || output.equals("txt")){
                    correctOutput = false;
                }else{
                    System.out.println("Wrong comand. Try again");
                }
            }

            TXTFileWorker txt = null;

            if(output.equals("txt")){
                try {
                    txt = new TXTFileWorker();
                    txt.clear();
                } catch (IOException ex) {
                    System.out.println("Can't create the file");
                    continue;
                }
            }

            if(input.equals("con")){
                inputByConsole(scan, txt);
            }else{
                inputByXML(scan, txt);
            }

        }
    }

}
