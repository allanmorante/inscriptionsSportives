package jUnit;

import static org.junit.Assert.*;

import inscriptions.*;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class TestPersonne {
    
    Inscriptions inscriptions = Inscriptions.getInscriptions();
    Competition flechettes = inscriptions.createCompetition("Mondial de fléchettes", null, false);
    
    Personne tony = inscriptions.createPersonne("Tony", "Dent de plomb", "azerty"), 
            boris = inscriptions.createPersonne("Boris", "le Hachoir", "ytreza");
    
    Equipe lesManouches = inscriptions.createEquipe("Les Manouches");
    Equipe lesPompiers = inscriptions.createEquipe("lesPompiers");

    @Test
    public void testDelete() {
        
        Equipe lesManouches = inscriptions.createEquipe("lesManouches");
        Set<Equipe> e = new TreeSet<Equipe>();
        e.add(lesManouches);
        lesManouches.add(tony);
        lesManouches.add(boris);
        
        boris.delete();
        
        assertEquals(e, tony.getEquipes());
    }

    @Test
    public void testToString() {
        fail("Not yet implemented");
        
    }

    @Test
    public void testPersonne() {
        String prenom = tony.getPrenom();
        String mail = tony.getMail();
        String nom = tony.getNom();
        
        assertEquals(tony.getNom(), nom);
        assertEquals(tony.getPrenom(), prenom);
        assertEquals(tony.getMail(), mail);
    }

    @Test
    public void testGetPrenom() {
        String prenom = tony.getPrenom();
        assertEquals(tony.getPrenom(), prenom);
    }
    @Test
    public void testSetPrenom() {
        String prenom = "toto";
        Personne tony = inscriptions.createPersonne("Tony", prenom, "azerty");
        assertEquals(tony.getPrenom(), prenom);
    }

    @Test
    public void testGetMail() {
        String mail = tony.getMail();
        assertEquals(tony.getMail(), mail);
    }

    @Test
    public void testSetMail() {
        String mail = "test mail";
        Personne tony = inscriptions.createPersonne("Tony", "tony", mail);
        assertEquals(tony.getMail(), "test mail");
        }

    @Test
    public void testGetEquipes() {
        lesManouches.add(tony);
        Set<Equipe> equipe = new TreeSet<Equipe>();
        equipe.add(lesManouches);
        
        assertEquals(tony.getEquipes(), equipe);
    }

    @Test
    public void testAddEquipe() {
        Set<Equipe> equipe = new TreeSet<Equipe>();
        equipe.add(lesManouches);
        equipe.add(lesPompiers);
        
        assertEquals(equipe, inscriptions.getEquipes());
        
    }

    @Test
    public void testRemoveEquipe() {
//        Set<Equipe> equipe = new TreeSet<Equipe>();
//        equipe.add(lesManouches);
//        equipe.add(lesPompiers);
//        
//        equipe.remove(lesPompiers);
//        
//        assertEquals(equipe, inscriptions.getEquipes());
        
        
    }

}
