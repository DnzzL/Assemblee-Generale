package eu.telecomsudparis.csc4102.legran_t_padiolle;

import java.util.ArrayList;

import eu.telecomsudparis.csc4102.util.OperationImpossible;

public class QuestionVotable extends Question {

	private int nombreOui;
	private int nombreNon;
	private int nombreAbstention;
	private Evote resultatVote;

	private ArrayList<Vote> listeVotes = new ArrayList<Vote>();
	private StrategieDeCalculVote strategieDeCalculVote;
	
	public QuestionVotable(String sujetQuestion, StrategieDeCalculVote strategieDeCalculVote) {
		super(sujetQuestion);
		this.strategieDeCalculVote = strategieDeCalculVote;
	}
	
	public void ajouterVoteCoproprietaire(Coproprietaire coproprietaire, Evote contenuVote) throws OperationImpossible{
		if(assembleeGenerale.hasVote(coproprietaire)){
			throw new OperationImpossible("Le copropriétaire" + coproprietaire + "a déjà voté");
		}
		Vote vote = new Vote(this, coproprietaire, contenuVote);
		this.getListeVotes().add(vote);
		assembleeGenerale.setHasVote(coproprietaire);
	}
	
	public void calculerIssueVote(){
		for(Vote vote: listeVotes){
			Coproprietaire coproprietaire = vote.getCoproprietaire();
			Copropriete copropriete = assembleeGenerale.getCopropriete();
			double quotePart = coproprietaire.getMapCoproprietes().get(copropriete);
			int nombreVoix = 0;
			if(quotePart > 0.5){
				nombreVoix = (int) ((1 - quotePart)*1000);
			} else {
				nombreVoix = (int) (quotePart*1000);
			}

			switch(vote.getContenuVote()){
			case OUI: this.nombreOui += nombreVoix;
			break;
			case NON: this.nombreNon += nombreVoix;
			break;
			case ABSTENTION: this.nombreAbstention += nombreVoix;
			break;
			default: throw new IllegalArgumentException("Aucun vote");
			}
		}
	}

	public void afficherResultatVote(){
		System.out.println("Affichage du résulat du vote");
		
		System.out.println("Nombre de oui: " + nombreOui);
		System.out.println("Nombre de non: " + nombreNon);
		System.out.println("Nombre d'abstention: " + nombreAbstention);

		this.strategieDeCalculVote.algorithmeDeCalcul(this);
	}


	public AssembleeGenerale getAssembleeGenerale() {
		return assembleeGenerale;
	}

	public int getNombreOui() {
		return nombreOui;
	}

	public int getNombreNon() {
		return nombreNon;
	}

	public int getNombreAbstention() {
		return nombreAbstention;
	}

	public ArrayList<Vote> getListeVotes() {
		return listeVotes;
	}

	public Evote getResultatVote() {
		return resultatVote;
	}

	public void setResultatVote(Evote resultatVote) {
		this.resultatVote = resultatVote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nombreAbstention;
		result = prime * result + nombreNon;
		result = prime * result + nombreOui;
		result = prime * result + ((resultatVote == null) ? 0 : resultatVote.hashCode());
		result = prime * result + ((strategieDeCalculVote == null) ? 0 : strategieDeCalculVote.hashCode());
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
		QuestionVotable other = (QuestionVotable) obj;
		if (nombreAbstention != other.nombreAbstention)
			return false;
		if (nombreNon != other.nombreNon)
			return false;
		if (nombreOui != other.nombreOui)
			return false;
		if (resultatVote != other.resultatVote)
			return false;
		if (strategieDeCalculVote == null) {
			if (other.strategieDeCalculVote != null)
				return false;
		} else if (!strategieDeCalculVote.equals(other.strategieDeCalculVote))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionVotable [strategieDeCalculVote=" + strategieDeCalculVote + "]";
	}

}
