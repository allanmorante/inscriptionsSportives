package interfaceHM;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inscriptions.Inscriptions;

public class Application extends JPanel implements ActionListener{

	
	private static final long serialVersionUID = -1122135859816317095L;
	private JButton competition = new JButton("Compétition");
	private JButton equipe = new JButton("Equipe");
	private JButton personne = new JButton("Personne");
	private JButton quitter = new JButton("Quitter");
	private JFrame frame;	
	private Inscriptions inscriptions;
	
	public Application(JFrame frame, Inscriptions inscriptions) {
		this.frame = frame;
		this.inscriptions = inscriptions;
		initApplication();
	}
	
	public void initApplication() {
		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.setMaximumSize(getMaximumSize());
		buttons.setBackground(Color.white);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		buttons.add(new JLabel("<html><h1><strong><i>Inscription Sportive</i></strong></h1><hr></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		/*****
		 * Ajouter les bouton (compétition, equipe, personne, quitter) à la frame
		 */
		buttons.add(competition, gbc);
		buttons.add(equipe, gbc);
		buttons.add(personne, gbc);
		buttons.add(quitter, gbc);

		
		gbc.weighty = 1;
		add(buttons, gbc);
		
		/*****************
		 * Ajouter des actions suivant le bouton cliquer (Quitter, Compétition, Equipe, Personne
		 */
		
		
		competition.addActionListener(this);
		equipe.addActionListener(this);
		personne.addActionListener(this);
		quitter.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		
		case "Quitter":
			Fenetre.close();
			break;
		/*	
		case "Compétition":
			frame.getContentPane().removeAll();
			frame.setContentPane(new InterfaceCompetition(frame, inscriptions));
			frame.invalidate();
			frame.validate();
			break;*/
			
		case "Equipe":
			frame.getContentPane().removeAll();
			frame.setContentPane(new InterfaceEquipe(frame, inscriptions));
			frame.invalidate();
			frame.validate();
			break;

		case "Personne":
			frame.getContentPane().removeAll();
			frame.setContentPane((new InterfacePersonne(frame, inscriptions)));
			frame.invalidate();
			frame.validate();
			break;
		}
	}
}