public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Création d'un entier naturel avec valeur 5:");
            EntierNaturel entier1 = new EntierNaturel(5);
            System.out.println("Valeur de l'entier: " + entier1.getVal());
            
            System.out.println("\nTentative de création d'un entier naturel avec valeur -3:");
            try {
                EntierNaturel entier2 = new EntierNaturel(-3);
            } catch (NombreNegatifException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Valeur négative: " + e.getValeurNegative());
            }
            
            System.out.println("\nModification de la valeur à 10:");
            entier1.setVal(10);
            System.out.println("Nouvelle valeur: " + entier1.getVal());
            
            System.out.println("\nTentative de modification avec une valeur négative (-7):");
            try {
                entier1.setVal(-7);
            } catch (NombreNegatifException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Valeur négative: " + e.getValeurNegative());
            }
            
            System.out.println("\nDécrémentation de l'entier:");
            entier1.decrementer();
            System.out.println("Valeur après décrémentation: " + entier1.getVal());
            
            System.out.println("\nDécrémentation jusqu'à 0:");
            while (entier1.getVal() > 0) {
                entier1.decrementer();
                System.out.println("Valeur après décrémentation: " + entier1.getVal());
            }
            
            System.out.println("\nTentative de décrémentation en-dessous de 0:");
            try {
                entier1.decrementer();
            } catch (NombreNegatifException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Valeur négative: " + e.getValeurNegative());
            }
            
        } catch (Exception e) {
            System.out.println("Exception non prévue: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
