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
	
	public SAD empilerCharpile(SAD pile) {
		SAD sortie=new SAD();
		while(!this.isEmpty()) {
			sortie.empiler(this.defiler());
		}
		while(!pile.isEmpty()) {
			this.tab.add(pile.defiler());
		}
		return sortie;
	}
	
	
	public char depiler(){
		if(tab.isEmpty())
			return (Character) null;
		char e=tab.get(tab.size()-1);
		tab.remove(tab.size()-1);
		return e;	
	}
	
	public Expression depilerExp()throws Exception{
		if(Expr.isEmpty())
			throw new Exception();
		Expression e=Expr.get(Expr.size()-1);
		Expr.remove(Expr.size()-1);
		return e;	
	}
	
	
	public int defilerInt() {
		if(this.isEmptyInt())
			return 0;
		int x=tabInt.get(0);
		tabInt.remove(0);
		return x;
	}
	
	public int depilerInt(){
		if(this.isEmptyInt())
			return  0;
		else {
		int e=tabInt.get(tabInt.size()-1);
		tabInt.remove(tabInt.size()-1);
		return e;
		}
	}
	
	
	public char defiler(){
		if(tab.isEmpty())
			return 'X';
		char e=tab.get(0);
		tab.remove(0);
		return e;
	}
	
	public Expression defilerExp()throws Exception{
		if(Expr.isEmpty())
			throw new Exception();
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
	
	public Boolean isEmptyInt() {
		return tabInt.isEmpty();
	}
	
	
	public Boolean isEmptyExp() {
		return Expr.isEmpty();
	}
	
	public int getSizeInt() {
		return this.tabInt.size();
	}
	
	public String toString() {
		String s="";
		for(char c:tab)
			s+=c;
		return s;
	}
}
