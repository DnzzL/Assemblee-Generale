package eu.telecomsudparis.csc4102.legran_t_padiolle.testsunitaires;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.AssembleeGenerale;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Coproprietaire;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.FicheDePresencePhysique;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;

public class TestAjoutCoproprietairePresentAssembleeGenerale {
	AssembleeGenerale ag;
	Copropriete copropriete;
	Syndic syndic;
	Coproprietaire coproprietaire;
	FicheDePresencePhysique ficheDePresencePhysique;
	
	@Before
	public void setUp() throws Exception { 
		syndic = Syndic.getInstance();
		copropriete = new Copropriete("TEST");
		ag = new AssembleeGenerale("Assemblee n 1", copropriete); 
		coproprietaire = new Coproprietaire("Bruce", "Wayne");
		ag.ajouterCoproprietairePresent(coproprietaire);
	}
	
	@After
	public void tearDown() throws Exception { 
		ficheDePresencePhysique = null;
		coproprietaire = null;
		syndic = null;
		copropriete = null;
		ag = null;
	}
	
	@Test
	public void testCtr() {
		Assert.assertEquals(ag.getFeuilleDePresence().size(), 1);
		Assert.assertEquals(ag.getFichesPresencePhysique().size(), 1);
	}
	
}