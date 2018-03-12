package commandLine;

import java.util.SortedSet;
import inscriptions.*;

import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;
public class MenuInscription {
	
	private static Inscriptions inscriptions;
	
	public MenuInscription(Inscriptions inscriptions)
	{
		MenuInscription.inscriptions = inscriptions;
	}
	
	static Menu getMenu()
	{
		Menu menu = new Menu("Inscription");
		
		menu.add(getPersonnesMenu());
		menu.add(getEquipesMenu());
		menu.add(getCandidatsMenu());
		menu.add(getCompetitionsMenu());
		
		menu.addQuit("q");
		
		return menu;
	}
	
	public void start() {
			
			getMenu().start();
		}
	
	
	/*****GESTION PERSONNES**********/
	
	
	static Menu getPersonnesMenu()
	{
		Menu personnesMenu = new Menu("Gestion Personnes", "d");
		personnesMenu.add(addPersonneOption());
		personnesMenu.add(displayPersonneOption());
		personnesMenu.add(deletePersonneOption());
		personnesMenu.addBack("r");
		personnesMenu.setAutoBack(true);
		return personnesMenu;
	}
	
	static Option addPersonneOption()
	{
		Option addPersonne = new Option("Ajouter une personne", "c", 
				addPersonneAction());
		return addPersonne;
	}
	
	static Action addPersonneAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				String prenom = InOut.getString("Entrer le prenom de la personne : ");
				String nom = InOut.getString("Entrer le nom de la personne : ");
				String mail = InOut.getString("Entrer le mail de la personne : ");
				Personne createPersonne = inscriptions.createPersonne(nom, prenom, mail);
				System.out.println("La personne a été créée avec succés");
				
			}
		};
	}
	
	static Option displayPersonneOption()
	{
		Option displayPersonne = new Option("Afficher les personnes", "v", 
				displayPersonneAction());
		return displayPersonne;
	}
	
	static Action displayPersonneAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				System.out.println(inscriptions.getPersonnes());
				
			}
		};
	}
	
	static Option deletePersonneOption()
	{
		Option deletePersonne = new Option("Supprimer personne", "b", 
				deletePersonneAction());
		return deletePersonne;
	}
	
	static Action deletePersonneAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				String nom = InOut.getString("Veuillez entrer le nom de la personne à supprimer :");
				boolean delete = false;
				
				SortedSet<Personne> listPersonnes = inscriptions.getPersonnes();
				
				for (Personne p : listPersonnes){
					if(nom.compareTo(p.getNom()) == 0){
						p.delete();
						delete = true;
					}
				}
				if(delete)
					System.out.println(nom + "a bien été supprimé");
				else
					System.out.println(nom + "introuvable");
				
			}
		};
	}
	
	/*****END PERSONNES**********/
	
	/******GESTION EQUIPES*************/
	
	static Menu getEquipesMenu()
	{
		Menu equipesMenu = new Menu("Gestion Equipes", "f");
		equipesMenu.add(addEquipeOption());
		equipesMenu.add(displayEquipeOption());
		equipesMenu.add(deleteEquipeOption());
		equipesMenu.add(addPersonneInEquipeOption());
		equipesMenu.add(removePersonneFromEquipeOption());
		equipesMenu.addBack("r");
		equipesMenu.setAutoBack(true);
		return equipesMenu;
	}
	
	static Option addEquipeOption()
	{
		Option addEquipe = new Option("Ajouter une equipe", "c", 
				addEquipeAction());
		return addEquipe;
	}
	
	static Action addEquipeAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				String nomEquipe = InOut.getString("Entrer le nom de l'equipe :");
				Equipe equipe = inscriptions.createEquipe(nomEquipe);
				System.out.println("L'équipe : " + nomEquipe + " a bien été créée");
				
			}
		};
	}
	
	static Option displayEquipeOption()
	{
		Option displayEquipe = new Option("Afficher les équipes", "v", 
				displayEquipeAction());
		return displayEquipe;
	}
	
	static Action displayEquipeAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				System.out.println(inscriptions.getEquipes());
				
			}
		};
	}
	
	static Option deleteEquipeOption()
	{
		Option deleteEquipe = new Option("Supprimer équipe", "b", 
				deleteEquipeAction());
		return deleteEquipe;
	}
	
	static Action deleteEquipeAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				String nomEquipe = InOut.getString("Entrer le nom de l'équipe à supprimer :");
				boolean delete = false;
				
				SortedSet<Equipe> listEquipes = inscriptions.getEquipes();
				
				for (Equipe e : listEquipes){
					if(nomEquipe.compareTo(e.getNom()) == 0){
						e.delete();
						delete = true;
					}
				}
				if(delete){
					System.out.println(nomEquipe + "a bien été supprimé");
				}
				else
					System.out.println(nomEquipe + "introuvable");
				
				
			}
		};
	}
	
	static Option addPersonneInEquipeOption()
	{
		Option addPersonneInEquipe = new Option("Ajouter personne dans équipe", "n", 
				addPersonneInEquipeAction());
		return addPersonneInEquipe;
	}
	
	static Action addPersonneInEquipeAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				String nomEquipe = InOut.getString("Entrer le nom de l'equipe concernée : ");
				String nomPersonne = InOut.getString("Entrer le nom de la personne à inscrire dans l'équipe : ");
				
				boolean equipe = false;
				boolean personne = false;
				
				SortedSet<Personne> listPersonnes = inscriptions.getPersonnes();
				SortedSet<Equipe> listEquipes = inscriptions.getEquipes();
				
				for(Equipe e : listEquipes){
					
					if(nomEquipe.compareTo(e.getNom()) == 0){
						
						equipe = true;
						
						for(Personne p : listPersonnes){
							
							if(nomPersonne.compareTo(p.getNom()) == 0){
								
								e.add(p);
								personne = true;
								
							}
								
						}
					}
				}
				
				if(equipe){
					
					if(personne){
						
						System.out.println(nomPersonne + " a bien été ajouté à l'équipe : " + nomEquipe);
						
					}
					else
						System.out.println(nomPersonne + " introuvable ");
					
				}
				else
					System.out.println(nomEquipe + " introuvable");
			
				
			}
		};
	}
	
	static Option removePersonneFromEquipeOption()
	{
		Option removePersonneFromEquipe = new Option("Supprimer personne d'une équipe", "m", 
				removePersonneFromEquipeAction());
		return removePersonneFromEquipe;
	}
	
	static Action removePersonneFromEquipeAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				
				
				String nomEquipe = InOut.getString("Entrer le nom de l'equipe concernée : ");
				String nomPersonne = InOut.getString("Entrer le nom de la personne à supprimer de l'équipe : ");
				
				boolean equipe = false;
				boolean personne = false;
				
				SortedSet<Equipe> listEquipes = inscriptions.getEquipes();
				
				for(Equipe e : listEquipes){
					
					if(nomEquipe.compareTo(e.getNom()) == 0){
						
						equipe = true;
						
						for(Personne p : e.getMembres()){
							
							if(nomPersonne.compareTo(p.getNom()) == 0){
								
								e.remove(p);
								personne = true;
								
							}
								
						}
					}
				}
				
				if(equipe){
					
					if(personne){
						
						System.out.println(nomPersonne + " a bien été supprimé l'équipe : " + nomEquipe);
						
					}
					else
						System.out.println(nomPersonne + " introuvable ");
					
				}
				else
					System.out.println(nomEquipe + " introuvable");
				
			}
		};
	}
	
	/**********END EQUIPE***********/
	
	
	/*********** GESTION EQUIPE ***************/
	
	static Menu getCandidatsMenu()
	{
		Menu candidatsMenu = new Menu("Gestion Candidats", "g");
		candidatsMenu.add(addCandidatOption());
		candidatsMenu.add(displayCandidatOption());
		candidatsMenu.add(deleteCandidatOption());
		candidatsMenu.addBack("r");
		candidatsMenu.setAutoBack(true);
		return candidatsMenu;
	}
	
	static Option addCandidatOption()
	{
		Option addCandidat = new Option("Ajouter un candidat", "c", 
				addCandidatAction());
		return addCandidat;
	}
	
	static Action addCandidatAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				System.out.println("Candidat ajouté");
				
			}
		};
	}
	
	static Option displayCandidatOption()
	{
		Option displayCandidat = new Option("Afficher les candidats", "v", 
				displayCandidatAction());
		return displayCandidat;
	}
	
	static Action displayCandidatAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				System.out.println(inscriptions.getCandidats());
				
			}
		};
	}
	
	static Option deleteCandidatOption()
	{
		Option deleteCandidat = new Option("Supprimer candidat", "b", 
				deleteCandidatAction());
		return deleteCandidat;
	}
	
	static Action deleteCandidatAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				System.out.println("dsfsvsqvsqv");
				
			}
		};
	}
	
	/*********END CANDIDAT ************/
	
	/******** GESTION COMPETITION *************/
	
	static Menu getCompetitionsMenu()
	{
		Menu competitionsMenu = new Menu("Gestion Compétitions", "h");
		competitionsMenu.add(addCompetitionOption());
		competitionsMenu.add(displayCompetitionOption());
		competitionsMenu.add(deleteCompetitionOption());
		competitionsMenu.add(addCandidatInCompetitionOption());
		competitionsMenu.add(removeCandidatFromCompetitionOption());
		competitionsMenu.addBack("r");
		competitionsMenu.setAutoBack(true);
		return competitionsMenu;
	}
	
	static Option addCompetitionOption()
	{
		Option addCompetition = new Option("Ajouter une compétition", "c", 
				addCompetitionAction());
		return addCompetition;
	}
	
	static Action addCompetitionAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				String x = InOut.getString("Entrer le nom de la compétition : ");
				Competition createdCompet = inscriptions.createCompetition(x, null, false);
				System.out.println("La compétition, " + x + " a été créée avec succés");
				
			}
		};
	}
	
	static Option displayCompetitionOption()
	{
		Option displayCompetition = new Option("Afficher les compétitions", "v", 
				displayCompetitionAction());
		return displayCompetition;
	}
	
	static Action displayCompetitionAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				System.out.println(inscriptions.getCompetitions());
				
			}
		};
	}
	
	static Option deleteCompetitionOption()
	{
		Option deleteCompetition = new Option("Supprimer compétition", "b", 
				deleteCompetitionAction());
		return deleteCompetition;
	}
	
	static Action deleteCompetitionAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				System.out.println("Compétition supprimé");
				
			}
		};
	}
	
	static Option addCandidatInCompetitionOption()
	{
		Option addCandidatInCompetition = new Option("Ajouter un candidat dans une compétition", "n", 
				addCandidatInCompetitionAction());
		return addCandidatInCompetition;
	}
	
	static Action addCandidatInCompetitionAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				System.out.println("Candidat ajouté dans la compétition");
				
			}
		};
	}
	
	static Option removeCandidatFromCompetitionOption()
	{
		Option removeCandidatFromCompetition = new Option("Retirer un candidat d'une compétition", "m", 
				removeCandidatFromCompetitionAction());
		return removeCandidatFromCompetition;
	}
	
	static Action removeCandidatFromCompetitionAction()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	/*******END COMPETITION*********/
	

}
