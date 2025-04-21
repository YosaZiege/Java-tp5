public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;
    
    public CompteCourant(String numero, double soldeInitial, String nomTitulaire, double decouvertAutorise) {
        super(numero, soldeInitial, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }
    
    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
    
    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }
    
    @Override
    public void retrait(double montant) throws FondsInsuffisantsException {
        if (montant <= 0) {
            System.out.println("Le montant du retrait doit être positif.");
            return;
        }
        
        if (montant > solde + decouvertAutorise) {
            throw new FondsInsuffisantsException(
                "Fonds insuffisants pour effectuer le retrait (même avec découvert autorisé)", 
                montant, solde);
        }
        
        solde -= montant;
        System.out.println("Retrait de " + montant + "€ effectué. Nouveau solde: " + solde + "€");
        
        if (solde < 0) {
            System.out.println("Attention: votre compte est à découvert.");
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Découvert autorisé: " + decouvertAutorise + "€";
    }
}
