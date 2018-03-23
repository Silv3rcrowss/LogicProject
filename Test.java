package maths;

import javax.swing.SwingUtilities;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*testExpression es =new testExpression();
		es.testExpress("()a∨b()");*/
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				fenetre fenetre = new fenetre();
				fenetre.setVisible(true);
				
			}
		});
	}

}
