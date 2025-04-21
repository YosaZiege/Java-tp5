

public class EntierNaturel {
    private int val;
    
    public EntierNaturel(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("La valeur fournie est négative", val);
        }
        this.val = val;
    }
    
    public int getVal() {
        return val;
    }
    
    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("La valeur fournie est négative", val);
        }
        this.val = val;
    }
    
    public void decrementer() throws NombreNegatifException {
        if (val == 0) {
            throw new NombreNegatifException("Décrémentation impossible: résultat négatif", -1);
        }
        this.val--;
    }
}
