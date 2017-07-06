package eu.telecomsudparis.csc4102.legran_t_padiolle.testsunitaires;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.legran_t_padiolle.Coproprietaire;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Copropriete;
import eu.telecomsudparis.csc4102.legran_t_padiolle.Syndic;

public class TestAjoutCoproprietaireACopropriete {
	Syndic syndic;
	Copropriete coprop;
	Coproprietaire coproprietaire;
	
	@Before
	public void setUp() throws Exception { 
		syndic = Syndic.getInstance();
		coprop = new Copropriete("5 rue Charles Fourier EVRY"); 
		coproprietaire = new Coproprietaire("Bruce", "Wayne");
		coprop.ajouterCoproprietaire(coproprietaire);
	}
	
	@After
	public void tearDown() throws Exception { 
		coprop = null;
	}
	
	@Test
	public void testCtr() {
		Assert.assertTrue(coprop.getListeCoproprietaires().contains(coproprietaire));
	}
	
}

