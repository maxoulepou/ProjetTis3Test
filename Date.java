package princetonPlainsboro;

class Date {

  private int jour;

  private int mois;

  private int annee;

  private int heure;

  private int minute;

  
  public Date(int minute, int heure, int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.minute = minute;
        this.heure = heure;
  }

  @Override
  public String toString() {
        return jour + "/" + mois + "/" + annee;
  }

  @Override
  public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date)o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour);
            }
        else
            return false;
  }

  public int compareTo(Object o) {
        Date d = (Date)o;
        if (annee != d.annee)
            return annee - d.annee;
        // ici on a forcement annee == d.annee :
        if (mois != d.mois)
            return mois  - d.mois;
        // ici on a forcement annee == d.annee et mois == d.mois :
        return jour - d.jour;
  }

}