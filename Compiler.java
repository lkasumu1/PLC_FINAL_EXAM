import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;

public class Compiler {
    public static String inputCompiler(String filepath){
        StringBuilder textInput= new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String cde;
            while((cde = reader.readLine()) != null){
                if(cde.startsWith("//")){
                    continue;
                }
                textInput.append(cde).append(" ");
            }
        } catch (IOException e){
            e.printStackTrace();
        } 
        return textInput.toString();

}
public static void main (String [] args){
    String testFile = inputCompiler("/Users/loladekasumu/Desktop/VS Proj/PLC_FInal_Exam/src/test.txt");
    System.out.println(testFile);
    Lex lex = new Lex(testFile);
    List<Token> lex_analy = lex.tokenize();
    System.out.println();
    System.out.println(lex_analy.toString() );
    System.out.println();
    Parser pars = new Parser(lex_analy);
    System.out.println(pars.getTree().toString());

}    
    
}
