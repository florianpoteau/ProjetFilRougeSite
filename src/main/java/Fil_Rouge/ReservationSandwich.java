package Fil_Rouge;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table ( name = "reservationsandwich")

public class ReservationSandwich implements Serializable{
		
		@Autowired
		
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
		
		@Column ( name = "produit3", nullable = false)
		private String produit3;
		
		@Column (name = "produit4", nullable = false)
		private String produit4;
		
		@Column (name = "produit5", nullable = false)
		private String produit5;
		
		@Column (name = "prix", nullable = false)
		private float prix;


}
