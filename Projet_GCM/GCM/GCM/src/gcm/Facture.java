/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcm;


public class Facture {
   int referencefacture;
   String montant;
   String nompatient;
   String date_paiement;
   
   
	public int getReferencefacture() {
		return referencefacture;
	}
	public void setReferencefacture(int referencefacture) {
		this.referencefacture = referencefacture;
	}
	public String getMontat() {
		return montant;
	}
	public void setMontat(String montat) {
		this.montant = montat;
	}
	public String getNompatient() {
		return nompatient;
	}
	public void setNompatient(String nompatient) {
		this.nompatient = nompatient;
	}
	public String getDate_paiement() {
		return date_paiement;
	}
	public void setDate_paiement(String date_paiement) {
		this.date_paiement = date_paiement;
	}
	public Facture(int referencefacture, String montant, String nompatient, String date_paiement) {
		super();
		this.referencefacture = referencefacture;
		this.montant = montant;
		this.nompatient = nompatient;
		this.date_paiement = date_paiement;
        }
}
