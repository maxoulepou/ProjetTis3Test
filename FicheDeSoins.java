package princetonPlainsboro;

import java.util.ArrayList;



class FicheDeSoins {

    private ArrayList<Acte> actes;
    Patient  patient;
    public Medecin  medecin;
    private Date  date;
    
    /**
   * 
   * @element-type Acte
   */
  
  
  public FicheDeSoins(Patient patient, Medecin medecin, Date date) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        actes = new ArrayList<Acte>();   // liste vide
  }

  public Patient getPatient() {
 return patient;
  }

  public Medecin getMedecin() {
 return medecin;
  }

  public Date getDate() {
 return date;
  }

  public void ajouterActe(Acte acte) {
        actes.add(acte);
  }

  public void ajouterActe(Code code, int coefficient) {
        Acte acte = new Acte(code, coefficient);
        actes.add(acte);
  }

  public void afficher() {
        System.out.println("Fiche de soins du " + date.toString());
        System.out.println("- medecin : " + medecin.toString());
        System.out.println("- patient : " + patient.toString());
        System.out.println("- actes medicaux :");
        for (int i=0; i<actes.size(); i++) {
            Acte a = actes.get(i);
            System.out.println("    > " + a.toString());
            }
        
  }

  public double coutTotal() {
        double total = 0;
        for (int i=0; i<actes.size(); i++) {
            Acte a = actes.get(i);
            total += a.cout();
            }
        return total;
  }

}