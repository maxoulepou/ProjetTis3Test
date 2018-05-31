package princetonPlainsboro;

class Patient extends Personne {

    private String numSecu;
    private Date dateDeNaissance;
    private String adresse;

    public Patient(String nom, String prenom, String numSecu) {
        super(nom, prenom);
        this.adresse = "Domicile non renseigné";
    }

    public Patient(String nom, String prenom, String numSecu, String adresse) {
        super(nom, prenom);
        this.adresse = adresse;
        this.numSecu = numSecu;
    }

    @Override
    public String toString() {
        return getPrenom() + " " + getNom() + "\n Numéro de sécurité sociale : " + getNumSecu() + "\n Adresse : " + getAdresse();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return super.getNom().equals(p.getNom()) && super.getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    public String getNumSecu() {
        return numSecu;
    }

    public String getAdresse() {
        return adresse;
    }
    /**
     * @param numSecu the numSecu to set
     */
    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    /**
     * @param dateDeNaissance the dateDeNaissance to set
     */
    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
