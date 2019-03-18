import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


    public String changeOneWord(String wordSource, String wordDestiny, String textSource){

        String patternString = wordSource;

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(textSource);

        return matcher.replaceAll(wordDestiny);
    }

    // TODO Revisar
    public StringBuilder findHoratio(String textSource){
        return constructorForFind("(Horatio)", textSource);
    }


    public StringBuilder findHamlet(String textSource) {
        return constructorForFind("(Hamlet)", textSource);
    }

    public StringBuilder constructorForFind(String word, String textSource){

        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(textSource);

        StringBuilder sb1 = new StringBuilder("");

        while(matcher.find()){
            sb1.append(matcher.group(1) + " found at "
                    + matcher.start() + "\n");
        }
        return sb1;

    }
}

