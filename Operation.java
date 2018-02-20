package projetLogique;

public abstract class Operation extends Expression {
	

	private Expression operande1;
	private Expression operande2;
	
	
	public Expression getOperande1() {
		return null;}

	public Expression getOperande2() {
		return null;}

	public void setOperande1(Expression operande1) {
		this.operande1 = operande1;
	}

	public void setOperande2(Expression operande2) {
		this.operande2 = operande2;
	}

}
