package eu.telecomsudparis.csc4102.legran_t_padiolle.testsdevalidation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.AssembleeGenerale;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.EStatut;
import eu.telecomsudparis.csc4102.legran_t_padiolle.QuestionNonVotable;
import eu.telecomsudparis.csc4102.legran_t_padiolle.StrategieDeCalculVote;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;
import eu.telecomsudparis.csc4102.util.Datutil;

public class TestAjoutQuestionNonVotable {
	Syndic syndic = Syndic.getInstance();
	Copropriete copropriete;
	AssembleeGenerale assembleeGenerale;
	QuestionNonVotable question;
	StrategieDeCalculVote strategieDeCalculVote;
	
	@Before
	public void setUp() throws Exception { 
		/**
		 * Précondition 1
		 */
		Assert.assertEquals(syndic.getListeCoproprietes().size(), 0);
		
		/**
		 * Précondition 2
		 */
		copropriete = new Copropriete("Rue Test");
		Assert.assertEquals(syndic.getListeCoproprietes().size(), 1);
		Assert.assertEquals(syndic.getListeAGs().size(), 0);
		
		/**
		 * Précondition 3
		 */
		assembleeGenerale = new AssembleeGenerale("Ag Test", copropriete);
		Assert.assertEquals(syndic.getListeAGs().size(), 1);
		
		/**
		 * Précondition 4
		 */
		Assert.assertFalse(syndic.getListeAGs().get(0).getStatut().equals(EStatut.TERMINEE));
		Assert.assertEquals(assembleeGenerale.getListeQuestions().size(), 0);
		
		/**
		 * Précondition 5
		 */
		assembleeGenerale.ajouterQuestionNonVotable("Question test");
	}
	
	@After
	public void tearDown() throws Exception { 
		syndic = null;
		copropriete = null;
		assembleeGenerale = null;
		question = null;
		strategieDeCalculVote = null;
	}
	
	@Test
	public void testCtr() {
		Assert.assertEquals(assembleeGenerale.getListeQuestions().size(), 1);
		Assert.assertEquals(assembleeGenerale.getListeQuestions().get(0).getSujetQuestion(), "Question test");
		Assert.assertEquals(assembleeGenerale.getListeQuestions().get(0).getDateQuestion(), Datutil.aujourdhui());
	}
	
}
