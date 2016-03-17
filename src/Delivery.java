import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delivery extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String host = "jdbc:mysql://localhost/restaurant";
	static final String USER = "root";		
	static final String PASS = "ylwwtqq";
	
	//private JPanel customerInfo;
	private JPanel toppanel,botpanel,leftpanel,rightpanel;
	private JPanel midpanel;
	private JLabel toptext;
	private JTextArea dishes, blank;
	private JButton checkBtn, addBtn, continueBtn, clearBtn, exitBtn;
	
	private JLabel phone, name, address, city, st, zip, total;
	private JTextField phoneText, nameText, addressText, cityText, stText, zipText, totalText;

	public Delivery(){
		initialize();
		checkBtn.addActionListener(new checkBtn());
		addBtn.addActionListener(new addBtn());
		continueBtn.addActionListener(new continueBtn());
	}
	
	private void initialize(){
		this.setBounds(100, 100, 800, 600);
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setResizable(false);
		this.setVisible(true);
		//----------------------------add main mid
		midpanel = new JPanel();
		midpanel.setBorder(BorderFactory.createTitledBorder("Customer Info"));
		//setLayout(new GridLayout(7,2));
		midpanel.setLayout(new FlowLayout());
		phone = new JLabel("Phone");
		phoneText = new JTextField(20);
		//phoneText.setBounds(10,10,30,170);
		name = new JLabel("Name");
		nameText = new JTextField(20);
		address = new JLabel("Address");
		addressText = new JTextField(30);
		city = new JLabel("City");
		cityText = new JTextField(10);
		st = new JLabel("State");
		stText = new JTextField(10);
		zip = new JLabel("ZIP");
		zipText = new JTextField(10);
		total = new JLabel("Total");
		totalText = new JTextField(20);
		midpanel.add(phone);
		midpanel.add(phoneText);
		midpanel.add(name);
		midpanel.add(nameText);
		midpanel.add(address);
		midpanel.add(addressText);
		midpanel.add(city);
		midpanel.add(cityText);
		midpanel.add(st);
		midpanel.add(stText);
		midpanel.add(zip);
		midpanel.add(zipText);
		midpanel.add(total);
		midpanel.add(totalText);
		
		this.add(midpanel,BorderLayout.CENTER);
		
		//add to left
		dishes = new JTextArea(10,10);
		dishes.setEditable(false);
		this.add(dishes, BorderLayout.WEST);
		blank = new JTextArea(10,10);
		blank.setEditable(false);
		this.add(blank, BorderLayout.EAST);
		//----------------------------add the top
		toppanel = new JPanel();
		toppanel.setBorder(BorderFactory.createTitledBorder("Please see"));
		toptext = new JLabel("Please enter the phone number to check if in the databse");
		toppanel.add(toptext);
		this.add(toppanel,BorderLayout.NORTH);
		//-----------------------------add bottom panel, and button
		botpanel = new JPanel();
		checkBtn = new JButton("Check customer");
		addBtn = new JButton("Add to list");
		continueBtn = new JButton("Continue");
		botpanel.add(checkBtn);
		botpanel.add(addBtn);
		botpanel.add(continueBtn);
		this.add(botpanel, BorderLayout.SOUTH);
		//--------------------------add to left
		

		
	}
	private class checkBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection conn = null;
			Statement stmt = null;
			try{
		      //STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(host,USER,PASS);
				stmt = conn.createStatement(); 
				ResultSet rs;
				String phone = phoneText.getText();
				String  searchSQL = "SELECT * FROM customer "
						+ "WHERE phone = '" + phone + "' ";
				rs = stmt.executeQuery(searchSQL);
				if(!rs.next()){
					System.out.println("The person is not in the customer list.");
					JOptionPane.showMessageDialog(null, "The customer is not in the list");
				}
				else{
					String name = rs.getString("name");
					String address = rs.getString("address");
					String city = rs.getString("city");
					String st = rs.getString("st");
					String zip = rs.getString("zip");
					nameText.setText(name);
					addressText.setText(address);
					cityText.setText(city);
					stText.setText(st);
					zipText.setText(zip);
				}
		      
				stmt.close();
				conn.close();
			}catch(SQLException se){
		      //Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception eee){
		      //Handle errors for Class.forName
				eee.printStackTrace();
			}finally{
		      //finally block used to close resources
				try{
					if(stmt!=null)
						stmt.close();
				}catch(SQLException se2){
					//do nothing
				}
		      try{
		    	  if(conn!=null)
		        	 conn.close();
		      } catch(SQLException se){
		    	  se.printStackTrace();
		      }//end finally try
		   }
			
		}
	}
	private class addBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection conn = null;
			Statement stmt = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(host,USER,PASS);
				stmt = conn.createStatement(); 
				ResultSet rs;
				String phone = phoneText.getText();
				String name = nameText.getText();
				String address = addressText.getText();
				String city = cityText.getText();
				String st = stText.getText();
				String zip = zipText.getText();
				
				String  addSQL = "INSERT INTO customer "
						+ "VALUES ('" + phone + "', '" + name + "', '"+ address + "', '"+ city + "', '"+ st + "', '" + zip + "')";
				stmt.executeUpdate(addSQL);
				JOptionPane.showMessageDialog(null, "The customer added to the list");
		      
				stmt.close();
				conn.close();
			}catch(SQLException se){
		      //Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception eee){
		      //Handle errors for Class.forName
				eee.printStackTrace();
			}finally{
		      //finally block used to close resources
				try{
					if(stmt!=null)
						stmt.close();
				}catch(SQLException se2){
					//do nothing
				}
		      try{
		    	  if(conn!=null)
		        	 conn.close();
		      } catch(SQLException se){
		    	  se.printStackTrace();
		      }//end finally try
		   }
			
		}
	}
	private class continueBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
				DishSelect delivery = new DishSelect("99");
			}
	}
}
