package interfaceHM;

import javax.swing.JFrame;

import inscriptions.Inscriptions;

public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Inscriptions inscriptions;

	public Fenetre(Inscriptions inscriptions) {
		super("Inscriptions Sportives");
		this.inscriptions = inscriptions;
	}
	
	
	public void initFenetre() {		
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(new Application(this, inscriptions));
		setVisible(true);
	}
}
