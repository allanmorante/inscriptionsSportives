package inscriptions;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.SortNatural;

import hibernate.Passerelle;

/**
 * Représente une Equipe. C'est-à-dire un ensemble de personnes pouvant 
 * s'inscrire à une compétition.
 * 
 */
@Entity
@Table(name="equipe")
public class Equipe extends Candidat
{
	private static final long serialVersionUID = 4147819927233466035L;
	
	@ManyToMany
	@Cascade(value = { CascadeType.ALL })
	@SortNatural
	private SortedSet<Personne> membres = new TreeSet<>();
	
	
	Equipe(Inscriptions inscriptions, String nom)
	{
		super(inscriptions, nom);
		Passerelle.save(this);
	}
	

	/**
	 * Retourne l'ensemble des personnes formant l'équipe.
	 */
	
	public SortedSet<Personne> getMembres()
	{
		return Collections.unmodifiableSortedSet(membres);
	}
	
	/**
	 * Ajoute une personne dans l'équipe.
	 * @param membre
	 * @return
	 */

	public boolean add(Personne membre)
	{
		membre.add(this);
		membres.add(membre);
		Passerelle.save(this);
		return membres.add(membre);
	}

	/**
	 * Supprime une personne de l'équipe. 
	 * @param membre
	 * @return
	 */
	
	public boolean remove(Personne membre)
	{
		membre.remove(this);
		getMembres().remove(membre);
		Passerelle.delete(membre);
		return getMembres().remove(membre);
	}

	@Override
	public void delete()
	{
		super.delete();
	}
	
	@Override
	public String toString()
	{
		return "Equipe " + getNom();
	}
}
