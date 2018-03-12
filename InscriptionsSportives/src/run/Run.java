package run;

import java.io.IOException;

import inscriptions.Inscriptions;
import commandLine.MenuInscription;

public class Run {
	
	public static void main(String[] args)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		
		MenuInscription menuInscriptions = new MenuInscription(inscriptions);
		
		menuInscriptions.start();
		System.out.println("Au revoir !");
		
		
		try
		{
			inscriptions.sauvegarder();
		} 
		catch (IOException e)
		{
			System.out.println("Sauvegarde impossible." + e);
		}
	}

}
