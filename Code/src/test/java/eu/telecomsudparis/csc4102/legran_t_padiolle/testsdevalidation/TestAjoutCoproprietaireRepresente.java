package eu.telecomsudparis.csc4102.legran_t_padiolle.testsdevalidation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.AssembleeGenerale;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Coproprietaire;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.EStatut;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;

public class TestAjoutCoproprietaireRepresente {
	Syndic syndic = Syndic.getInstance();
	Coproprietaire coproprietaire;
	Coproprietaire mandataire;
	AssembleeGenerale assembleeGenerale;
	Copropriete copropriete;

	@Before
	public void setUp() throws Exception { 
		/**
		 * Précondition 1
		 */
		Assert.assertEquals(syndic.getListeCoproprietes().size(), 0);

		/**
		 * Précondition 2
		 */
		copropriete = new Copropriete("Test");
		Assert.assertEquals(syndic.getListeCoproprietes().size(), 1);
		Assert.assertEquals(syndic.getListeAGs().size(), 0);

		/**
		 * Précondition 3
		 */
		assembleeGenerale = new AssembleeGenerale("Test", copropriete);
		Assert.assertEquals(syndic.getListeAGs().size(), 1);

		/**
		 * Précondition 4
		 */
		Assert.assertFalse(assembleeGenerale.getStatut()==EStatut.TERMINEE);

		/**
		 * Précondition 5
		 */
		coproprietaire = new Coproprietaire("Wayne", "Bruce");
		Assert.assertTrue(coproprietaire instanceof Coproprietaire);
		Assert.assertEquals(assembleeGenerale.getFichesPresencePhysique().size(), 0);

		/**
		 * Précondition 6
		 */
		assembleeGenerale.ajouterCoproprietairePresent(coproprietaire);
		Assert.assertEquals(assembleeGenerale.getFichesPresencePhysique().size(), 1);

		/**
		 * Précondition 7
		 */
		mandataire = new Coproprietaire("Kent", "Clark");
		Assert.assertTrue(mandataire instanceof Coproprietaire);
		Assert.assertEquals(assembleeGenerale.getFichesPresencePhysique().size(), 1);

		/**
		 * Précondition 8
		 */
		assembleeGenerale.ajouterCoproprietairePresent(mandataire);
		Assert.assertEquals(assembleeGenerale.getFichesPresencePhysique().size(), 2);

		/**
		 * Précondition 9 (testé lors de la création
		 */
		Assert.assertEquals(assembleeGenerale.getFichesReprensentation().size(), 0);
		assembleeGenerale.ajouterCoproprietaireRepresentation(coproprietaire, mandataire);
	}

	@After
	public void tearDown() throws Exception { 
		syndic = Syndic.getInstance();
		coproprietaire = null;
		mandataire = null;
		assembleeGenerale = null;
		copropriete = null;
	}

	@Test
	public void testCtr() {
		Assert.assertEquals(assembleeGenerale.getFichesReprensentation().size(), 1);
	}

}