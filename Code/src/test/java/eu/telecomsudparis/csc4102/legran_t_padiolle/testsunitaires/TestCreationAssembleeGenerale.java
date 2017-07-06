package eu.telecomsudparis.csc4102.legran_t_padiolle.testsunitaires;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.AssembleeGenerale;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.EStatut;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;
import eu.telecomsudparis.csc4102.util.Datutil;

public class TestCreationAssembleeGenerale {
	AssembleeGenerale ag;
	Copropriete copropriete;
	Syndic syndic;
	
	@Before
	public void setUp() throws Exception { 
		syndic = Syndic.getInstance();
		copropriete = new Copropriete("TEST");
		ag = new AssembleeGenerale("Assemblee n 1", copropriete);
	}
	
	@After
	public void tearDown() throws Exception { 
		copropriete = null;
		ag = null;
	}
	
	@Test
	public void testCtr() {
		Assert.assertEquals(ag.getNomAssembleeGenerale(),"Assemblee n 1");
		Assert.assertEquals(ag.getDateAssembleeGenerale(), Datutil.aujourdhui());
		Assert.assertEquals(ag.getStatut(), EStatut.NON_DEBUTEE);
	}
	
}