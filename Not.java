public class Not extends Operation {

	public Not(Expression op1) {
		super(op1, null);
		this.setSigne("¬");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean valeur() {
		// TODO Auto-generated method stub
		return !this.getOperande1().valeur();
	}
	
	public String toString() {
		return "(¬"+this.getOperande1().toString()+")";
	}
}
