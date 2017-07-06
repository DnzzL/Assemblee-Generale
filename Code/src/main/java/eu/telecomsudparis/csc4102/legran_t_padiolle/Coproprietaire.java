package eu.telecomsudparis.csc4102.legran_t_padiolle;

import java.util.HashMap;

public class Coproprietaire {

	@Override
	public String toString() {
		return "Coproprietaire [nom=" + nom + ", prenom=" + prenom + "]";
	}

	private String nom;
	private String prenom;
	
	private Syndic syndic = Syndic.getInstance();

	// Map reliant coproprietes et les quote-parts relatif à un coproprietaire
	private HashMap<Copropriete, Double> mapCoproprietes = new HashMap<Copropriete, Double>();

	public Coproprietaire(String nom, String prenom) {
		if(nom == null) {
			throw new IllegalArgumentException("Nom incorrect: " + nom);
		}
		if(prenom == null) {
			throw new IllegalArgumentException("Prénom incorrect: " + prenom);
		}
		this.nom = nom;
		this.prenom = prenom;
		syndic.getListeCoproprietaires().add(this);
	}
	
	public void ajouterCopropriete(Copropriete copropriete, double quotePart) {
		if((quotePart == 0) || (quotePart >1)) {
			throw new IllegalArgumentException("Quote-part incorrecte: " + quotePart);
		}
		if(copropriete == null) {
			throw new IllegalArgumentException("Copropriete incorrecte: " + copropriete);
		}
		this.mapCoproprietes.put(copropriete, quotePart);
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public HashMap<Copropriete, Double> getMapCoproprietes() {
		return mapCoproprietes;
	}

	public void setMapCoproprietes(HashMap<Copropriete, Double> mapCoproprietes) {
		this.mapCoproprietes = mapCoproprietes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coproprietaire other = (Coproprietaire) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	
}
