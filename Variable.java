public class Variable extends Expression {
	
	private final char nom;
	private Boolean value;
	
	public Variable(char nomVar) {
		this.nom=nomVar;
	}
	
	public Variable(char nomVar, Boolean valeur) {
		this.nom=nomVar;
		this.value=valeur;
	}
	
	public char getNom() {
		return this.nom;
	}
	public void setValue(Boolean value) {
		this.value = value;
	}

	@Override
	public Boolean valeur() {
		if(this.nom=='1')
			return true;
		if(this.nom=='0')
			return false;
		return this.value;

		}

	public String toString() {
		return Character.toString(nom);
	}
			
	}


