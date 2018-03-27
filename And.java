public class And extends Operation{

	public And(Expression op1, Expression op2) {
		super(op1, op2);
		this.setSigne("∧");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean valeur() {
		return this.getOperande1().valeur() && this .getOperande2().valeur();
	}
}
