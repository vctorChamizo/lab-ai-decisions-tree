package model;

import java.util.ArrayList;

public class Atribute {

	private String name;
    private ArrayList<Value> values;

    public Atribute(String name) {
    	
        this.name = name;
        this.values = new ArrayList<>();
    }

    public double merit() {
    	
        double merit = 0;        
        
        for(int i = 0; i < values.size(); i++) merit = merit + this.values.get(i).get_A() * this.values.get(i).info_value();
        
        return merit;
    }

    public boolean containe_name(String name) {
    	
        for (int i = 0; i < values.size(); i++) if (values.get(i).get_name().equals(name)) return true;

        return false;
    }

    public void add_value(String name) { this.values.add(new Value(name)); }
    
    
    public String get_name() { return this.name; }

    public ArrayList<Value> get_values() { return values; }
    
	public Value get_value(String name) {
	    	
        boolean found = false;
        int i = 0;

        while (!found) {
        	
            if (values.get(i).get_name().equals(name)) found = true;
            else i++;
        }
        
        return values.get(i);
    }
	
	 public ArrayList<String> get_names() {
	    	
        ArrayList<String> names = new ArrayList<>();
        
        for(int i = 0; i < values.size(); i++) names.add(values.get(i).get_name());

        return names;
    }

	 
    public void set_values(ArrayList<Value> values) { this.values = values; }
}
