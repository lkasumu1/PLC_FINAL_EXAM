
public class Token {
    
    public Token(int tCode, String lexemeRep) {
        this.tCode=tCode;
        this.lexemeRep=lexemeRep;
    }
    public String toString(){
        return this.lexemeRep + " " + this.tCode;
    }
    public String lexemeRep; //String for lexeme representation
    public int tCode; //Int for token code 


}
