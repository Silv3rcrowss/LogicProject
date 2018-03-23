public abstract class Operation extends Expression {
	

	private Expression operande1;
	private Expression operande2;
	private String signe;
	
	public Operation(Expression op1, Expression op2) {
		this.operande1=op1;
		this.operande2=op2;
	}
	
	public Expression getOperande1() {
		return this.operande1;}

	public Expression getOperande2() {
		return this .operande2;}

	public void setOperande1(Expression operande1) {
		this.operande1 = operande1;
	}

	public void setOperande2(Expression operande2) {
		this.operande2 = operande2;
	}
	

	public String getSigne() {
		return signe;
	}

	public void setSigne(String signe) {
		this.signe = signe;
	}
	
	public String toString() {
		return "("+this.getOperande1().toString()+this.getSigne()+this.getOperande2().toString()+")" ;
	}
	
	public String value() {
		if(this.valeur()==true) {
			return "1";
		}
		return "0";
	}
}



