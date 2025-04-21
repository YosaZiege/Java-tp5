public class CompteBancaire {
    protected String numero;
    protected double solde;
    protected String nomTitulaire;
    
    public CompteBancaire(String numero, double soldeInitial, String nomTitulaire) {
        this.numero = numero;
        this.solde = soldeInitial;
        this.nomTitulaire = nomTitulaire;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public double getSolde() {
        return solde;
    }
    
    public String getNomTitulaire() {
        return nomTitulaire;
    }
    
    public void depot(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + "€ effectué. Nouveau solde: " + solde + "€");
        } else {
            System.out.println("Le montant du dépôt doit être positif.");
        }
    }
    
    public void retrait(double montant) throws FondsInsuffisantsException {
        if (montant <= 0) {
            System.out.println("Le montant du retrait doit être positif.");
            return;
        }
        
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour effectuer le retrait", 
                                                montant, solde);
        }
        
        solde -= montant;
        System.out.println("Retrait de " + montant + "€ effectué. Nouveau solde: " + solde + "€");
    }
    
    public void afficherSolde() {
        System.out.println("Compte n°" + numero + " - Titulaire: " + nomTitulaire + 
                           " - Solde actuel: " + solde + "€");
    }
    
    public void transferer(double montant, CompteBancaire destinataire) 
            throws FondsInsuffisantsException, CompteInexistantException {
        if (destinataire == null) {
            throw new CompteInexistantException("Le compte destinataire n'existe pas", "inconnu");
        }
        
        this.retrait(montant);
        
        destinataire.depot(montant);
        
        System.out.println("Transfert de " + montant + "€ effectué du compte " + 
                           this.numero + " vers le compte " + destinataire.getNumero());
    }
    
    @Override
    public String toString() {
        return "Compte n°" + numero + " - Titulaire: " + nomTitulaire + " - Solde: " + solde + "€";
    }
}
