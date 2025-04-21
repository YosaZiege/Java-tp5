import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();
        
        try {
            System.out.println("=== CRÉATION DES COMPTES ===");
            CompteCourant compteCourant1 = new CompteCourant("CC001", 1000, "Martin Dupont", 500);
            CompteCourant compteCourant2 = new CompteCourant("CC002", 2500, "Sophie Durand", 1000);
            CompteEpargne compteEpargne1 = new CompteEpargne("CE001", 5000, "Martin Dupont", 2.5);
            CompteEpargne compteEpargne2 = new CompteEpargne("CE002", 10000, "Julie Moreau", 3.0);
            
            comptes.add(compteCourant1);
            comptes.add(compteCourant2);
            comptes.add(compteEpargne1);
            comptes.add(compteEpargne2);
            
            System.out.println("\n=== LISTE DES COMPTES ===");
            for (CompteBancaire compte : comptes) {
                System.out.println(compte);
            }
            
            System.out.println("\n=== OPÉRATIONS SUR LES COMPTES ===");
            
            System.out.println("\n--- Dépôt ---");
            compteCourant1.depot(500);
            
            System.out.println("\n--- Retrait ---");
            compteCourant1.retrait(300);
            
            System.out.println("\n--- Tentative de retrait avec fonds insuffisants ---");
            try {
                compteEpargne1.retrait(6000);
            } catch (FondsInsuffisantsException e) {
                System.out.println("Erreur: " + e.getMessage());
                System.out.println("Montant demandé: " + e.getMontantDemande() + "€");
                System.out.println("Solde disponible: " + e.getSoldeDispo() + "€");
            }
            
            System.out.println("\n--- Retrait avec découvert autorisé ---");
            try {
                compteCourant1.retrait(1500);  
         } catch (FondsInsuffisantsException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
            
            System.out.println("\n--- Calcul des intérêts ---");
            compteEpargne1.calculerInterets();
            
            System.out.println("\n--- Transfert entre comptes ---");
            try {
                compteEpargne2.transferer(2000, compteCourant2);
            } catch (Exception e) {
                System.out.println("Erreur lors du transfert: " + e.getMessage());
            }
            
            System.out.println("\n--- Tentative de transfert vers un compte inexistant ---");
            try {
                compteCourant2.transferer(500, null);
            } catch (CompteInexistantException e) {
                System.out.println("Erreur: " + e.getMessage());
                System.out.println("Numéro de compte: " + e.getNumeroCompte());
            } catch (FondsInsuffisantsException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
            
            System.out.println("\n=== SUPPRESSION D'UN COMPTE ===");
            comptes.remove(compteCourant1);
            System.out.println("Compte " + compteCourant1.getNumero() + " supprimé.");
            
            System.out.println("\n=== LISTE DES COMPTES APRÈS SUPPRESSION ===");
            for (CompteBancaire compte : comptes) {
                System.out.println(compte);
            }
            
            System.out.println("\n=== RECHERCHE D'UN COMPTE ===");
            String numeroRecherche = "CE001";
            CompteBancaire compteRecherche = rechercherCompte(comptes, numeroRecherche);
            
            if (compteRecherche != null) {
                System.out.println("Compte trouvé: " + compteRecherche);
            } else {
                System.out.println("Aucun compte trouvé avec le numéro " + numeroRecherche);
            }
            
            System.out.println("\nRecherche d'un compte inexistant:");
            String numeroInexistant = "CC999";
            CompteBancaire compteInexistant = rechercherCompte(comptes, numeroInexistant);
            
            if (compteInexistant != null) {
                System.out.println("Compte trouvé: " + compteInexistant);
            } else {
                System.out.println("Aucun compte trouvé avec le numéro " + numeroInexistant);
            }
            
        } catch (Exception e) {
            System.out.println("Une erreur inattendue s'est produite: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static CompteBancaire rechercherCompte(ArrayList<CompteBancaire> comptes, String numero) {
        for (CompteBancaire compte : comptes) {
            if (compte.getNumero().equals(numero)) {
                return compte;
            }
        }
        return null;
    }
}
