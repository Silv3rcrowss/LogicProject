package maths;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class fenetre extends JFrame {
	private JButton bouton;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;
	private JButton bouton5;
	private JButton ok;
	private Listener listen;
	private MotherClass mc;
	private JPanel panel = new JPanel();
	

	public MotherClass getMc() {
		return mc;
	}

	private JTextArea text;

	public fenetre(){
		super();
		listen =new Listener(this);
		build();//On initialise notre fenêtre
	}
	
	
	public String setMc(String Expression) {
		this.mc=new MotherClass(Expression);
		return mc.toString();
	} 
	private void build(){
		setTitle("Fenêtre qui affiche des boutons"); //On donne un titre à l'application
		setSize(320,400); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(true); //On permet le redimensionnement
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());

	
	}
	
	
	private JPanel buildContentPane(){
		
		panel.setLayout(new FlowLayout());
 
		bouton = new JButton("⇒");
		bouton.addActionListener(listen);
		panel.add(bouton);
 
		bouton2 = new JButton("⇔");
		bouton2.addActionListener(listen);
		panel.add(bouton2);
		
		bouton3 = new JButton("∧");
		bouton3.addActionListener(listen);
		panel.add(bouton3);
		
		bouton4 = new JButton("∨");
		bouton4.addActionListener(listen);
		panel.add(bouton4);
		
		bouton5 = new JButton("¬");
		bouton5.addActionListener(listen);
		panel.add(bouton5);
		
		ok = new JButton("ok");
		ok.addActionListener(listen);
		panel.add(ok);
		
		text = new JTextArea(1, 15);
		panel.add(text);
		
		
 
		return panel;
	}
	
	public Listener getListen() {
		return listen;
	}

	public JButton getBouton() {
		return bouton;
	}

	public JButton getBouton2() {
		return bouton2;
	}

	public JButton getBouton3() {
		return bouton3;
	}

	public JButton getBouton4() {
		return bouton4;
	}

	public JButton getBouton5() {
		return bouton5;
	}

	public JButton getOk() {
		return ok;
	}

	public JTextArea getText() {
		return text;
	}


	public void add(String setMc) {
		panel.add(setMc,panel);		
	}
	

	

	
}