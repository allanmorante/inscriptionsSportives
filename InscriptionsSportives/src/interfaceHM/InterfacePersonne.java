package interfaceHM;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import hibernate.Passerelle;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class InterfacePersonne extends JPanel implements ActionListener {

	private static final long serialVersionUID = -1199010738822613479L;
	private JButton createGuy = new JButton("Cr�er un sportif");
	private JButton listGuy = new JButton("Lister les sportifs");
	private JButton selectGuy = new JButton("Selectionner un sportif");
	private JButton retour = new JButton("Retour");
	private JButton createdGuy = new JButton("Cr�er");
	private JButton selectedGuy = new JButton("Valider");
	private JButton editGuy = new JButton("Editer le sportif");
	private JButton deleteGuy = new JButton("Supprimer");
	private JButton editedGuy = new JButton("Editer");
	private JButton sendMail = new JButton("Envoyer");
	private JLabel nameLabel = new JLabel("Nom : ");
	private JLabel fnameLabel = new JLabel("Prenom : ");
	private JLabel mailLabel = new JLabel("Mail : ");
	private JLabel destinataire = new JLabel("A : ");
	private JLabel object = new JLabel("Objet : ");
	private JLabel message = new JLabel("Message : ");
	private JButton contactGuy = new JButton("Contacter");
	JTextField nameField = new JTextField();
	JTextField fnameField = new JTextField();
	JTextField mailField = new JTextField();
	JTextField objectField = new JTextField();
	JTextPane messageField = new JTextPane();
	DefaultListModel listMails = new DefaultListModel();
	JComboBox list = new JComboBox();
	JList fullList = new JList();
	private Inscriptions inscriptions;
	private Personne personne;
	private JFrame frame;
	
	public InterfacePersonne(JFrame frame, Inscriptions inscriptions) {
		this.frame = frame;
		this.inscriptions = inscriptions;
		initInterfacePersonne();
	}
	
	public void initInterfacePersonne() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		add(new JLabel("<html><h1><strong><i>Inscription Sportive</i></strong></h1><hr></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.add(createGuy, gbc);
		buttons.add(listGuy, gbc);
		buttons.add(selectGuy, gbc);
		buttons.add(contactGuy, gbc);
		buttons.add(retour, gbc);

		gbc.weighty = 1;
		add(buttons, gbc);
		createGuy.addActionListener(this);
		listGuy.addActionListener(this);
		selectGuy.addActionListener(this);
		contactGuy.addActionListener(this);
		retour.addActionListener(this);
	}
	
	public JPanel createGuyIhm() {
		JPanel createGuy = new JPanel();
		nameLabel.setPreferredSize( new Dimension( 400, 24 ) );
		fnameLabel.setPreferredSize( new Dimension( 400, 24 ) );
		mailLabel.setPreferredSize( new Dimension( 400, 24 ) );
		nameField.setPreferredSize( new Dimension( 400, 24 ) );
		fnameField.setPreferredSize( new Dimension( 400, 24 ) );
		mailField.setPreferredSize( new Dimension( 400, 24 ) );
		
		createGuy.setBorder(BorderFactory.createTitledBorder("Cr�ation du sportif"));
		createGuy.add(nameLabel);
		createGuy.add(nameField);
		createGuy.add(fnameLabel);
		createGuy.add(fnameField);
		createGuy.add(mailLabel);
		createGuy.add(mailField);

		createGuy.add(retour);
		createGuy.add(createdGuy);

		createdGuy.addActionListener(this);
		
		return createGuy;

	}
	
	public JPanel listGuysIhm() {
		JPanel listGuys = new JPanel();
		DefaultListModel<Personne> list = new DefaultListModel<Personne>();
		JList<Personne> fullList = new JList<Personne>(list);
		ArrayList<Personne> guys = new ArrayList<Personne>();
		guys = (ArrayList) Passerelle.getData("Personne");
		for(Personne p : guys) {
			list.addElement(p);
		}
		listGuys.setLayout(new FlowLayout());
		listGuys.add(new JLabel("Liste des sportifs : "));
		listGuys.add(fullList);
		listGuys.add(retour);

		return listGuys;
	}
	
	public JPanel selectGuyIhm() {
		JPanel selectGuy = new JPanel();
		ArrayList<Personne> guys = new ArrayList<Personne>();
		guys = (ArrayList) Passerelle.getData("Personne");

        for(Personne p : guys) {
			list.addItem(p);
		}
        selectGuy.add(new JLabel("Selectionner un sportif : "));
		selectGuy.add(list);
		selectGuy.add(retour);
		selectGuy.add(selectedGuy);
		
		selectedGuy.addActionListener(this);
		return selectGuy;
	}
	
	public JPanel selectedGuyIhm(Personne personne) {
		JPanel selectedGuy = new JPanel(new GridBagLayout());
		this.personne = personne;
		selectedGuy.setBorder(new EmptyBorder(10, 10, 10, 10));
		selectedGuy.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		selectedGuy.add(new JLabel("<html><h1><strong><i>Inscription Sportive</i></strong></h1><hr></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		selectedGuy.add(editGuy, gbc);
		selectedGuy.add(deleteGuy, gbc);
		selectedGuy.add(retour, gbc);

		gbc.weighty = 1;
		add(selectedGuy, gbc);
		editGuy.addActionListener(this);
		deleteGuy.addActionListener(this);
		retour.addActionListener(this);
		
		return selectedGuy;
	}
	
	public JPanel editGuy(Personne personne) {
		JPanel editGuy = new JPanel();
		this.personne = personne;
		
		nameLabel.setPreferredSize( new Dimension( 400, 24 ) );
		fnameLabel.setPreferredSize( new Dimension( 400, 24 ) );
		mailLabel.setPreferredSize( new Dimension( 400, 24 ) );
		nameField.setPreferredSize( new Dimension( 400, 24 ) );
		fnameField.setPreferredSize( new Dimension( 400, 24 ) );
		mailField.setPreferredSize( new Dimension( 400, 24 ) );
		
		nameField.setText(personne.getNom());
		fnameField.setText(personne.getPrenom());
		mailField.setText(personne.getMail());
		
		editGuy.setBorder(BorderFactory.createTitledBorder("Edition du sportif"));
		editGuy.add(nameLabel);
		editGuy.add(nameField);
		editGuy.add(fnameLabel);
		editGuy.add(fnameField);
		editGuy.add(mailLabel);
		editGuy.add(mailField);

		editGuy.add(retour);
		editGuy.add(editedGuy);

		editedGuy.addActionListener(this);
		
		return editGuy;

	}
	
	public JPanel contactGuyIhm() {
		JPanel contact = new JPanel();
		contact.setLayout(new BorderLayout());
		JPanel button = new JPanel();
		JPanel border = new JPanel();
		
		border.setBorder(BorderFactory.createTitledBorder("Contact"));
		ArrayList<Personne> guys = new ArrayList<Personne>();
		guys = (ArrayList) Passerelle.getData("Personne");

        for(Personne p : guys) {
			listMails.addElement(p.getMail());
		}
		fullList = new JList(listMails);
		fullList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		fullList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		fullList.setVisibleRowCount(-1);
		
		JScrollPane jsp = new JScrollPane(messageField);
		JScrollPane listScroller = new JScrollPane(fullList);
		destinataire.setPreferredSize(new Dimension(400, 24));
		listScroller.setPreferredSize(new Dimension(400, 80));
		object.setPreferredSize(new Dimension(400, 24));
		objectField.setPreferredSize(new Dimension(400, 24));
		message.setPreferredSize(new Dimension(400, 24));
		messageField.setPreferredSize(new Dimension(400, 300));
		
		messageField.setCaretPosition(0);
		
		border.add(destinataire);
		border.add(listScroller);
		border.add(object);
		border.add(objectField);
		border.add(message);
		border.add(jsp);
		button.add(retour);
		button.add(sendMail);
		
		contact.add(button, BorderLayout.SOUTH);
		contact.add(border, BorderLayout.CENTER);
		
		sendMail.addActionListener(this);
		
		return contact;
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
					
				case "Cr�er un sportif":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(createGuyIhm());
					frame.invalidate();
					frame.validate();
					break;
					
				case "Cr�er":
					System.out.println(((JButton) e.getSource()).getText());
					inscriptions.createPersonne(nameField.getText(), fnameField.getText(), mailField.getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(new InterfacePersonne(frame, inscriptions));
					frame.invalidate();
					frame.validate();
					break;
				
				case "Lister les sportifs":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(listGuysIhm());
					frame.invalidate();
					frame.validate();
					break;
					
				case "Selectionner un sportif":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(selectGuyIhm());
					frame.invalidate();
					frame.validate();
					break;
					
				case "Valider":
					System.out.println(((JButton) e.getSource()).getText() + " Sportif : " + list.getSelectedItem());
					frame.getContentPane().removeAll();
					frame.setContentPane(selectedGuyIhm((Personne) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Editer le sportif":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(editGuy((Personne) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Supprimer":
					System.out.println(((JButton) e.getSource()).getText());
					personne.delete();
					frame.getContentPane().removeAll();
					frame.setContentPane(selectedGuyIhm((Personne) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Editer":
					System.out.println(((JButton) e.getSource()).getText());
					personne.setNom(nameField.getText());
					personne.setPrenom(fnameField.getText()); 
					personne.setMail(mailField.getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(selectedGuyIhm((Personne) list.getSelectedItem()));
					frame.invalidate();
					frame.validate();
					break;
					
				case "Contacter":
					System.out.println(((JButton) e.getSource()).getText());
					frame.getContentPane().removeAll();
					frame.setContentPane(contactGuyIhm());
					frame.invalidate();
					frame.validate();
					break;
				/*	
				case "Envoyer":
					System.out.println(((JButton) e.getSource()).getText());
					Object[] mails =  fullList.getSelectedValuesList().toArray();
					for(int i = 0, n = mails.length; i < n; i++) {
						String mail = (String) mails[i];
						Contact.sendMail(mail, objectField.getText(), messageField.getText());
					}
					frame.getContentPane().removeAll();
					frame.setContentPane(new InterfacePersonne(frame, inscriptions));
					frame.invalidate();
					frame.validate();
					break;	
					*/			
		}
	}
}
