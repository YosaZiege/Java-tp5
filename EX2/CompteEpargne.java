public class CompteEpargne extends CompteBancaire {
    private double tauxInteret; 
   public CompteEpargne(String numero, double soldeInitial, String nomTitulaire, double tauxInteret) {
        super(numero, soldeInitial, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }
    
    public double getTauxInteret() {
        return tauxInteret;
    }
    
    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
    
    public void calculerInterets() {
        double interets = solde * tauxInteret / 100;
        solde += interets;
        System.out.println("Intérêts de " + interets + "€ ajoutés au compte. Nouveau solde: " + solde + "€");
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Taux d'intérêt: " + tauxInteret + "%";
    }
}
