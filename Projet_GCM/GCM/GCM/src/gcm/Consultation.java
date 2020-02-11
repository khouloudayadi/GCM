/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcm;



public class Consultation {
  private int idconsultation;
private String nom_maladie;
private String prescription_medicale;
private String observation;
private String analyse;
private String date_consultation;
private String numero_cnam;

public Consultation(String nom_maladie,String prescription_medicale,String observation,String analyse,String date_consultation,String numero_cnam)
{

this.nom_maladie=nom_maladie;
this.prescription_medicale=prescription_medicale;
this.observation=observation;
this.analyse=analyse;
this.date_consultation=date_consultation;
this.numero_cnam= numero_cnam;

}

	public int getIdconsultation() {
		return idconsultation;
	}
	public void setIdconsultation(int idconsultation) {
		this.idconsultation = idconsultation;
	}
	public String getNom_maladie() {
		return nom_maladie;
	}
	public void setNom_maladie(String nom_maladie) {
		this.nom_maladie = nom_maladie;
	}
	public String getPrescription_medicale() {
		return prescription_medicale;
	}
	public void setPrescription_medicale(String prescription_medicale) {
		this.prescription_medicale = prescription_medicale;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getAnalyse() {
		return analyse;
	}
	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}
	public String getDate_consultation() {
		return date_consultation;
	}
	public void setDate_cons(String date_consultation) {
		this.date_consultation = date_consultation;
	}
	public String getNumero_cnam() {
		return numero_cnam;
	}
	public void setNumero_cnam(String numero_cnam) {
		this.numero_cnam = numero_cnam;
	}



}
