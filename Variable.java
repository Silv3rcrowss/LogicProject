package projetLogique;

public class Variable extends Expression {
	
	private final String nom;
	
	public Variable(String nomVar) {
		this.nom=new String(nomVar);
	}
	
	@Override
	public Table valeur() {
		// TODO Auto-generated method stub
		return null;
	}

}
