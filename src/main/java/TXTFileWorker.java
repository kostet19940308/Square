/**
 * Created by Konstantin on 19.06.2016.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class TXTFileWorker {
    private File txt;

    public TXTFileWorker(String path) throws IOException {
        txt = new File(path);
        if(txt.createNewFile()){
            System.out.println("Create new file for result");
        }
    }

    public TXTFileWorker() throws IOException{
        this("result.txt");
    }

    public void write(String text) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(txt,true))){
            writer.write(text);
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    public void clear() throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(txt))){
            writer.write("");
        } catch (IOException ex) {
            throw new IOException();
        }
    }


}