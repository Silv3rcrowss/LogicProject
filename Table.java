import java.util.ArrayList;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

public class Table {
//TODO cette classe sera plus facile a manipuler que des Arraylist, on peux le voir comme une arraylist en mieu organisé
	private ArrayList<Boolean> resultats;
	private ArrayList <ArrayList<Boolean>> tableVerite;//contient le resultat de variables et des de la table de verité totale (derniere )
	private ArrayList <Character> variables;//contient des "Strings" le nom des varibles a la position correspondant
	
	public Table(ArrayList<Character> variables){
		this.variables=new ArrayList<Character>(variables);
		this.resultats=new ArrayList<Boolean>();
		this.tableVerite=new ArrayList<ArrayList<Boolean>>();
		for(int i=0;i<variables.size();i++)
			this.tableVerite.add(new ArrayList<Boolean>());
		this.genererTable();
		if(this.getnbVariables()!=variables.size()) {
			/*int var =getnbVariables();
			for(char c:variables) {
				if(c=='1') {
					for(int i=0;i<(int) Math.pow(2,this.getnbVariables());i++){
						tableVerite.get(var).add(true);
					}
				}
				else if(c=='0') {
					for(int i=0;i<(int) Math.pow(2,this.getnbVariables());i++){
						tableVerite.get(var).add(false);
					}
				}
				var++;
			}*/
		}
	}
	
	
	public ArrayList<Boolean> getLigne(int i){
		ArrayList<Boolean> retour= new ArrayList<>();
		for(int j=0;j<tableVerite.size();j++) {
			retour.add(tableVerite.get(j).get(i));
		}
		return retour;
	}
	
	
	public char getVariable(int i) {
		return variables.get(i);
	}
	
	public void genererTable() {
		int nbPossib=(int) Math.pow(2,this.getnbVariables());
		int nbS=nbPossib/2;
		for(int i=0;i<tableVerite.size();i++) {
			boolean valeur=false;
			for(int j=0;j<nbPossib;) {
				for(int k=0;k<nbS;k++) {
					tableVerite.get(i).add(valeur);
					j++;
				}
				valeur=!valeur;
			}
			nbS/=2;
		}
	}
	
	
	public int getnbVariables(){
		int nbVariables=0;
		for(char c:variables) {
			if(((int)c)<=((int)'Z') && ((int)c)>=((int)'A'))
				nbVariables++;
		}
		return nbVariables;
	}
	

	

	public ArrayList<ArrayList<Boolean>> getTableVerite() {
		return tableVerite;
	}
	
	public void ajoutResultat(boolean e) {
		this.resultats.add(e);
	}

	public String toString() {
		String retour="";
		for(char c:variables)
			retour+=" _____";
		retour+=" _____\n";
		for(char c:variables)
			retour+="|  "+c+"  ";
		retour+="| Res |\n";
		for(int i=0;i<Math.pow(2,getnbVariables());i++) {
			for(int j=0;j<tableVerite.size();j++) {
				char val;
				if(tableVerite.get(j).get(i)==true)
					val='1';
				else
					val='0';
				retour+="|  "+val+"  "; 
			}
			if(resultats.get(i)==true)
				retour+="|  "+1+"  |\n";
			else
				retour+="|  "+0+"  |\n";
				
		}
		for(char c:variables)
			retour+=" ¯¯¯¯¯";
		retour+=" ¯¯¯¯¯\n";
		return retour+tableVerite.size();
		
	}
	
}
