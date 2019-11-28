package model;

public class Value {

    private String name;
    private int positives;
    private int negatives;
    private int A;
    private Atribute atribute;

    public Value() {
    	
    	this.name = "";
        this.positives = 0;
        this.negatives = 0;
        this.A = 0;
        this.atribute = null;
    }

	public Value(String name) {
		
		this.name = name;
        this.positives = 0;
        this.negatives = 0;
        this.A = 0;
        this.atribute = null;
    }

    public double info_value() { 
    	
        double var1 = calculate_p();
        double var2 = calculate_n();
        double result = -var1 * log2(var1) - var2 * log2(var2);
        
        return result;
    }

    public double calculate_r(int N) { return this.A / N; }
    
    public boolean is_positive(){ return this.A==this.positives; }
    
    public boolean is_negative(){ return this.A==this.negatives; }
    
    public boolean is_final(){ return is_positive() || is_negative(); }
    

    public String get_name() { return this.name; }

    public int get_positives() { return this.positives; }
    
    public int get_negatives() { return this.negatives; }
    
    public int get_A() { return this.A; }
    
    public void A_plus() { this.A++; }
    
    public Atribute get_atribute() { return this.atribute; }
    
    
    public void set_name (String name) { this.name = name; }

    public void set_positives(int positives) { this.positives = positives; }

    public void set_negatives(int negatives) { this.negatives = negatives; }
    
    public void set_A(int A) { this.A = A; }

	public void set_atribute(Atribute atribute) { this.atribute = atribute; }
	
	
	private double log2(double d) { return Math.log(d) / Math.log(2); }

    private double calculate_p() {    
    	
        double pos = this.positives;
        double as = this.A; 
        
        return pos / as;
    }
    
    private double calculate_n() {
    	
        double neg = this.negatives;
        double as = this.A;
        
        return neg/as;
    }
}
