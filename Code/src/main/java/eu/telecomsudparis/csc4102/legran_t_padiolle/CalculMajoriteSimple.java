package eu.telecomsudparis.csc4102.legran_t_padiolle;

public class CalculMajoriteSimple extends StrategieDeCalculVote {
	
	private static String str = "Victoire du ";

	public CalculMajoriteSimple() {
	}

	public void algorithmeDeCalcul(QuestionVotable questionVotable) {
		int nombreOui = questionVotable.getNombreOui();
		int nombreNon = questionVotable.getNombreNon();

		if(nombreOui > nombreNon){
			str += Evote.OUI;
			questionVotable.setResultatVote(Evote.OUI);
			System.out.println(str);
		} else if(nombreOui < nombreNon){
			str += Evote.NON;
			questionVotable.setResultatVote(Evote.NON);
			System.out.println(str);
		} else {
			System.out.println("Egalité, il faut revoter");
		}
	}
}
