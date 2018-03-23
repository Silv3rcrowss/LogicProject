import java.util.ArrayList;
import java.util.Scanner;

public class MotherClass {
	
	private String Expression;
	private ArrayList<Variable> Variables=new ArrayList<Variable>();
	private Table tableVerite;
	private Expression head;
	//TODO Cette classe a pour but de tout gerer de l'analyse de l'expression a l'affichage du resultat
	
	
	public MotherClass(String Expression) {
		this.Expression=new String(Expression);
		ArrayList<Character> chars=new ArrayList<Character>();
		for(int i=0;i<Expression.length();i++) {
			if(isVariable(Expression.charAt(i)) && !chars.contains((Character)Expression.charAt(i)))
				chars.add(Expression.charAt(i));
		}
		this.tableVerite=new Table(chars);
		this.calulerResultats();
	}
	
	/*public SAD notationPostfixee(){
		SAD pilePar=new SAD();
		SAD pile=new SAD();
		for(int i=0;i<this.Expression.length();i++) {
			if(this.Expression.charAt(i)=='(') {
				pilePar.empilerInt(i);
			}
			else if(this.Expression.charAt(i)==')'){
				
			}
		}
		return pile;
	}*/
	
	public void calulerResultats() {
		SAD file=new SAD();
		for(int i=0;i<Expression.length();i++)
			file.ajouterFile(Expression.charAt(i));
		this.head=genererArbre(file);
		for(int j=0;j<Math.pow(2,this.tableVerite.getnbVariables());j++) {
			for(int i=0;i<this.tableVerite.getnbVariables();i++) {
				for(Variable v:Variables) {
					if(v.getNom()==tableVerite.getVariable(i)) {
						v.setValue(tableVerite.getLigne(j).get(i));
					}
				}
			}
			tableVerite.ajoutResultat(head.valeur());
		}
	}
	
	
	public Expression genererArbre(SAD file){
		SAD Tmpile=new SAD();
		char e;
		Variable temp;
		while(!file.isEmpty()) {
			e=file.defiler();
			if(isVariable(e)) {
				temp=new Variable(e);
				Tmpile.empilerExp(temp);
				this.Variables.add(temp);
				
			}
			else {
				if(e=='∨')
					Tmpile.empilerExp(new Or(Tmpile.depilerExp(),Tmpile.depilerExp()));
				else if(e=='∧')
					Tmpile.empilerExp(new And(Tmpile.depilerExp(),Tmpile.depilerExp()));
				else if(e=='⇒')
					Tmpile.empilerExp(new Implies(Tmpile.depilerExp(),Tmpile.depilerExp()));
				else if(e=='⇔')
					Tmpile.empilerExp(new Equivalent(Tmpile.depilerExp(),Tmpile.depilerExp()));
				else if(e=='¬')
					Tmpile.empilerExp(new Not(Tmpile.depilerExp()));
			}
		} 
		return Tmpile.depilerExp();
	}
	
	public String toString() {
		return tableVerite.toString();
	}
	
	public Boolean isVariable(char v) {
		return (((int)v)<=((int)'Z') && ((int)v)>=((int)'A'));
	}

	public ArrayList<Variable> getVariables() {
		return Variables;
	}

	public void setVariables(ArrayList<Variable> variables) {
		Variables = variables;
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String expression=sc.nextLine();
		MotherClass m=new MotherClass(expression);
		System.out.println(m.head+"\n");
		System.out.println(m);
		
	}
	
	
}
