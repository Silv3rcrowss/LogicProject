package maths;
public class Equivalent extends Operation {

	public Equivalent(Expression op1, Expression op2) {
		super(op1, op2);
		this.setSigne("⇔");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean valeur() {
		// TODO Auto-generated method stub
		return this.getOperande1()==this.getOperande2();
	}

}
