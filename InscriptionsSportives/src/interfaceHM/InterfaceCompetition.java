package interfaceHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import hibernate.Passerelle;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class InterfaceCompetition extends JPanel implements ActionListener {
	
	private JButton createCompetition = new JButton("Cr�er une comp�tition");
	private JButton listCompetition = new JButton("Lister les comp�titions");
	private JButton selectCompetition = new JButton("Selectionner une comp�tition");
	private JButton addCandidatCompetition = new JButton("Ajouter des candidats � la comp�tition");
	private JButton detailsCompet = new JButton("Informations d�taill�es sur la comp�tition");
	private JButton retour = new JButton("Retour");
	private JButton createdCompetition = new JButton("Cr�er");
	private JButton selectedCompetition = new JButton("Valider");
	private JButton editCompetition = new JButton("Editer la comp�tition");
	private JButton deleteCompetition = new JButton("Supprimer");
	private JButton editedCompetition = new JButton("Editer");
	private JButton added = new JButton("Ajouter");
	private JLabel nameLabel = new JLabel("Nom : ");
	private JLabel typeLabel = new JLabel("Type : ");
	private JLabel dateLabel = new JLabel("Date de cl�ture : ");
	private JTextField nameField = new JTextField();
	private JComboBox list = new JComboBox();
	private JComboBox listTeams = new JComboBox();
	private JComboBox listGuys = new JComboBox();
	String[] type = { "en �quipe", "individuel"};
	private JComboBox listType = new JComboBox(type);
	private JFrame frame;
	private JDatePickerImpl datePicker;
	private boolean enEquipe;
	private Inscriptions inscriptions;
	private Competition competition;
			
	public InterfaceCompetition(JFrame frame, Inscriptions inscriptions) {
		this.frame = frame;
		this.inscriptions = inscriptions;
		initCompetitionIhm();
	}
	
	public void initCompetitionIhm() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		add(new JLabel("<html><h1><strong><i>Inscription Sportive</i></strong></h1><hr></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.add(createCompetition, gbc);
		buttons.add(listCompetition, gbc);
		buttons.add(selectCompetition, gbc);
		buttons.add(retour, gbc);

		gbc.weighty = 1;
		add(buttons, gbc);
		createCompetition.addActionListener(this);
		listCompetition.addActionListener(this);
		selectCompetition.addActionListener(this);
		retour.addActionListener(this);
	}

	public JPanel createCompetitionIhm() {
		JPanel createCompetition = new JPanel();
		createCompetition.setLayout(new BorderLayout());
		JPanel button = new JPanel();
		JPanel border = new JPanel();
		nameLabel.setPreferredSize( new Dimension( 400, 24 ) );
		nameField.setPreferredSize( new Dimension( 200, 24 ) );
		dateLabel.setPreferredSize( new Dimension( 400, 24 ) );
		typeLabel.setPreferredSize( new Dimension( 400, 24 ) );
		listType.setPreferredSize( new Dimension( 200, 24 ) );
		((JLabel)listType.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Aujourd'hui");
		p.put("text.month", "Mois");
		p.put("text.year", "Ann�e");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		border.setBorder(BorderFactory.createTitledBorder("Cr�ation de la comp�tition"));
		border.add(nameLabel);
		border.add(nameField);
		border.add(dateLabel);
		border.add(datePicker);
		border.add(typeLabel);
		border.add(listType);
		button.add(retour);
		button.add(createdCompetition);
		this.datePicker = datePicker;
		
		createCompetition.add(border, BorderLayout.CENTER);
		createCompetition.add(button, BorderLayout.SOUTH);
		createdCompetition.addActionListener(this);
		
		return createCompetition;

	}
	
	public JPanel listCompetitionsIhm() {
		JPanel listCompetitions = new JPanel();
		DefaultListModel list = new DefaultListModel();
		JList fullList = new JList(list);
		ArrayList<Competition> competitions = new ArrayList<Competition>();
		competitions = (ArrayList) Passerelle.getData("Competition");
		for(Competition c : competitions) {
			list.addElement(c);
		}
		listCompetitions.setLayout(new FlowLayout());
		listCompetitions.add(new JLabel("Liste des comp�titions : "));
		listCompetitions.add(fullList);
		listCompetitions.add(retour);

		return listCompetitions;
	}
	
	public JPanel selectCompetitionIhm() {
		JPanel selectCompetition = new JPanel();
		ArrayList<Competition> competitions = new ArrayList<Competition>();
		competitions = (ArrayList) Passerelle.getData("Competition");

        for(Competition c : competitions) {
			list.addItem(c);
		}
        selectCompetition.add(new JLabel("Selectionner un sportif : "));
		selectCompetition.add(list);
		selectCompetition.add(retour);
		selectCompetition.add(selectedCompetition);
		
		selectedCompetition.addActionListener(this);
		return selectCompetition;
	}
	
	public JPanel selectedCompetitionIhm(Competition competition) {
		JPanel selectedCompetition = new JPanel(new GridBagLayout());
		this.competition = competition;
		selectedCompetition.setBorder(new EmptyBorder(10, 10, 10, 10));
		selectedCompetition.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		selectedCompetition.add(new JLabel("<html><h1><strong><i>Inscription Sportive</i></strong></h1><hr></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		selectedCompetition.add(editCompetition, gbc);
		selectedCompetition.add(deleteCompetition, gbc);
		selectedCompetition.add(retour, gbc);
		selectedCompetition.add(detailsCompet, gbc);
		selectedCompetition.add(addCandidatCompetition, gbc);

		gbc.weighty = 1;
		add(selectedCompetition, gbc);
		editCompetition.addActionListener(this);
		deleteCompetition.addActionListener(this);
		retour.addActionListener(this);
		detailsCompet.addActionListener(this);
		addCandidatCompetition.addActionListener(this);
		
		return selectedCompetition;
	}
	
	public JPanel editCompetition(Competition competition) {
		JPanel editCompetition = new JPanel();
		editCompetition.setLayout(new BorderLayout());
		JPanel button = new JPanel();
		JPanel border = new JPanel();
		this.competition = competition;
		
		nameLabel.setPreferredSize( new Dimension( 400, 24 ) );
		nameField.setPreferredSize( new Dimension( 200, 24 ) );
		dateLabel.setPreferredSize( new Dimension( 400, 24 ) );
		nameField.setText(competition.getNom());

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Aujourd'hui");
		p.put("text.month", "Mois");
		p.put("text.year", "Ann�e");
		model.setValue(competition.getDateCloture());
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		border.setBorder(BorderFactory.createTitledBorder("Edition de la comp�tition : " + competition.getNom()));
		border.add(nameLabel);
		border.add(nameField);
		border.add(dateLabel);
		border.add(datePicker);
		button.add(retour);
		button.add(editedCompetition);
		this.datePicker = datePicker;

		editCompetition.add(button, BorderLayout.SOUTH);
		editCompetition.add(border, BorderLayout.CENTER);
		
		editedCompetition.addActionListener(this);
		
		return editCompetition;
	}
	
	public JPanel detailsCompetIhm(Competition competition) {
		JPanel detailsCompet = new JPanel();
		this.competition = competition;
		
		DefaultListModel list = new DefaultListModel();
		JList fullList = new JList(list);
		list.addElement("Nom : " + competition.getNom());
		list.addElement("Date de cl�ture : " + competition.getDateCloture());
		if(competition.estEnEquipe()) 
			list.addElement("Type : en �quipe");
		else
			list.addElement("Type : individuel");
		list.addElement("Equipe inscrites : " + competition.getCandidats());
		
		detailsCompet.setLayout(new FlowLayout());
		detailsCompet.add(new JLabel("Information : "));
		detailsCompet.add(fullList);
		detailsCompet.add(retour);

		return detailsCompet;
	}
	
	public JPanel addCandidatCompetition(Competition competition) {
		JPanel addCompetition = new JPanel();
		this.competition = competition;
		listTeams.removeAllItems();
		listGuys.removeAllItems();
		if(competition.estEnEquipe()) {
			ArrayList<Equipe> teams = new ArrayList<Equipe>();
			teams = (ArrayList) Passerelle.getData("Equipe");
			for(Equipe e : teams) {
				listTeams.addItem(e);					
			}
		}
		else {
			ArrayList<Personne> guys = new ArrayList<Personne>();
			guys = (ArrayList) Passerelle.getData("Personne");
			for(Personne p : guys) {
				listGuys.addItem(p);
			}
		}

        
        addCompetition.add(new JLabel("Selectionner un candidat : "));
        if(competition.estEnEquipe()) 
        	addCompetition.add(listTeams);
        else
        	addCompetition.add(listGuys);
        addCompetition.add(retour);
        addCompetition.add(added);
		
        added.addActionListener(this);
		
		return addCompetition;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
				
				case "Retour":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(new Application(frame, inscriptions));
					frame.invalidate();
					frame.validate();
					break;

				case "Cr�er une comp�tition":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(createCompetitionIhm());
					frame.invalidate();
					frame.validate();
					break;
					
				case "Cr�er":
					enEquipe = listType.getSelectedItem().toString().equals("en �quipe");
					System.out.println(((JButton) e.getSource()).getText());
					System.out.println(enEquipe + " " + listType.getSelectedItem());
					inscriptions.createCompetition(nameField.getText(), (Date) datePicker.getModel().getValue(), enEquipe);
					frame.getContentPane().removeAll();
					frame.setContentPane(new InterfaceCompetition(frame, inscriptions));
					frame.invalidate();
					frame.validate();
					break;
				
				case "Lister les comp�titions":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(listCompetitionsIhm());
					frame.invalidate();
					frame.validate();
					break;
					
				case "Selectionner une comp�tition":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(selectCompetitionIhm());
					frame.invalidate();
					frame.validate();
					break;
					
				case "Valider":
					System.out.println(((JButton) e.getSource()).getText() + " Sportif : " + list.getSelectedItem());
					frame.getContentPane().removeAll();
					frame.setContentPane(selectedCompetitionIhm((Competition) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Editer la comp�tition":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(editCompetition((Competition) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Supprimer":
					System.out.println(((JButton) e.getSource()).getText());
					competition.delete();
					frame.getContentPane().removeAll();
					frame.setContentPane(selectedCompetitionIhm((Competition) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Editer":
					System.out.println(((JButton) e.getSource()).getText());
					competition.setNom(nameField.getText());
					competition.setDateCloture((Date) datePicker.getModel().getValue());
					frame.getContentPane().removeAll();
					frame.setContentPane(selectedCompetitionIhm((Competition) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Informations d�taill�es sur la comp�tition":
					System.out.println(((JButton) e.getSource()).getText());			
					frame.getContentPane().removeAll();
					frame.setContentPane(detailsCompetIhm((Competition) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Ajouter des candidats � la comp�tition":
					System.out.println(((JButton) e.getSource()).getText());			
					frame.getContentPane().removeAll();
					frame.setContentPane(addCandidatCompetition((Competition) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Ajouter":
					System.out.println(((JButton) e.getSource()).getText());
					if(competition.estEnEquipe())
						competition.add(((Equipe) listTeams.getSelectedItem()));
					else
						competition.add(((Personne) listGuys.getSelectedItem()));
						
					frame.getContentPane().removeAll();
					frame.setContentPane(selectedCompetitionIhm((Competition) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
			}
	}

}
