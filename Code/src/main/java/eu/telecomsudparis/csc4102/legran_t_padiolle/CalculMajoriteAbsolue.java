package eu.telecomsudparis.csc4102.legran_t_padiolle;

public class CalculMajoriteAbsolue extends StrategieDeCalculVote {

	private static String str = "Victoire du ";
	
	public CalculMajoriteAbsolue() {
	}

	@Override
	public void algorithmeDeCalcul(QuestionVotable questionVotable) {
		int nombreAbstention = questionVotable.getNombreAbstention();
		int nombreOui = questionVotable.getNombreOui();
		int nombreNon = questionVotable.getNombreNon();
		int totalVoix = nombreAbstention + nombreOui + nombreNon;

		if( (nombreOui > nombreNon) && (nombreOui > totalVoix/2 + 1) ){
			str += Evote.OUI;
			questionVotable.setResultatVote(Evote.OUI);
			System.out.println(str);
		} else {
			str += Evote.NON;
			questionVotable.setResultatVote(Evote.NON);
			System.out.println(str);
		}
	}
}
