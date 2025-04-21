
public class NombreNegatifException extends Exception {
    private int valeurNegative;
    
    public NombreNegatifException(String message, int valeurNegative) {
        super(message);
        this.valeurNegative = valeurNegative;
    }
    
    public int getValeurNegative() {
        return valeurNegative;
    }
}
