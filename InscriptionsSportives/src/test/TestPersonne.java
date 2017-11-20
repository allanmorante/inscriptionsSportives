package test;

import static org.junit.Assert.*;

import org.junit.Test;

import inscriptions.Competition;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestPersonne {

	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Competition flechettes = inscriptions.createCompetition("Mondial de fléchettes", null, false);
	Personne tony = inscriptions.createPersonne("Tony", "Dent de plomb", "azerty"), 
			boris = inscriptions.createPersonne("Boris", "le Hachoir", "ytreza");
	
	
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrenom() {
		String prenom = tony.getPrenom();
		assertEquals(prenom, "Dent de plomb");
	}

	@Test
	public void testSetPrenom() {
		String prenom = "toto";
		Personne tony = inscriptions.createPersonne("Tony", prenom, "azerty");
		assertEquals(tony.getPrenom(), prenom);
	}

	@Test
	public void testGetMail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEquipes() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEquipe() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveEquipe() {
		fail("Not yet implemented");
	}

}
