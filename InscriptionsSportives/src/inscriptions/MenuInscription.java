package inscriptions;

import commandLineMenus.*;
public class MenuInscription {
	
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
				System.out.println("Personne ajouté");
				
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
				System.out.println("Personnes affiché");
				
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
				System.out.println("Personne supprimé");
				
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
				System.out.println("Equipe ajouté");
				
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
				System.out.println("Equipe affiché");
				
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
				System.out.println("Equipe supprimé");
				
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
				System.out.println("Personne ajouté dans l'équipe");
				
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
				// TODO Auto-generated method stub
				System.out.println("Candidat affiché");
				
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
				System.out.println("Candidat supprimé");
				
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
				System.out.println("Compétition ajouté");
				
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
				System.out.println("Compétitions affiché");
				
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
	
	/*******END COMPETITION*********/
	
	public static void main(String[] args) {
		
		Menu menu = getMenu();
		menu.start();
		System.out.println("Au revoir !");
	}

}
