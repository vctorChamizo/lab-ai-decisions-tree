package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

	private Scanner atributes;
    private Scanner values;

    public Parser() throws FileNotFoundException {
    	
        atributes = new Scanner(new File("_atributes.txt")); 
        values = new Scanner(new File("_values.txt")); 
    }

    public String[] read_atributes() { return atributes.nextLine().split(","); }

    public String[] read_values(){ return values.nextLine().split(","); }
    
    public boolean has_values(){ return values.hasNext(); }
}
