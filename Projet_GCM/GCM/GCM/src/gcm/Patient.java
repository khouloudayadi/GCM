
package gcm;


public class Patient {
   String numcnam ;
    String nom ;
    String prenom ;
    String adresse ;
    String date_naissance ;
    String tel ;
    String maladie_chronique;
    String sang;
    String mail ;
    /**
     * Creates new form patient
     */
 public Patient (String num,String n,String p,String adr,String m ,String t, String d,String ma,String s)
 {
     numcnam= num;
     nom=n;
     prenom=p;
     adresse=adr;
     date_naissance=d;
     tel=t;
     maladie_chronique=ma;
     sang= s;
     mail= m;  
 }
 public String getNum()
 {
     return numcnam ;
     
 }
 public String getNom()
 {
     return nom ;
     
 }
 public String getPrenom()
 {
     return prenom ;
     
 }
 public String getAdresse()
 {
     return adresse ;
     
 }
  public String getDate()
 {
     return date_naissance ;
     
 }
   public String getMaladie()
 {
     return maladie_chronique ;
     
 }
    public String getMail()
 {
     return mail ;
     
 }
      public String getSang()
 {
     return sang ;
     
 }
        public String getTel()
 {
     return tel ;
     
 }
}
