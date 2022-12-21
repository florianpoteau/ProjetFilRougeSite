package Fil_Rouge;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "produit")

 class Sandwich implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true)
	private int id;
	
	@Column ( name = "noproduit", nullable = false)
	private int noproduit;
	
	@Column ( name = "nom", nullable = false)
	private String nom;
	
	@Column ( name = "produit1", nullable = false)
	private String produit1;
	
	@Column ( name = "produit2", nullable = false)
	private String produit2;
	
	/**
	 * @return the quantité
	 */
	public float getQuantité() {
		return quantité;
	}

	/**
	 * @param quantité the quantité to set
	 */
	public void setQuantité(float quantité) {
		this.quantité = quantité;
	}

	@Column ( name = "produit3", nullable = false)
	private String produit3;
	
	@Column (name = "produit4", nullable = false)
	private String produit4;
	
	@Column (name = "produit5", nullable = false)
	private String produit5;
	
	@Column (name = "prix", nullable = false)
	private float prix;
	
	@Column (name = "quantité", nullable = false)
	private float quantité;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the noproduit
	 */
	public int getNoproduit() {
		return noproduit;
	}

	/**
	 * @param noproduit the noproduit to set
	 */
	public void setNoproduit(int noproduit) {
		this.noproduit = noproduit;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the produit1
	 */
	public String getProduit1() {
		return produit1;
	}

	/**
	 * @param produit1 the produit1 to set
	 */
	public void setProduit1(String produit1) {
		this.produit1 = produit1;
	}

	/**
	 * @return the produit2
	 */
	public String getProduit2() {
		return produit2;
	}

	/**
	 * @param produit2 the produit2 to set
	 */
	public void setProduit2(String produit2) {
		this.produit2 = produit2;
	}

	/**
	 * @return the produit3
	 */
	public String getProduit3() {
		return produit3;
	}

	/**
	 * @param produit3 the produit3 to set
	 */
	public void setProduit3(String produit3) {
		this.produit3 = produit3;
	}

	/**
	 * @return the produit4
	 */
	public String getProduit4() {
		return produit4;
	}

	/**
	 * @param produit4 the produit4 to set
	 */
	public void setProduit4(String produit4) {
		this.produit4 = produit4;
	}

	/**
	 * @return the produit5
	 */
	public String getProduit5() {
		return produit5;
	}

	/**
	 * @param produit5 the produit5 to set
	 */
	public void setProduit5(String produit5) {
		this.produit5 = produit5;
	}

	/**
	 * @return the prix
	 */
	public float getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(float prix) {
		this.prix = prix;
	}

}
