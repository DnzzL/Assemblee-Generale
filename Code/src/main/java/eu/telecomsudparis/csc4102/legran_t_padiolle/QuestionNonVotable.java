package eu.telecomsudparis.csc4102.legran_t_padiolle;

public class QuestionNonVotable extends Question {
	
	private String compteRenduDiscussion;
	
	public QuestionNonVotable(String sujetQuestion) {
		super(sujetQuestion);
	}
	
	public String getCompteRenduDiscussion() {
		return compteRenduDiscussion;
	}

	public void setCompteRenduDiscussion(String compteRenduDiscussion) {
		this.compteRenduDiscussion = compteRenduDiscussion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((compteRenduDiscussion == null) ? 0 : compteRenduDiscussion.hashCode());
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
		QuestionNonVotable other = (QuestionNonVotable) obj;
		if (compteRenduDiscussion == null) {
			if (other.compteRenduDiscussion != null)
				return false;
		} else if (!compteRenduDiscussion.equals(other.compteRenduDiscussion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionNonVotable [compteRenduDiscussion=" + compteRenduDiscussion + "]";
	}
	
}
