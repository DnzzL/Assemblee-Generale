package eu.telecomsudparis.csc4102.legran_t_padiolle.testsunitaires;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.AssembleeGenerale;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Coproprietaire;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.FicheDePresencePhysique;

public class TestCreationFicheDePresencePhysique {
	FicheDePresencePhysique fiche;
	Coproprietaire coproprietaire;
	AssembleeGenerale assembleeGenerale;
	Copropriete copropriete;

	@Before
	public void setUp() throws Exception { 
		copropriete = new Copropriete("Test");
		assembleeGenerale = new AssembleeGenerale("Test", copropriete);
		assembleeGenerale.commencerAssembleeGenerale();
		coproprietaire = new Coproprietaire("Wayne", "Bruce");
		fiche = new FicheDePresencePhysique(coproprietaire);
	}

	@After
	public void tearDown() throws Exception { 
		copropriete = null;
		assembleeGenerale = null;
		coproprietaire = null;
		fiche = null;
	}

	@Test
	public void testCtr() {
		Assert.assertEquals(fiche.getAssembleeGenerale(), assembleeGenerale);
		Assert.assertEquals(fiche.getCoproprietaire(), coproprietaire);
	}

}