
package eu.telecomsudparis.csc4102.legran_t_padiolle;

public class Vote {
	
	private Evote contenuVote;
	
	private Syndic syndic = Syndic.getInstance();
	private AssembleeGenerale assembleeGenerale = syndic.getAssembleeGeneraleEnCours();
	private Coproprietaire coproprietaire;
	private QuestionVotable questionVotable;

	public Vote(QuestionVotable questionVotable, Coproprietaire coproprietaire, Evote contenuVote) {
		if((questionVotable == null)) {
			throw new IllegalArgumentException("Question incorrecte: " + questionVotable);
		}
		if((coproprietaire == null)) {
			throw new IllegalArgumentException("Coproprietaire incorrect: " + coproprietaire);
		}
		if(assembleeGenerale == null){
			throw new IllegalArgumentException("Aucune assemblée générale en cours");
		}
		if(!assembleeGenerale.hasFicheDePresence(coproprietaire)) {
			throw new IllegalArgumentException("Coproprietaire n'a pas de fiche de présence: ");
		}
		if(contenuVote == null) {
			throw new IllegalArgumentException("Contenu vote incorrect :" + contenuVote);
		}
		this.questionVotable = questionVotable;
		this.coproprietaire = coproprietaire;
		this.contenuVote = contenuVote;
	}

	public Evote getContenuVote() {
		return contenuVote;
	}
	
	public Coproprietaire getCoproprietaire() {
		return coproprietaire;
	}

	public void setCoproprietaire(Coproprietaire coproprietaire) {
		this.coproprietaire = coproprietaire;
	}

	public void setContenuVote(Evote contenuVote) {
		this.contenuVote = contenuVote;
	}

	public void ajouterVote(Vote vote){
		questionVotable.getListeVotes().add(vote);
	}

	public QuestionVotable getQuestionVotable() {
		return questionVotable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assembleeGenerale == null) ? 0 : assembleeGenerale.hashCode());
		result = prime * result + ((contenuVote == null) ? 0 : contenuVote.hashCode());
		result = prime * result + ((coproprietaire == null) ? 0 : coproprietaire.hashCode());
		result = prime * result + ((questionVotable == null) ? 0 : questionVotable.hashCode());
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
		Vote other = (Vote) obj;
		if (assembleeGenerale == null) {
			if (other.assembleeGenerale != null)
				return false;
		} else if (!assembleeGenerale.equals(other.assembleeGenerale))
			return false;
		if (contenuVote != other.contenuVote)
			return false;
		if (coproprietaire == null) {
			if (other.coproprietaire != null)
				return false;
		} else if (!coproprietaire.equals(other.coproprietaire))
			return false;
		if (questionVotable == null) {
			if (other.questionVotable != null)
				return false;
		} else if (!questionVotable.equals(other.questionVotable))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vote [contenuVote=" + contenuVote + ", assembleeGenerale=" + assembleeGenerale + "]";
	}

}
