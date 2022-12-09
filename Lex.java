import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;


public class Lex {
    ArrayList<Token> tokens; // String with all lexemes inside it 
    String input;

    //test file input from compiler 
    public Lex(String input){
        this.input = input;
        this.tokens = new ArrayList<Token>();
    }

    //D. these are my clear patterns 
    public Pattern real_literal = Pattern.compile("^\\d*\\.\\d+|\\d+\\.\\d*$"); 
    //matches ex 123 , 123.456, .456
    public Pattern natural_literal = Pattern.compile("^[0-9].*");
    // natural numbers including 0 
    public Pattern bool_literal = Pattern.compile("^(?i)(true|false)$");
    // ignore case of true or false
    public Pattern char_literal = Pattern.compile("{1}[a-zA-Z]"); // does not work 
    //double slash for escape char, takes ascii 
    public Pattern string_literal = Pattern.compile("[a-zA-Z]*"); //does not work 
    // any string including escape character

   
    boolean isAComment = false; //start comment off in false so when it recognizes // or /*  */ it will change to true 
   
    // C. coverts string into list of Token objects. ignores block and single line comments 
     public List<Token> tokenize(){
        String [] code = input.split("\\s+");

        for(String line: code){
            //start of block comment
        if(line.trim().startsWith("/*")){
            isAComment = true;
            continue;
        }
            //end of block comment
        if(line.trim().startsWith("*/")){
            isAComment = true;
            continue;
        }
        //single line comments 
        if(line.trim().startsWith("\\")){
            isAComment = true;
            continue;
        }
        //these are my clear patterns 
    
        //patern checks 
        Matcher isRealLiteral = real_literal.matcher(line);
        Matcher isNaturalLiteral = natural_literal.matcher(line);
        Matcher isBoolLiteral = bool_literal.matcher(line);
        Matcher isCharLiteral = char_literal.matcher(line);
        Matcher isStringLiteral = string_literal.matcher(line);

        
        if(!isAComment){ // converts but first checks for block comment or single line comment 
            if(isRealLiteral.matches()){ //checks for real literals with pattern and regex
                tokens.add(new Token(1 , "real_literal" ));
            }
        
            else if(isNaturalLiteral.matches()){ //checks for natural literals with pattern and regex
                tokens.add(new Token(2 , "natural_literal" ));
            }
            else if(isBoolLiteral.matches()){ //checks for bool literals with pattern and regex
                tokens.add(new Token(3 , "bool_literal" ));
            }
            else if(isCharLiteral.matches()){ //checks for char literals with pattern and regex
                tokens.add(new Token(4 , "char_literal" ));
            }
            else if(isStringLiteral.matches()){ //checks for string literals with pattern and regex
                tokens.add(new Token(5 , "string_literal" ));
            }
            else if(line.equals("Start")){ //checks for Start
                tokens.add(new Token(6 , "Start" ));
            }
            else if(line.equals("int")){  //checks for int which is a natural literla 
                tokens.add(new Token(7 , "natural_literal" ));
            }
            else if(line.equals("if")){ //checks for if statement 
                tokens.add(new Token(8 , "if" ));
            }
            else if(line.equals("+")){ //addition
                tokens.add(new Token(12 , "addition" ));
            }

        else if(line.equals("-")){ //subtraction 
            tokens.add(new Token(13 , "Subtraction" ));
        }
        else if(line.equals("*")){ //multiplication 
            tokens.add(new Token(14 , "Multiplication" ));
        }
        else if(line.equals("//")){ // single line comment 
            tokens.add(new Token(15 , "Single line comment " ));
        }
        else if(line.equals("^")){ //exponentiation
            tokens.add(new Token(16 , "exponent" ));
        }
        else if(line.equals("+")){ // addition again, acidentally added twice lol too laxy to adjust 
            tokens.add(new Token(17 , "+" ));
        }
        else if(line.equals(">")){ //greater than 
            tokens.add(new Token(18 , "greater than" ));
        }
        else if(line.equals("<")){ // less than 
            tokens.add(new Token(19 , "less than" ));
        }
        else if(line.equals("<=")){ //less than or equal top 
            tokens.add(new Token(20 , "less than equal to" ));
        }
        else if(line.equals(">=")){ //greater than or equal too 
            tokens.add(new Token(21 , "greater than equal to" ));
        }
        else if(line.equals("==")){ // equal too 
            tokens.add(new Token(22 , "equal too " ));
        }
        else if(line.equals("!=")){ // not equal too 
            tokens.add(new Token(23 , "not equal too" ));
        }
        else if(line.equals("-")){ //negation 
            tokens.add(new Token(24 , "negation" ));
        }
        else if(line.equals("!")){ //logical not 
            tokens.add(new Token(25 , "not" ));
        }
        else if(line.equals("&&")){ //logical and 
            tokens.add(new Token(26 , "and " ));
        }
        else if(line.equals("||")){ //logical or 
            tokens.add(new Token(27 , "or " ));
        }
        else if(line.equals(")")){ // grouping code block right par 
            tokens.add(new Token(28 , "right par" ));
        }
        else if(line.equals("(")){ // grouping code block left par 
            tokens.add(new Token(29 , "left par" ));
        }
        else if(line.equals(",")){ // parameter seperator comma 
            tokens.add(new Token(30 , "comma " ));
        }
        else if(line.equals("{")){ //parameter of a funciton curly brace 
            tokens.add(new Token(31 , "right curly brace" ));
        }
        else if(line.equals("}")){ //parameter of a funciton curly brace 
            tokens.add(new Token(32 , "left curly brace" ));
        }  
        else if(line.equals("=")){ //parameter of a funciton curly brace 
            tokens.add(new Token(32 , "equal" ));
        } 
}

}
return tokens;
     }
    }

