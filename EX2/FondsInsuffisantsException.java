public class FondsInsuffisantsException extends Exception {
    private double montantDemande;
    private double soldeDispo;
    
    public FondsInsuffisantsException(String message, double montantDemande, double soldeDispo) {
        super(message);
        this.montantDemande = montantDemande;
        this.soldeDispo = soldeDispo;
    }
    
    public double getMontantDemande() {
        return montantDemande;
    }
    
    public double getSoldeDispo() {
        return soldeDispo;
    }
}


