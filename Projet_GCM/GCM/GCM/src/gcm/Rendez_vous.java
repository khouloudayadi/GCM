/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcm;

/**
 *
 * @author Client
 */
public class Rendez_vous {
  private   int idrdv ;
   private String date;
   private String heure;
    private String nom_patient;

    public  Rendez_vous(int idrdv,String date, String heure ,String nom_patient)
    {
        this.idrdv=idrdv;
        this.date= date;
        this.heure=heure;
        this.nom_patient=nom_patient;
    }
    public int getIdrdv(){return idrdv;}
    public String getDate(){return date;}
    public String getHeure(){return heure;}
    public String getNompatient(){return nom_patient;}
    public void setIdrdv(int id){idrdv=id;}
    public void setDate(String d){date=d;} 
    public void setHeure(String h){heure=h;}
    public void setNompatient(String nom){nom_patient=nom;}
      
}
