package interfaceHM;

import java.awt.Color;

import javax.swing.JFrame;

import com.sun.javafx.event.EventQueue;

import inscriptions.Inscriptions;

public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Inscriptions inscriptions;

	public Fenetre(Inscriptions inscriptions) {
		super("Inscriptions Sportives");
		this.inscriptions = inscriptions;
		initFenetre();
	}
	
	
	public void initFenetre() {	
		
		setContentPane(new Application(this, inscriptions));
		this.getContentPane().setBackground(Color.white);
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				setSize(1200, 800);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
				setResizable(false);
				setVisible(true);
				
			}
		});
		
	}
	
	public static void close() {
		System.exit(0);
	}
}
