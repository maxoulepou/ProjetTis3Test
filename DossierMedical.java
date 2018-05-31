package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;

class DossierMedical{

    private ArrayList<FicheDeSoins> fiches;

     private ArrayList<Medecin> medecins;
    
    
    public DossierMedical() {
        
        fiches = new ArrayList<FicheDeSoins>();  // liste vide
        medecins = new ArrayList<Medecin>();
    }

    public void ajouterFiche(FicheDeSoins fiche) {
        fiches.add(fiche);
    }

    public void afficher() {
        System.out.println("Dossier medical informatise :");
        System.out.println("-----------------------------");
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            f.afficher();
            // pour separer les fiches de soins :
            System.out.println("--------------------------------------");
        }
    }

    public double coutPatient(Patient p) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (p.equals(f.getPatient())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutMedecin(Medecin m) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutSpecialite(String specialite) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (specialite.equals(f.getMedecin().getSpecialite())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public void afficherListePatients(Medecin m) {
        System.out.println("> liste des patients du " + m.toString() + " :");
        ArrayList<Patient> liste = new ArrayList<Patient>();
        // 'liste' contient tous les patients deja affiches
        // --> ceci permet de ne pas reafficher un patient deja affiche
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    System.out.println(" - " + p.toString());
                    liste.add(p);
                }
            }
        }
    }

    public int nombreFichesIntervalle(Date d1, Date d2) {
        int n = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Date d = f.getDate();
            if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                n++;
            }
        }
        return n;
    }

    public void trierDates() {
        ArrayList<FicheDeSoins> copieFiches = new ArrayList<FicheDeSoins>(fiches);
        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins de date minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (f2.getDate().compareTo(f1.getDate()) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }

    public void trier(ComparaisonFiches c) {
        ArrayList<FicheDeSoins> copieFiches = new ArrayList<FicheDeSoins>(fiches);
        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }
    
    //afficher toutes les fiches par patient
    public ArrayList<FicheDeSoins> getFichesPatients (Patient p) {
    ArrayList<FicheDeSoins> fichesPatient = new ArrayList<FicheDeSoins>();
    for (FicheDeSoins f : fiches) {
        if(f.getPatient().equals(p)){
            fichesPatient.add(f);
        }
    }
        return fichesPatient;
    }

    // afficher la liste de tous les patients
    public void afficherTousLesPatients() {
        System.out.println("- Liste des patients : " + "\n");
        ArrayList<Patient> listePatients = new ArrayList<Patient>();
        //pour afficher un patient une seule fois (éviter les répétitions)
        for (int i = 0; i<fiches.size(); i++){
            FicheDeSoins f = fiches.get(i);
            Patient p = f.getPatient();
            if(!listePatients.contains(p)){
                System.out.println("- " + p.toString());
                listePatients.add(p);
            }
    }
    }
    // afficher la liste de tous les médecins
    public void afficherTousLesMedecins(){
        System.out.println("- Liste des médecins : " + "\n");
        ArrayList<Medecin> listeMedecins = new ArrayList<Medecin>();
        //pour afficher un médecin une seule fois (éviter les répétitions)
        for (int i = 0; i<fiches.size(); i++){
            FicheDeSoins f = fiches.get(i);
            Medecin m = f.getMedecin();
            if(!listeMedecins.contains(m)){
                System.out.println("- " + m.toString());
                listeMedecins.add(m);
            }
       }
    }
    // afficher les fiches de soin entre deux dates
    public String afficherFicheIntervalle(Date d1, Date d2){
    String texte = "Dossier médical entre le " + d1 + " et le " + d2 + " : \n------------------------\n";
    for (int i = 0; i<fiches.size(); i++){
        FicheDeSoins f = fiches.get(i);
        Date d = f.getDate();
        if(d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0){
            System.out.println(texte);
            f.afficher();
        }
    }
    return texte;
    }
    
    public void ajouterMedecin(Medecin m){
        medecins.add(m);
    }

}
