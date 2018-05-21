package interfaceHM;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hibernate.Passerelle;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class InterfaceEquipe extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5872165336222098445L;
	private JButton createEquipeInterfaceButton = new JButton("Créer une équipe");
	private JButton listEquipeInterfaceButton = new JButton("Lister les équipes");
	private JButton selectEquipeInterfaceButton = new JButton("Selectionner une équipe");
	private JButton retour = new JButton("Retour");
	private JButton selectEquipeButton = new JButton("Valider");
	private JButton createEquipeButton = new JButton("Créer");
	private JButton editEquipeInterfaceButton = new JButton("Editer l'équipe");
	private JButton deleteEquipeButton = new JButton("Supprimer");
	private JButton listPersonneEquipeButton = new JButton("Lister les membres de l'équipe");
	private JButton editEquipeButton = new JButton("Editer");
	private JButton addPersonneEquipeButton = new JButton("Ajouter un sportif à l'équipe");
	private JButton addPersonneButton = new JButton("Ajouter");
	private JLabel nameLabel= new JLabel("Nom : ");
	private JTextField nameField = new JTextField();
	private JFrame frame;
	private Inscriptions inscriptions;
	private Equipe equipe;
	JComboBox<Equipe> list = new JComboBox<Equipe>();
	JComboBox<Personne> listPersonne = new JComboBox<Personne>();

	public InterfaceEquipe(JFrame frame, Inscriptions inscriptions) {
		this.frame = frame;
		this.inscriptions = inscriptions;
		initInterfaceEquipe();;
	}

	public void initInterfaceEquipe() {

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;

		add(new JLabel("<html><h1><strong><i>Inscription Sportive</i></strong></h1><hr></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.add(createEquipeInterfaceButton, gbc);
		buttons.add(listEquipeInterfaceButton, gbc);
		buttons.add(selectEquipeInterfaceButton, gbc);
		buttons.add(retour, gbc);

		gbc.weighty = 1;
		add(buttons, gbc);
		createEquipeInterfaceButton.addActionListener(this);
		listEquipeInterfaceButton.addActionListener(this);
		selectEquipeInterfaceButton.addActionListener(this);
		retour.addActionListener(this);
	}

	public JPanel createEquipeInterface() {
		JPanel createEquipe = new JPanel();
		nameLabel.setPreferredSize( new Dimension( 400, 24 ) );
		nameField.setPreferredSize( new Dimension( 400, 24 ) );
		
		
		createEquipe.setBorder(BorderFactory.createTitledBorder("Création du sportif"));
		createEquipe.add(nameLabel);
		createEquipe.add(nameField);

		createEquipe.add(retour);
		createEquipe.add(createEquipeButton);

		createEquipeButton.addActionListener(this);
		
		return createEquipe;

	}
	
	public JPanel listEquipesInterface() {
		JPanel listEquipes = new JPanel();
		ArrayList<Equipe> lesEquipes = new ArrayList<Equipe>();
		lesEquipes = (ArrayList) Passerelle.getData("Equipe");
		
		listEquipes.setLayout(new FlowLayout());
		listEquipes.add(new JLabel("Liste des equipes : "));
		
		for(Equipe e : lesEquipes) {
			listEquipes.add(new JLabel(e.toString()));
		}
		listEquipes.add(retour);

		return listEquipes;
	}
	
	public JPanel selectEquipeInterface() {
		JPanel selectEquipe = new JPanel();
		ArrayList<Equipe> lesEquipes = new ArrayList<Equipe>();
		lesEquipes = (ArrayList) Passerelle.getData("Equipe");

        for(Equipe e : lesEquipes) {
			list.addItem(e);
		}
        selectEquipe.add(new JLabel("Selectionner un sportif : "));
		selectEquipe.add(list);
		selectEquipe.add(retour);
		selectEquipe.add(selectEquipeButton);
		
		selectEquipeButton.addActionListener(this);
		return selectEquipe;
	}
	
	public JPanel selectedEquipeInterface(Equipe equipe) {
		JPanel selectedEquipeInterface = new JPanel(new GridBagLayout());
		this.equipe = equipe;
		selectedEquipeInterface.setBorder(new EmptyBorder(10, 10, 10, 10));
		selectedEquipeInterface.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		selectedEquipeInterface.add(new JLabel("<html><h1><strong><i>Inscription Sportive</i></strong></h1><hr></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		selectedEquipeInterface.add(editEquipeInterfaceButton, gbc);
		selectedEquipeInterface.add(deleteEquipeButton, gbc);
		selectedEquipeInterface.add(retour, gbc);
		selectedEquipeInterface.add(listEquipeInterfaceButton, gbc);
		selectedEquipeInterface.add(addPersonneEquipeButton, gbc);

		gbc.weighty = 1;
		add(selectedEquipeInterface, gbc);
		editEquipeInterfaceButton.addActionListener(this);
		deleteEquipeButton.addActionListener(this);
		retour.addActionListener(this);
		listPersonneEquipeButton.addActionListener(this);
		addPersonneEquipeButton.addActionListener(this);
		
		return selectedEquipeInterface;
	}
	
	public JPanel editTeam(Equipe equipe) {
		JPanel editTeam = new JPanel();
		this.equipe = equipe;
		
		nameLabel.setPreferredSize( new Dimension( 400, 24 ) );
		nameField.setPreferredSize( new Dimension( 400, 24 ) );
		nameField.setText(equipe.getNom());

		editTeam.setBorder(BorderFactory.createTitledBorder("Edition du sportif"));
		editTeam.add(nameLabel);
		editTeam.add(nameField);

		editTeam.add(retour);
		editTeam.add(editEquipeButton);

		editEquipeButton.addActionListener(this);
		
		return editTeam;
	}
	
	public JPanel listMemberTeam(Equipe equipe) {
		JPanel listMemberTeam = new JPanel();
		this.equipe = equipe;
		
		DefaultListModel list = new DefaultListModel();
		JList fullList = new JList(list);
		ArrayList<Equipe> teams = new ArrayList<Equipe>();
		teams = (ArrayList) Passerelle.getData("Equipe");
		for(Equipe e : teams) {
			list.addElement(e.getMembres());
		}
		listMemberTeam.setLayout(new FlowLayout());
		listMemberTeam.add(new JLabel("Liste des sportifs : "));
		listMemberTeam.add(fullList);
		listMemberTeam.add(retour);

		
		return listMemberTeam;
	}
	
	public JPanel addPersonneEquipe(Equipe equipe) {
		JPanel addPersonneEquipe = new JPanel();
		this.equipe = equipe;
		ArrayList<Personne> lesPersonnes = new ArrayList<Personne>();
		lesPersonnes = (ArrayList) Passerelle.getData("Personne");

        for(Personne p : lesPersonnes) {
			listPersonne.addItem(p);
		}
        addPersonneEquipe.add(new JLabel("Selectionner une personne : "));
        addPersonneEquipe.add(listPersonne);
        addPersonneEquipe.add(retour);
        addPersonneEquipe.add(addPersonneButton);
		
        addPersonneButton.addActionListener(this);
		
		return addPersonneEquipe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == retour) {
			frame.getContentPane().removeAll();
			frame.setContentPane(new Application(frame, inscriptions));
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == createEquipeInterfaceButton) {
			System.out.println(((JButton) e.getSource()).getText());
			frame.getContentPane().removeAll();
			frame.setContentPane(createEquipeInterface());
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == createEquipeButton) {
			System.out.println(((JButton) e.getSource()).getText());
			System.out.println(nameField.getText());
			inscriptions.createEquipe(nameField.getText());
			frame.getContentPane().removeAll();
			frame.setContentPane(new InterfaceEquipe(frame, inscriptions));
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == listEquipeInterfaceButton) {
			System.out.println(((JButton) e.getSource()).getText());
			frame.getContentPane().removeAll();
			frame.setContentPane(listEquipesInterface());
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == selectEquipeInterfaceButton) {
			System.out.println(((JButton) e.getSource()).getText());
			frame.getContentPane().removeAll();
			frame.setContentPane(selectEquipeInterface());
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == selectEquipeButton) {
			System.out.println(((JButton) e.getSource()).getText() + " Sportif : " + list.getSelectedItem());
			frame.getContentPane().removeAll();
			frame.setContentPane(selectedEquipeInterface((Equipe) list.getSelectedItem()));
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == editEquipeInterfaceButton) {
			System.out.println(((JButton) e.getSource()).getText());
			frame.getContentPane().removeAll();
			frame.setContentPane(editTeam((Equipe) list.getSelectedItem()));
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == deleteEquipeButton) {
			System.out.println(((JButton) e.getSource()).getText());
			equipe.delete();
			frame.getContentPane().removeAll();
			frame.setContentPane(selectedEquipeInterface((Equipe) list.getSelectedItem()));
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == editEquipeButton) {
			System.out.println(((JButton) e.getSource()).getText());
			equipe.setNom(nameField.getText());			
			frame.getContentPane().removeAll();
			frame.setContentPane(selectedEquipeInterface((Equipe) list.getSelectedItem()));
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == listPersonneEquipeButton) {
			System.out.println(((JButton) e.getSource()).getText());			
			frame.getContentPane().removeAll();
			frame.setContentPane(listMemberTeam((Equipe) list.getSelectedItem()));
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == addPersonneEquipeButton) {
			System.out.println(((JButton) e.getSource()).getText());
			frame.getContentPane().removeAll();
			frame.setContentPane(addPersonneEquipe((Equipe) list.getSelectedItem()));
			frame.invalidate();
			frame.validate();
		}
		else if(e.getSource() == addPersonneButton) {
			System.out.println(((JButton) e.getSource()).getText());			
			equipe.add(((Personne) listPersonne.getSelectedItem()));
			frame.getContentPane().removeAll();
			frame.setContentPane(selectedEquipeInterface((Equipe) list.getSelectedItem()));
			frame.invalidate();
			frame.validate();
		}
	}
}
