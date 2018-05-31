package princetonPlainsboro;

class Medecin extends Personne {

    private String specialite;
    private String numTel;
    private String motDePasse;

    public Medecin(String nom, String prenom, String specialite,String numTel) {
        super(nom, prenom);
        this.specialite = specialite;
        this.numTel = numTel;

    }

    public String getSpecialite() {
        return specialite;
    }

    public void setMotDePasse(String m) {
        this.motDePasse = m;
    }

    public String getNumTel() {
        return numTel;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return super.getNom().equals(p.getNom()) && super.getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Dr " + super.getPrenom() + " " + super.getNom() + ", "+ specialite+"  ,  "+numTel;
    }

}
