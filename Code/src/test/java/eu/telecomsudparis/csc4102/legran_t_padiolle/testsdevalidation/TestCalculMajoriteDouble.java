package eu.telecomsudparis.csc4102.legran_t_padiolle.testsdevalidation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.AssembleeGenerale;
import eu.telecomsudparis.csc4102.legran_t_padiolle.CalculMajoriteDouble;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Coproprietaire;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Evote;
import eu.telecomsudparis.csc4102.legran_t_padiolle.QuestionVotable;
import eu.telecomsudparis.csc4102.legran_t_padiolle.StrategieDeCalculVote;

public class TestCalculMajoriteDouble {
	QuestionVotable questionVotable;
	Copropriete coprop;
	AssembleeGenerale ag;
	Coproprietaire coproprietaire1;
	Coproprietaire coproprietaire2;
	Coproprietaire coproprietaire3;
	Coproprietaire coproprietaire4;
	Coproprietaire coproprietaire5;
	StrategieDeCalculVote strategieDeCalculVote;

	@Before
	public void setUp() throws Exception {
		coprop = new Copropriete("Rue Test");
		ag = new AssembleeGenerale("AG Test", coprop);
		ag.commencerAssembleeGenerale();
		strategieDeCalculVote = new CalculMajoriteDouble();
		questionVotable = new QuestionVotable("Question test", strategieDeCalculVote);

		coproprietaire1 = new Coproprietaire("Wayne", "Bruce");
		coproprietaire1.ajouterCopropriete(coprop, 0.6);
		ag.ajouterCoproprietairePresent(coproprietaire1);
		questionVotable.ajouterVoteCoproprietaire(coproprietaire1, Evote.OUI);

		coproprietaire2 = new Coproprietaire("Gonzales", "Speedy");
		coproprietaire2.ajouterCopropriete(coprop, 0.1);
		ag.ajouterCoproprietairePresent(coproprietaire2);
		questionVotable.ajouterVoteCoproprietaire(coproprietaire2, Evote.OUI);

		coproprietaire3 = new Coproprietaire("Ti", "Ti");
		coproprietaire3.ajouterCopropriete(coprop, 0.1);
		ag.ajouterCoproprietairePresent(coproprietaire3);
		questionVotable.ajouterVoteCoproprietaire(coproprietaire3, Evote.NON);

		coproprietaire4 = new Coproprietaire("To", "To");
		coproprietaire4.ajouterCopropriete(coprop, 0.1);
		ag.ajouterCoproprietairePresent(coproprietaire4);
		questionVotable.ajouterVoteCoproprietaire(coproprietaire4, Evote.ABSTENTION);

		coproprietaire5 = new Coproprietaire("Gros", "Minet");
		coproprietaire5.ajouterCopropriete(coprop, 0.1);
		ag.ajouterCoproprietairePresent(coproprietaire5);
		questionVotable.ajouterVoteCoproprietaire(coproprietaire5, Evote.ABSTENTION);

		questionVotable.calculerIssueVote();
		questionVotable.afficherResultatVote();
	}

	@After
	public void tearDown() throws Exception {
		questionVotable = null;
	}

	@Test
	public void testCtr() {
		Assert.assertEquals(questionVotable.getNombreOui(), 500);
		Assert.assertEquals(questionVotable.getNombreNon(), 100);
		Assert.assertEquals(questionVotable.getNombreAbstention(), 200);
	}

}