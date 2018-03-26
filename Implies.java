package maths;
public class Implies extends Operation {

	public Implies(Expression op1, Expression op2) {
		super(op1, op2);
		this.setSigne("⇒");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean valeur() {
		// TODO Auto-generated method stub
		return !this.getOperande1().valeur() || this.getOperande2().valeur();
	}

}
