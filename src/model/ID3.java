package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class ID3 {

	private ArrayList<Atribute> atributes;
    private ArrayList<String[]> game;
    private Atribute solution;
    private Parser parser;

    public ID3() throws FileNotFoundException {
        
    	parser = new Parser();
    	
        ini_atributes();
        ini_game();
        exc_ID3();
    }
    
    
    public void ini_atributes() {
    	
        String[] aux = parser.read_atributes();
        atributes = new ArrayList<>();
        
        for (int i = 0; i < aux.length; i++) this.atributes.add(new Atribute(aux[i]));
    }
    
    public void ini_game() {
    	
        String[] aux;
        this.game = new ArrayList<>();
        
        while (parser.has_values()) {
        	
            aux = parser.read_values();
            
            for (int i = 0; i < aux.length - 1; i++)
                if (!this.atributes.get(i).containe_name(aux[i])) this.atributes.get(i).add_value(aux[i]);
            
            this.game.add(aux);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void exc_ID3() {
    	
		ArrayList<Atribute> a = (ArrayList<Atribute>) this.atributes.clone();
   	 
        ArrayList<String[]> j = (ArrayList<String[]>) this.game.clone();
        
        this.solution = exc_ID3(a, j);
    }
    
    public ArrayList<Atribute> get_atributes() { return atributes; }

    public boolean is_posible(String[] s) {
    	
    	Atribute at = this.solution;
    	
    	Value v = at.get_value(s[this.atributes.indexOf(at)]);
    	
    	while(!v.is_final()){
    		
            try{
            	
            	at = at.get_value(s[this.atributes.indexOf(at)]).get_atribute();
            	
                if(at.get_name().equalsIgnoreCase("jugar")) return true;

                v = at.get_value(s[this.atributes.indexOf(at)]);
                
            }
            catch(Exception e){ return false; }
    	}
    	
    	if(v.is_positive()) return true;
    	else return false;
    }
    
    
	private String[] anyadeLineaDegame(String[] s, int idx) {
	    	
        String[] aux;
        int j = 0;
        int size = s.length;
        String local;
        aux = new String[size-1];
        
        for (int i = 0; i < s.length; i++) {
        	
            if (i != idx) {
            	
                local = s[i];
                aux[j] = local;
                j++;
            }
        }        
        
        return aux;
    }
	
	private Atribute exc_ID3(ArrayList<Atribute> a, ArrayList<String[]> j) {
    	
        ArrayList<Atribute> auxA = a;
        ArrayList<String[]> auxJ = j;

        int auxIdx = a.indexOf(calculate_best_merit(a, j));     
        
        Atribute auxSol = a.get(auxIdx);
        Value auxVal;
        String[] auxS = new String[j.size()];
        
        auxA.remove(auxSol);
           
        Iterator<?> iter = auxSol.get_values().iterator();
        Iterator<String[]> iter2 = j.iterator();
        
        while (iter.hasNext()) {
        	
            auxVal = (Value) iter.next();
            auxJ = new ArrayList<>();
                        
            while (iter2.hasNext()) {
            	
                auxS = (String[])iter2.next();
                                
                if (auxS[auxIdx].equals(auxVal.get_name())) auxJ.add(anyadeLineaDegame(auxS, auxIdx));                        
            }

            if (auxS.length > 0) auxVal.set_atribute(exc_ID3(auxA, auxJ));
            
        }
        
        return auxSol;
    }

    private Atribute calculate_best_merit(ArrayList<Atribute> a, ArrayList<String[]> j) {
    	
        String[] auxJ;
        Atribute aux, auxSol = null;
        double auxMerito = Double.MAX_VALUE;
        Iterator<String[]> it = j.iterator();

        while (it.hasNext()) {
        	
            auxJ = (String[]) it.next();

            for (int i = 0; i < auxJ.length - 1; i++) {
            	
                if (a.get(i).containe_name(auxJ[i])) {
                	
                    if (auxJ[auxJ.length - 1].equalsIgnoreCase("si")) {

                        int posit = a.get(i).get_value(auxJ[i]).get_positives();
                        posit++;
                        a.get(i).get_value(auxJ[i]).set_positives(posit);

                    }
                    else {

                        int negat = a.get(i).get_value(auxJ[i]).get_negatives();
                        negat++;
                        a.get(i).get_value(auxJ[i]).set_negatives(negat);
                    }
                    
                    a.get(i).get_value(auxJ[i]).A_plus();
                }
            }
        }

        Iterator<Atribute> ita = a.iterator();
        boolean isNan = false;
        
        while (ita.hasNext() && !isNan) {
        	
            aux = (Atribute) ita.next();

            if(Double.isNaN(aux.merit())){      
            	
                auxSol = aux;
                isNan = true;
            }                          
            else if (aux.merit() < auxMerito) {  
            	
                auxSol = aux; 
                auxMerito = aux.merit();                        
            }            
        }        
        
        return auxSol;
    }
    
}

