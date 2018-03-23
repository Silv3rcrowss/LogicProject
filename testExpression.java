package maths;

public class testExpression{
	private fenetre fen;
	
	
	
public testExpression(fenetre fen) {
		super();
		this.fen = fen;
	}



public boolean testExpress(String s){
	
	
	 String[] result = s.split("");
	 int n=result.length;/*
     for (int x=0; x<result.length; x++) {
         System.out.println(result[x]);
     }*/
    
   
     if (!(result[0].equals("(") && result[n-1].equals(")"))) {
    	  System.out.println("voici premiere case : "+result[0]+"derniere case : "+result[n-1]);
		 System.out.println("erreur mettre parenthese");
		 return false;
	 }
   
     int po=0;
     int pf=1; // pr qu'il compte la derniere parenthse
	 
     for (int i=0; i<result.length-1;i++) {
    	if (result[i].equals("(")) {
    		po+=1;
    	}
    	else if (result[i].equals(")")) {
    		pf+=1;
    	}
    	
    	
    	if (Character.isLetter(result[i].charAt(0)) && (!(result[i+1].equals("⇒")) && !(result[i+1].equals("⇔")) && !(result[i+1].equals("∧")) &&!(result[i+1].equals(")")) && !(result[i+1].equals("∨")))) {
    		 System.out.println("actuel :"+result[i]);
    		 System.out.println("actuel apres :"+result[i+1]);
    		 System.out.println("lettres non suivi d'un bon symbole");
    		 return false;
    	}
    	else  if (result[i].equals(")") && ( Character.isLetter(result[i+1].charAt(0)) || result[i+1].equals("("))) {
			System.out.println("apres ) pas mettre lettre ni (");
			 return false;
    	}
    	else if (result[i].equals("(") && (result[i+1].equals(")") || result[i+1].equals("⇒") || result[i+1].equals("⇔") || result[i+1].equals("∧") || result[i+1].equals("∨"))) {
    			 System.out.println("erreur  symbole apres parenthese");
    			 return false;
    	}
    	else if ( (result[i].equals("⇒") || result[i].equals("⇔") || result[i].equals("∧") || result[i].equals("∨")||result[i].equals("¬") ) && (!(result[i+1].equals("(")) && (!Character.isLetter(result[i+1].charAt(0))|| (Character.isLetter(result[i+1].charAt(0)) && !result[i+2].equals(")"))  )))  {
    		 System.out.println("actuel :"+result[i]);
    		 System.out.println("actuel apres :"+result[i+1]);
    		System.out.println("apres symbole mettre ( ou lettre");
    		 return false;
    	}

    	else if(result[i+1].equals("¬") && !(result[i].equals("("))) {
    		System.out.println("avant ¬ mettre (");
    		return false;
    	}
     }
     System.out.println("po : "+po);
     System.out.println("pf : "+pf);
     if (po!=pf) {
    	System.out.println("pas meme nombre de parenthese");
    	return false;
     }
	return true;
	
}


}

