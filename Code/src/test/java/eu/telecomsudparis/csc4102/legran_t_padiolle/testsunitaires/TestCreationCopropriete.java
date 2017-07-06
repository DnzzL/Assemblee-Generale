package eu.telecomsudparis.csc4102.legran_t_padiolle.testsunitaires;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;

public class TestCreationCopropriete {
	Syndic syndic;
	Copropriete coprop;
	
	@Before
	public void setUp() throws Exception { 
		syndic = Syndic.getInstance();
		coprop = new Copropriete("5 rue Charles Fourier EVRY"); 
	}
	
	@After
	public void tearDown() throws Exception { 
		coprop = null;
	}
	
	@Test
	public void testCtr() {
		Assert.assertEquals(coprop.getListeAssembleesGenerales().size(),0);
		Assert.assertEquals(coprop.getAdresseCopropriete(),"5 rue Charles Fourier EVRY");
		Assert.assertEquals(coprop.getListeCoproprietaires().size(),0);
		Assert.assertTrue(syndic.getListeCoproprietes().contains(coprop));
	}
	
}

