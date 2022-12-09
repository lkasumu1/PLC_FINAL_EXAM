import java.util.ArrayList;
import java.util.List;

public class Parser {
    public int x;
    public List<Token> listOfTokens; //list of tokens 
    public ArrayList<String> parseTree; // this is whats gonna be output 

    Parser (List<Token> tokens){
        listOfTokens = tokens;
        x =0;
        parseTree = new ArrayList<String>();

        
    }
  
    //checks literals 
    public  void checkLiterals (){
        String lit = currentToken();
        if(lit.equals("real_literal")){
            parseTree.add("real_literal");
            getNextToken();
            
        } else if(lit.equals("natural_literal")){
            getNextToken();
            parseTree.add("check_var");
        } else if(lit.equals("bool_literal")){
            getNextToken();
            parseTree.add("check_var");
        }  else if(lit.equals("char_literal")){
            getNextToken();
            parseTree.add("check_var");
        }  else if(lit.equals("String_literal")){
            getNextToken();
            parseTree.add("check_var");
        } else if(lit.equals("natural_literal")){
            getNextToken();
            parseTree.add("check_var");
        }
        else{
            // System.out.println("error");
        }
    }
    public  void checkAss (){
        String ass = currentToken();
        if(ass.equals("=")){
            parseTree.add("equal");
            getNextToken();
            
        } else if(ass.equals("==")){
            getNextToken();
            parseTree.add("equal ");
        } else if(ass.equals("<")){
            parseTree.add("less than");
            getNextToken();
        }  else if(ass.equals("<=")){
            getNextToken();
            parseTree.add("less than equal too ");
        }  else if(ass.equals(">=")){
            parseTree.add("greater than or equal too");
            getNextToken();
            
        } else if(ass.equals("!=")){
            parseTree.add("not eqal too ");
            getNextToken();
            
        }
        
    }

    // checks syntax in if statement 
    public void checkIfStatement(){
        String place = currentToken();
        if(place.contains("if") ){
            getNextToken();
        }
        else if(place.contains("{")){
            getNextToken();
            } else if(place.contains(("real_literal")) || place.contains("natural_literal") || place.contains("bool_literal") || place.contains("char_literal") || place.contains("string_literal")){
                getNextToken();
            } else if(place.contains("}")){

            } else{
                // System.out.print("error");
            }
           
        
        } 

// gets the next token 
    public String getNextToken(){
        if(x<listOfTokens.size()-1){
            ++x;
            return listOfTokens.get(x).lexemeRep;

        }
        else return "end";
    }
    public String currentToken(){
        return listOfTokens.get(x).lexemeRep;
    }
   

    
    

    public String getTree(){
        checkLiterals();
        checkKeywords();
        return parseTree.toString();

    }
   
    public  void checkKeywords (){
        String keys = currentToken();
        if(keys.equals("if")){
            getNextToken();
            parseTree.add("check_keyword");
        } else if(keys.equals("else")){
            getNextToken();
            parseTree.add("check_keyword");
        } else if(keys.equals("for")){
            getNextToken();
            parseTree.add("check_keyword");
        }
        
    }
    public void checkSymbols (){
        String sym = currentToken();
        if(sym.equals("+")){
            getNextToken();
            parseTree.add("addition");
        } else if(sym.equals("-")){
            getNextToken();
            parseTree.add("subtraction");
        } else if(sym.equals("*")){
            getNextToken();
            parseTree.add("multiplication");
        }
        
    }
}




