package princetonPlainsboro;

class Test {

    public static void main(String[] args) {
        LectureXML test = new LectureXML("dossiers.xml");

        DossierMedical dm = test.getDossier();
       
        System.out.println("\n********\n");
        Patient p1 = new Patient("Bole", "Pat", "123456789987415", "5 rue de la rue");
        System.out.println("Patient :  " + p1.toString());
        System.out.println("> cout de " + p1.getNom() + " : " + dm.coutPatient(p1));
        System.out.println("\n********\n");
        String spe = "Cardiologue";
        System.out.println("> cout de la specialite '" + spe + "' : " + dm.coutSpecialite(spe));
        System.out.println("\n********\n");
        Medecin m1 = new Medecin("Deblouze", "Agathe", "Cardiologue", "0656859575");
        System.out.println("\n********\n");
        Date d1 = new Date(30, 15, 1, 11, 2005);
        Date d2 = new Date(45, 20, 5, 1, 2006);
        System.out.println("> nombre de fiches entre " + d1 + " et " + d2 + " : " + dm.nombreFichesIntervalle(d1, d2));
        System.out.println("\n********\n");
        System.out.println();
        System.out.println("Dossier trie selon les dates :");
        dm.trierDates();
        System.out.println("\n********\n");
        System.out.println();
        System.out.println("Dossier trie selon les couts :");
         dm.trier(new ComparaisonFichesCouts());
        System.out.println("Fiches entre deux dates " + d1 + " et " + d2 + " : ");
        dm.afficherFicheIntervalle(d1, d2);
        System.out.println("\n********\n");
        dm.afficherListePatients(m1);
        System.out.println("\n********\n");
        dm.afficherTousLesMedecins();
        System.out.println("\n********\n");
        dm.afficherTousLesPatients();
        System.out.println("\n********\n");
        //dm.getFichesPatients(p1);
        Medecin m2 = new Medecin("dfgyie", "fggggg", "Cardiologue", "0656859575");
        dm.ajouterMedecin(m2);
         dm.afficher();
        
    }

}
