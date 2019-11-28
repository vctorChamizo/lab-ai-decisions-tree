package view;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Atribute;
import model.ID3;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class View extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private ID3 id3;
	
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    public View() {
    	
        try { 
        	
        	this.id3 = new ID3(); 
        	
        	ArrayList<Atribute> lista = this.id3.get_atributes();
        	
        	ini_components();
            
            set_values(lista, jComboBox1, 0);
            set_values(lista, jComboBox2, 1);
            set_values(lista, jComboBox3, 2);
            set_values(lista, jComboBox4, 3);	
        }
        catch (FileNotFoundException e) {
        	
        	JOptionPane.showMessageDialog(null, "El fichero no se encuentra en la ruta definida.\nSitue el fichero en la ruta y vuelva a intentarlo.", "Fichero no econtrado", JOptionPane.WARNING_MESSAGE);
        	System.exit(0); 
        }
    }
    
    public String[] getLista(){
    	
    	String [] s = new String[4];
    	
    	s[0] = (String) jComboBox1.getSelectedItem();
    	s[1] = (String) jComboBox2.getSelectedItem();
    	s[2] = (String) jComboBox3.getSelectedItem();
    	s[3] = (String) jComboBox4.getSelectedItem();
    	
    	return s;
    }

    private void ini_components() {
    	
    	this.setTitle("Arbol de Decisiones (IDE3)");
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        
        jButton1 = new javax.swing.JButton();
        
        jLabel3.setText("Tiempo Exterior");
        jLabel4.setText("Temperatura");
        jLabel5.setText("Humedad");
        jLabel6.setText("Viento");
        jLabel7.setText("        ");
        
        jButton1.setText("Ejecutar");
        jButton1.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) { action_to_solution(evt);}});

        jComboBox1.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) { jComboBox1ActionPerformed(evt); }});
        jComboBox2.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) { jComboBox2ActionPerformed(evt); }});
        jComboBox4.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {jComboBox4ActionPerformed(evt); }});
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(Color.GREEN);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblNewLabel_1 = new JLabel("Ingenier\u00EDa del Conocimiento - \u00C1rbol de decisiones (ID3)");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(6)
        							.addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(32)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
        							.addGap(29))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(58)
        							.addComponent(jLabel7)))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(62)
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        					.addGap(65)))
        			.addGap(24))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(241)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(jLabel4)
        				.addComponent(jLabel6)
        				.addComponent(jLabel5))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(33)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(jLabel7)
        			.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }
    
    private void set_values(ArrayList<Atribute> lista, JComboBox<String> box, int n) {
    	
        ArrayList<String> nombres = lista.get(n).get_names();
        
        for(int i = 0; i < nombres.size(); i++) box.addItem(nombres.get(i));
    }

    private void action_to_solution(java.awt.event.ActionEvent evt) {
    	
    	if (this.id3.is_posible(this.getLista())) {
    		
    		this.lblNewLabel.setText("¡Sí! Es posible jugar.");
    		this.lblNewLabel.setForeground(Color.GREEN);
    	}
    	else {
    		
    		this.lblNewLabel.setText("No es posible jugar. Inténtalo en otra ocasión.");
    		this.lblNewLabel.setForeground(Color.RED);
    	}
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {}

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {}

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {}

}
