import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delivery extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String host = "jdbc:mysql://localhost/restaurant";
	//  Database credentials
	static final String USER = "root";			//user in my computer
	static final String PASS = "ylwwtqq";
	
	private JPanel customerInfo;
	private MidPanel midpanel;
	private class MidPanel extends JPanel{
		private JLabel phone, name, address, city, st, zip, total;
		private JTextField phoneText, nameText, addressText, cityText, stText, zipText, totalText;
		public MidPanel(){
			setBorder(BorderFactory.createTitledBorder("Customer Info"));
			setLayout(new GridLayout(7,2));
			phone = new JLabel("Phone");
			phoneText = new JTextField(11);
			phoneText.setBounds(10,10,30,170);
			name = new JLabel("Name");
			nameText = new JTextField(20);
			address = new JLabel("Address");
			addressText = new JTextField(30);
			city = new JLabel("City");
			cityText = new JTextField(20);
			st = new JLabel("State");
			stText = new JTextField(10);
			zip = new JLabel("ZIP");
			zipText = new JTextField(6);
			total = new JLabel("Total");
			totalText = new JTextField(10);
			add(phone);
			add(phoneText);
			add(name);
			add(nameText);
			add(address);
			//add blank
			add(city);
			add(cityText);
			add(st);
			add(stText);
			add(zip);
			add(zipText);
			add(total);
			add(totalText);
			
			
		}
		
	}
	public Delivery(){
		initialize();
		
		Connection conn = null;
		Statement stmt = null;
		try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(host,USER,PASS);
	      stmt = conn.createStatement(); 
	    
	      
	      
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }
	}
	
	private void initialize(){
		this.setBounds(100, 100, 800, 600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		//setResizable(false);
		this.setVisible(true);
		midpanel = new MidPanel();
		add(midpanel,BorderLayout.NORTH);
		//pack();
		
	}
}
