package eu.telecomsudparis.csc4102.legran_t_padiolle;

import java.time.Instant;

public abstract class FicheDePresence {
	
	private boolean hasVote;
	private Instant heureRetard;
	private Instant heureDepart;
	
	protected Syndic syndic = Syndic.getInstance();
	private int nombreAgs = syndic.getListeAGs().size();
	protected AssembleeGenerale assembleeGenerale = syndic.getListeAGs().get(nombreAgs-1);
	
	private Coproprietaire coproprietaire;
	
	public AssembleeGenerale getAssembleeGenerale() {
		return assembleeGenerale;
	}

	public FicheDePresence(Coproprietaire coproprietaire) {
		if((coproprietaire == null)) {
			throw new IllegalArgumentException("Coproprietaire incorrect: " + coproprietaire);
		}
		this.coproprietaire = coproprietaire;
		this.hasVote = false;
	}

	public FicheDePresence(Coproprietaire coproprietaire, Instant heureRetard) {
		if((coproprietaire == null)) {
			throw new IllegalArgumentException("Coproprietaire incorrect: " + coproprietaire);
		}
		if((heureRetard == null)) {
			throw new IllegalArgumentException("Heure de retard incorrecte: " + heureRetard);
		}
		this.coproprietaire = coproprietaire;
		this.heureRetard = heureRetard;
		this.hasVote = false;
	}

	public boolean hasVote() {
		return hasVote;
	}

	public void setHasVote(boolean hasVote) {
		this.hasVote = hasVote;
	}

	public void definirHeureRetard(Instant heureRetard){
		this.heureDepart = heureRetard;
	}
	
	public void definirHeureDepart(Instant heureDepart){
		this.heureDepart = heureDepart;
	}

	public Coproprietaire getCoproprietaire() {
		return coproprietaire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assembleeGenerale == null) ? 0 : assembleeGenerale.hashCode());
		result = prime * result + ((coproprietaire == null) ? 0 : coproprietaire.hashCode());
		result = prime * result + (hasVote ? 1231 : 1237);
		result = prime * result + ((heureDepart == null) ? 0 : heureDepart.hashCode());
		result = prime * result + ((heureRetard == null) ? 0 : heureRetard.hashCode());
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
		FicheDePresence other = (FicheDePresence) obj;
		if (assembleeGenerale == null) {
			if (other.assembleeGenerale != null)
				return false;
		} else if (!assembleeGenerale.equals(other.assembleeGenerale))
			return false;
		if (coproprietaire == null) {
			if (other.coproprietaire != null)
				return false;
		} else if (!coproprietaire.equals(other.coproprietaire))
			return false;
		if (hasVote != other.hasVote)
			return false;
		if (heureDepart == null) {
			if (other.heureDepart != null)
				return false;
		} else if (!heureDepart.equals(other.heureDepart))
			return false;
		if (heureRetard == null) {
			if (other.heureRetard != null)
				return false;
		} else if (!heureRetard.equals(other.heureRetard))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FicheDePresence [coproprietaire=" + coproprietaire + ", heureRetard=" + heureRetard + ", heureDepart="
				+ heureDepart + "]";
	}
}
