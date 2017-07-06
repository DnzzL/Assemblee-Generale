package eu.telecomsudparis.csc4102.legran_t_padiolle.testsunitaires;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.Coproprietaire;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;

public class TestCreationCoproprietaire {
	Syndic syndic;
	Coproprietaire coproprietaire;
	
	@Before
	public void setUp() throws Exception { 
		syndic = Syndic.getInstance();
		coproprietaire = new Coproprietaire("Wayne", "Bruce"); 
	}
	
	@After
	public void tearDown() throws Exception { 
		coproprietaire = null;
	}
	
	@Test
	public void testCtr() {
		Assert.assertEquals(coproprietaire.getNom(), "Wayne");
		Assert.assertEquals(coproprietaire.getPrenom(), "Bruce");
		Assert.assertTrue(syndic.getListeCoproprietaires().contains(coproprietaire));
	}
	
}

