package eu.telecomsudparis.csc4102.legran_t_padiolle;

public class FicheDeRepresentation extends FicheDePresence{
	
	private Coproprietaire mandataire;

	public FicheDeRepresentation(Coproprietaire coproprietaire, Coproprietaire mandataire) {
		super(coproprietaire);
		if(mandataire == null) {
			throw new IllegalArgumentException("Mandataire incorrect: " + mandataire);
		}
		if (!assembleeGenerale.isMandatPossible(mandataire)) {
			throw new IllegalArgumentException("Le mandataire a atteint le maximum de mandats");
		}
		this.mandataire = mandataire;
	}

	public Coproprietaire getMandataire() {
		return mandataire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mandataire == null) ? 0 : mandataire.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FicheDeRepresentation other = (FicheDeRepresentation) obj;
		if (mandataire == null) {
			if (other.mandataire != null)
				return false;
		} else if (!mandataire.equals(other.mandataire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FicheDeRepresentation [mandataire=" + mandataire + "]";
	}
	
}
