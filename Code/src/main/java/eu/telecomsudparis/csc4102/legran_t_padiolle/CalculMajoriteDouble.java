package eu.telecomsudparis.csc4102.legran_t_padiolle;

public class CalculMajoriteDouble extends StrategieDeCalculVote {

	private static String str = "Victoire du ";

	public CalculMajoriteDouble() {
	}

	@Override
	public void algorithmeDeCalcul(QuestionVotable questionVotable) {
		int nombreAbstention = questionVotable.getNombreAbstention();
		int nombreOui = questionVotable.getNombreOui();
		int nombreCoproprietaireOui = 0;
		for(int i=0; i<questionVotable.getListeVotes().size(); i++){
			if(questionVotable.getListeVotes().get(i).equals(Evote.OUI)){
				nombreCoproprietaireOui += 1;
			}
		}
		int nombreNon = questionVotable.getNombreNon();
		int totalVoix = nombreAbstention + nombreOui + nombreNon;
		AssembleeGenerale ag = questionVotable.getAssembleeGenerale();
		Copropriete copropriete = ag.getCopropriete();
		int totalCoproprietaires = copropriete.getListeCoproprietaires().size();

		if( (nombreOui > 2*totalVoix/3 + 1) && 
				(nombreCoproprietaireOui > totalCoproprietaires/2) ){
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
