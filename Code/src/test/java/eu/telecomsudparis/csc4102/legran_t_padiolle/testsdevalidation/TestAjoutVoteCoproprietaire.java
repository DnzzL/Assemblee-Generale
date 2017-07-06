package eu.telecomsudparis.csc4102.legran_t_padiolle.testsdevalidation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.AssembleeGenerale;
import eu.telecomsudparis.csc4102.legran_t_padiolle.CalculMajoriteSimple;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Coproprietaire;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.EStatut;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Evote;
import eu.telecomsudparis.csc4102.legran_t_padiolle.QuestionVotable;
import eu.telecomsudparis.csc4102.legran_t_padiolle.StrategieDeCalculVote;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;

public class TestAjoutVoteCoproprietaire {
	Syndic syndic = Syndic.getInstance();
	Copropriete copropriete;
	AssembleeGenerale ag;
	QuestionVotable questionVotable;
	StrategieDeCalculVote strategieDeCalculVote;
	Coproprietaire coproprietaire;

	@Before
	public void setUp() throws Exception { 
		/**
		 * Précondition 1
		 */
		Assert.assertEquals(syndic.getListeCoproprietes().size(), 0);

		/**
		 * Précondition 2
		 */
		copropriete = new Copropriete("Copropriete test");
		Assert.assertEquals(syndic.getListeCoproprietes().size(), 1);

		/**
		 * Précondition 3
		 */
		ag = new AssembleeGenerale("Ag Test", copropriete);
		Assert.assertEquals(ag.getNomAssembleeGenerale(), "Ag Test");

		/**
		 * Précondition 4
		 */
		ag.commencerAssembleeGenerale();
		Assert.assertEquals(ag.getStatut(), EStatut.EN_COURS);

		/**
		 * Précondition 5
		 */
		strategieDeCalculVote = new CalculMajoriteSimple();
		questionVotable = new QuestionVotable("Test", strategieDeCalculVote);
		Assert.assertEquals(questionVotable.getSujetQuestion(), "Test");

		/**
		 * Précondition 6
		 */
		coproprietaire = new Coproprietaire("Wayne", "Bruce");
		Assert.assertEquals(coproprietaire.getNom(), "Wayne");
		Assert.assertEquals(coproprietaire.getPrenom(), "Bruce");

		/**
		 * Précondition 7
		 */
		ag.ajouterCoproprietairePresent(coproprietaire);
		Assert.assertEquals(ag.getFichesPresencePhysique().size(), 1);

		/**
		 * Précondition 8 et 9 (testés lors de la création)
		 */
		questionVotable.ajouterVoteCoproprietaire(coproprietaire, Evote.OUI);
	}

	@After
	public void tearDown() throws Exception { 
		syndic = null;
		copropriete = null;
		ag = null;
		questionVotable = null;
		strategieDeCalculVote = null;
		coproprietaire = null;
	}

	@Test
	public void testCtr() {
		Assert.assertTrue(ag.getListeQuestionsVotables().contains(questionVotable));
		Assert.assertTrue(ag.getListeQuestions().contains(questionVotable));
		Assert.assertEquals(questionVotable.getListeVotes().get(0).getContenuVote(), Evote.OUI);
		Assert.assertEquals(questionVotable.getListeVotes().get(0).getCoproprietaire(), coproprietaire);
	}

}

