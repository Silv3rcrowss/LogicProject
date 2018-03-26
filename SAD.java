package maths;
import java.util.ArrayList;

public class SAD {
	
	public ArrayList<Character> tab=new ArrayList<Character>();
	public ArrayList<Expression> Expr=new ArrayList<Expression>();
	public ArrayList<Integer> tabInt=new ArrayList<Integer>();
	
	
	public void empiler(char e) {
		this.tab.add(e);
	}
	
	public void empilerExp(Expression e) {
		this.Expr.add(e);
	}
	
	public void empilerInt(int e) {
		this.tabInt.add(e);
	}
	
	public char depiler(){
		if(tab.isEmpty())
			return (Character) null;
		char e=tab.get(tab.size()-1);
		tab.remove(tab.size()-1);
		return e;	
	}
	
	public Expression depilerExp(){
		if(Expr.isEmpty())
			return null;
		Expression e=Expr.get(Expr.size()-1);
		Expr.remove(Expr.size()-1);
		return e;	
	}
	
	public int depilerInt(){
		if(tabInt.isEmpty())
			return  -1;
		int e=tabInt.get(tabInt.size()-1);
		tab.remove(tabInt.size()-1);
		return e;	
	}
	
	
	public char defiler(){
		if(tab.isEmpty())
			return (Character) null;
		char e=tab.get(0);
		tab.remove(0);
		return e;
	}
	
	public Expression defilerExp(){
		if(Expr.isEmpty())
			return null;
		Expression e=Expr.get(0);
		Expr.remove(0);
		return e;
	}
	
	public void ajouterFile(char e) {
		this.empiler(e);
	}
	
	public void ajouterFileExp(Expression e) {
		this.empilerExp(e);
	}
	
	public Boolean isEmpty() {
		return tab.isEmpty();
	}
	
	public Boolean isEmptyExp() {
		return Expr.isEmpty();
	}
	
}
