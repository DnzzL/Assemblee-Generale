package eu.telecomsudparis.csc4102.legran_t_padiolle;
import java.time.LocalDate;

import eu.telecomsudparis.csc4102.util.Datutil;

public abstract class Question {
	
	private String sujetQuestion;
	private LocalDate dateQuestion;
	
	protected Syndic syndic = Syndic.getInstance();
	private int nombreAgs = syndic.getListeAGs().size();
	protected AssembleeGenerale assembleeGenerale = syndic.getListeAGs().get(nombreAgs-1);
	
	public Question(String sujetQuestion) {
		if(sujetQuestion == null) {
			throw new IllegalArgumentException("Sujet incorrect: " + sujetQuestion);
		}
		this.sujetQuestion = sujetQuestion;
		this.dateQuestion = Datutil.aujourdhui();
	}

	public String getSujetQuestion() {
		return sujetQuestion;
	}

	public void setSujetQuestion(String sujetQuestion) {
		this.sujetQuestion = sujetQuestion;
	}

	public LocalDate getDateQuestion() {
		return dateQuestion;
	}

	public void setDateQuestion(LocalDate dateQuestion) {
		this.dateQuestion = dateQuestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assembleeGenerale == null) ? 0 : assembleeGenerale.hashCode());
		result = prime * result + ((dateQuestion == null) ? 0 : dateQuestion.hashCode());
		result = prime * result + ((sujetQuestion == null) ? 0 : sujetQuestion.hashCode());
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
		Question other = (Question) obj;
		if (assembleeGenerale == null) {
			if (other.assembleeGenerale != null)
				return false;
		} else if (!assembleeGenerale.equals(other.assembleeGenerale))
			return false;
		if (dateQuestion == null) {
			if (other.dateQuestion != null)
				return false;
		} else if (!dateQuestion.equals(other.dateQuestion))
			return false;
		if (sujetQuestion == null) {
			if (other.sujetQuestion != null)
				return false;
		} else if (!sujetQuestion.equals(other.sujetQuestion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [sujetQuestion=" + sujetQuestion + ", dateQuestion=" + dateQuestion + "]";
	}
	
	

}
