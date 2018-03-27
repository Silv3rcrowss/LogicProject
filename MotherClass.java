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
	
	public String notationPostfixee(String Expr){
		
		String notation="";
		if(Expr.length()==1) {
			notation+=Expr.charAt(0);
			return notation;
		}
		else if(Expr.length()<=5) {
			char c='x';
			for(int i=0;i<Expr.length();i++) {
				if(isVariable(Expr.charAt(i))|| Expr.charAt(i)=='0'|| Expr.charAt(i)=='1')
					notation+=Expr.charAt(i);
				else if(isOperation(Expr.charAt(i)))
					c=Expr.charAt(i);
			}
			notation+=c;
			return notation;
		}else {
			SAD pilePar=new SAD();
			SAD pileOp=new SAD();
			int signeExpr=3;
			for(int i=0;i<Expr.length();i++) {
				if(Expr.charAt(i)=='(')
					pilePar.empilerInt(i);
				else if(Expr.charAt(i)==')') {
					if(pilePar.getSizeInt()==1)
						signeExpr=pileOp.depilerInt();
					else {
						pileOp.depilerInt();
						pilePar.depilerInt();
					}
				}
				else if(isOperation(Expr.charAt(i))) {
					pileOp.empilerInt(i);
				}	
			}
			/*String toSplit=split(Expr,1,Expr.length()-2);
			signeExpr--;
			SAD val1=pile.empilerCharpile(notationPostfixee(split(toSplit,0,signeExpr-1)));
			SAD val2=val1.empilerCharpile(notationPostfixee(split(toSplit, signeExpr+1, toSplit.length()-1)));
			val2.empiler(toSplit.charAt(signeExpr));*/
			return notationPostfixee(split(Expr,1,signeExpr-1))+notationPostfixee(split(Expr,signeExpr+1,Expr.length()-2))+Expr.charAt(signeExpr);
		}
		
		
		
	}
	
	public String getExpression() {
		return this.Expression;
	}
	
	public Boolean isOperation(char c) {
		return c=='∨' || c=='∧' || c=='⇒' || c=='⇔' || c=='¬'; 
	}
	
	
	private String split(String Expr,int i,int j) {
		String s="";
		for(;i<=j;i++)
			s+=Expr.charAt(i);
		return s;
	}
	
	
	
	
	public Boolean testParenth() {
		SAD pile=new SAD();
		for(int i=0;i<this.Expression.length();i++){
			if(this.Expression.charAt(i)=='(')
				pile.empilerInt(i);
			else if(this.Expression.charAt(i)==')') {
				if(pile.isEmpty())
					return false;			
			}
		}
		return pile.isEmpty();
	}
	
	
	public Boolean testExpression() {
		return this.head.toString().equals(this.Expression) ;
	}
	
	public void calulerResultats() {
		SAD file=new SAD();
		String notation=this.notationPostfixee(Expression);
		for(int i=0;i<notation.length();i++)
			file.ajouterFile(notation.charAt(i));
		try {
		this.head=genererArbre(file);
		}catch(Exception e) {
			System.out.println("Echec Operations: Expresison Incorrecte");
			System.exit(-1);
		}
		for(int j=0;j<Math.pow(2,this.tableVerite.getnbVariables());j++) {
			for(int i=0;i<this.tableVerite.getnbVariables();i++) {
				for(Variable v:Variables) {
					if(v.getNom()==tableVerite.getVariable(i)) {
						v.setValue(tableVerite.getLigne(j).get(i));
					}
				}
			}
			tableVerite.ajoutResultat(head.valeur());
			if(!testExpression()) {
				System.out.println("Echec : Expresison Incorrecte");
				System.exit(0);
			}
		}
	}
	
	
	public Expression genererArbre(SAD file)throws Exception{
		SAD Tmpile=new SAD();
		char e;
		Variable temp;
		Expression x;
		while(!file.isEmpty()) {
			e=file.defiler();
			if(isVariable(e)) {
				temp=new Variable(e);
				Tmpile.empilerExp(temp);
				this.Variables.add(temp);
			}else if((e=='1') || (e=='0')) {
				temp=new Variable(e);
				Tmpile.empilerExp(temp);
			}
			else {
				x=Tmpile.depilerExp();
				if(e=='∨')
					Tmpile.empilerExp(new Or(Tmpile.depilerExp(),x));
				else if(e=='∧')
					Tmpile.empilerExp(new And(Tmpile.depilerExp(),x));
				else if(e=='⇒')
					Tmpile.empilerExp(new Implies(Tmpile.depilerExp(),x));
				else if(e=='⇔')
					Tmpile.empilerExp(new Equivalent(Tmpile.depilerExp(),x));
				else if(e=='¬')
					Tmpile.empilerExp(new Not(x));
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
		System.out.println("Notation Postfixée :"+m.notationPostfixee(m.getExpression()));
		System.out.println("Opération Effectué :"+m.head+"\n");
		System.out.println(m);
		
	}
	
	
}
