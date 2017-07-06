package eu.telecomsudparis.csc4102.legran_t_padiolle.testsunitaires;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.AssembleeGenerale;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;

public class TestCommencementAssembleeGenerale {
	AssembleeGenerale ag;
	Copropriete copropriete;
	Syndic syndic;
	
	@Before
	public void setUp() throws Exception { 
		syndic = Syndic.getInstance();
		copropriete = new Copropriete("TEST");
		ag = new AssembleeGenerale("Assemblee n 1", copropriete); 
		ag.commencerAssembleeGenerale();
	}
	
	@After
	public void tearDown() throws Exception { 
		syndic = null;
		copropriete = null;
		ag = null;
	}
	
	@Test
	public void testCtr() {
		Assert.assertTrue(ag.isEnCours());
	}
	
}