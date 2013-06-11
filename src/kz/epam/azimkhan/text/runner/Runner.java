package kz.epam.azimkhan.text.runner;

import kz.epam.azimkhan.text.model.Text;
import kz.epam.azimkhan.text.model.punctuation.Punctuation;
import kz.epam.azimkhan.text.parser.TextParser;
import kz.epam.azimkhan.text.parser.exception.TextParserException;
import kz.epam.azimkhan.text.parser.exception.UndefinedElementException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Date: 07.06.13
 * Time: 11:12
 */
public class Runner {
    public static void main(String[] args){

        File in = new File("text.in");
        File out = new File("text.out");
        FileWriter fw = null;
        TextParser tp = new TextParser(in);

        try {
            Text text = tp.parse();

            fw = new FileWriter(out);
            String str = text.toString();

            fw.write(str);


        }catch (IOException e){
            e.printStackTrace();
        }
        catch (UndefinedElementException e){
            System.err.print("Undefined element: " + e.getElementName());
        }

        catch (TextParserException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
