package maths;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {
	private fenetre fen;
	public Listener(fenetre f) {
		super();
		fen=f;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
 
		if(source == fen.getBouton()){
			fen.getText().append("⇒");
		} 
		else if(source == fen.getBouton2()){
			fen.getText().append("⇔");
			
		}
		else if(source == fen.getBouton3()){
			fen.getText().append("∧");
			
		}
		else if(source == fen.getBouton4()){
			fen.getText().append("∨");
			
		}
		else if(source == fen.getBouton5()){
			fen.getText().append("¬");
				
		}
		else if(source == fen.getOk()) {
			System.out.println(fen.setMc(fen.getText().getText()));
			
			
		}
	}

	private Object getBouton2() {
		// TODO Auto-generated method stub
		return null;
	}

}
