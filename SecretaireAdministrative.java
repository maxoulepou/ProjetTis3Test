/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 *
 * @author semenovg
 */
public class SecretaireAdministrative extends Personne {

    private String motDePasse; 
    
    public SecretaireAdministrative(String nom, String prenom) {
        super(nom, prenom);
    }
    public SecretaireAdministrative(String nom, String prenom, String motDePasse){
        super(nom, prenom);
        this.motDePasse = motDePasse;
    }
    
     public void setMotDePasse(String m) {
        this.motDePasse = m;
    }
     
    @Override
     public String toString(){
         return "Secretaire administrative : " + super.toString();
     }
   
}
