import java.awt.*;
import java.net.*;
import java.util.Calendar;
import java.util.Date;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.*;

//import javax.print.*;
import java.awt.print.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.io.*;

public class Modify extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String host = "jdbc:mysql://localhost/restaurant";
	static final String USER = "root";		
	static final String PASS = "ylwwtqq";
	
	private JPanel north, center, south;
	private JLabel dateLabel, checkNoLabel, contentLabel, totalLabel, saleLabel;
	private JTextArea contentText;
	private JTextField dateText, checkNoText, totalText, saleText;
	private JButton showBtn, modifyBtn, checksaleBtn;
	
	public Modify(){
		initialize();
		showBtn.addActionListener(new showBtn());
		modifyBtn.addActionListener(new modifyBtn());
		checksaleBtn.addActionListener(new checksaleBtn());
	}
	
	private void initialize(){
		this.setBounds(100, 100, 800, 600);
		this.setSize(800,600);
		this.setResizable(false);
		this.setVisible(true);
		
		//******border layout-----------add to center
		this.setLayout(new BorderLayout());
		center = new JPanel();
		center.setBorder(BorderFactory.createTitledBorder("Customer Info"));
		dateLabel = new JLabel("Date:");
		dateText = new JTextField(10);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
		String dateStr = sdf.format(d);
		dateText.setText(dateStr);
		//dateText.setEditable(false);
		checkNoLabel = new JLabel("CheckNo:");
		checkNoText = new JTextField(10);
		//checkNoText.setEditable(false);
		contentLabel = new JLabel("Content:");
		contentText = new JTextArea(20,40);
		totalLabel = new JLabel("Total");
		totalText = new JTextField(20);
		saleLabel = new JLabel("Today's Sale");
		saleText = new JTextField(10);
		center.add(dateLabel);
		center.add(dateText);
		center.add(checkNoLabel);
		center.add(checkNoText);
		center.add(contentLabel);
		center.add(contentText);
		center.add(totalLabel);
		center.add(totalText);
		center.add(saleLabel);
		center.add(saleText);
		this.add(center, BorderLayout.CENTER);
		//**add to south
		south = new JPanel();
		showBtn = new JButton("Show today's business");
		//previousBtn = new JButton("Previous");
		//nextBtn = new JButton("Next");
		modifyBtn = new JButton("Modify check");
		checksaleBtn = new JButton("Check Sale");
		south.add(showBtn);
		//south.add(previousBtn);
		//south.add(nextBtn);
		south.add(modifyBtn);
		south.add(checksaleBtn);
		this.add(south, BorderLayout.SOUTH);
	}
	
	
	private class showBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection conn = null;
			Statement stmt = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(host,USER,PASS);
				stmt = conn.createStatement(); 
				ResultSet rs;
				//Date d = new Date();
				//SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
				//String dateStr = sdf.format(d);
				DecimalFormat dollar = new DecimalFormat("0.00");
				
				int a= Integer.parseInt(checkNoText.getText());
				String searchSQL = "SELECT * FROM history WHERE "
						+ "date = '" + dateText.getText() + "' AND checkNo = " + a;	
				
				//boolean isResult = stmt.execute(searchSQL);
				rs = stmt.executeQuery(searchSQL);
				while(rs.next()){
					int check = rs.getInt("checkNO");
					String content = rs.getString("content");
					float total = rs.getFloat("total");
					checkNoText.setText(""+check);
					contentText.setText(content);
					totalText.setText(""+dollar.format(total));
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
	/*
	private class nextBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection conn = null;
			Statement stmt = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(host,USER,PASS);
				stmt = conn.createStatement(); 
				ResultSet rs;
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
				String dateStr = sdf.format(d);
				DecimalFormat dollar = new DecimalFormat("0.00");
				
				dateText.setText(dateStr);
				String searchSQL = "SELECT * FROM history WHERE "
						+ "date = '" + dateStr + "' ";	
				
				boolean hasResult = stmt.execute(searchSQL);
				while(hasResult){
					rs = stmt.getResultSet();
					int check = rs.getInt("checkNO");
					String content = rs.getString("content");
					float total = rs.getFloat("total");
					checkNoText.setText(""+check);
					contentText.setText(content);
					totalText.setText(""+dollar.format(total));
					hasResult = stmt.getMoreResults();
				}
				//-------------
				rs = stmt.executeQuery(searchSQL);
				while(rs.next()){
					int check = rs.getInt("checkNO");
					String content = rs.getString("content");
					float total = rs.getFloat("total");
					checkNoText.setText(""+check);
					contentText.setText(content);
					totalText.setText(""+dollar.format(total));
				}
				//--------------
				

		      
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
	*/
	
	private class modifyBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection conn = null;
			Statement stmt = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(host,USER,PASS);
				stmt = conn.createStatement(); 
				ResultSet rs;
				
				String changeSQL = "UPDATE history "
						+ "SET content = '" + contentText.getText()
						+ "' WHERE date = '" + dateText.getText()
						+ "' AND checkNo = " + Integer.parseInt(checkNoText.getText());				
				
				stmt.executeUpdate(changeSQL);
				
				JOptionPane.showMessageDialog(null, "The check modified!");
		      
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
	
	private class checksaleBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection conn = null;
			Statement stmt = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(host,USER,PASS);
				stmt = conn.createStatement(); 
				ResultSet rs;
				//Date d = new Date();
				//SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
				//String dateStr = sdf.format(d);
				DecimalFormat dollar = new DecimalFormat("0.00");
				
				int a= Integer.parseInt(checkNoText.getText());
				String sumSQL = "SELECT SUM(total) AS sum FROM history";
				
				//boolean isResult = stmt.execute(searchSQL);
				rs = stmt.executeQuery(sumSQL);
				while(rs.next()){
					float sum = rs.getFloat("sum");
					saleText.setText(""+dollar.format(sum));
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
}
