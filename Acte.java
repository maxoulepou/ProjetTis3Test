package princetonPlainsboro;

class Acte {

  private int coef;
  private Code code;
//  private String typeActe;
  private String observation;

  
  public Acte(Code code, int coef) {
        this.code = code;
        this.coef = 0;
  }
  
  public Acte(Code code, int coef, String observation) {
        this.code = code;
        this.coef = coef;
        this.observation = observation;
//        this.typeActe = typeActe;
  }

  public void setObservation(String obervation) {
      this.observation = observation;
  }
  
  public String getObservation(){
      return observation;
  }
  
  @Override
  public String toString() {
//        return code.toString() + ", coefficient : " + coef + "\n type : " + typeActe + ", observation " + observation ;
         return code.toString() + ", coefficient : " + coef + "\n observation " + getObservation();
  }

  public double cout() {
        return code.calculerCout(coef);
  }
}