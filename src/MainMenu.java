import java.awt.*;
import java.net.*;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.*;

//import javax.print.*;
import java.awt.print.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.io.*;

class MainFrame extends JFrame{
	
	private TableNo fTableNo;
	private Delivery fDelivery;
	
	
	private JButton btnDineIn, btnPickup, btnDelivery, btnModifyCheck;
	private JLabel lblRestaurantName;
	
	public MainFrame(){
		initialize();		
		btnDineIn.addActionListener(new DineInBtn());
		btnDelivery.addActionListener(new DeliveryBtn());
		btnPickup.addActionListener(new PickupBtn());
	}
	private void initialize(){
		this.setBounds(100, 100, 800, 600);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		btnDineIn = new JButton("Dine In");		
		btnDineIn.setBounds(179, 145, 127, 43);
		add(btnDineIn);		
		btnPickup = new JButton("Pick up");
		btnPickup.setBounds(412, 145, 127, 43);
		add(btnPickup);		
		btnDelivery = new JButton("Delivery");
		btnDelivery.setBounds(179, 199, 127, 43);
		add(btnDelivery);		
		btnModifyCheck = new JButton("Modify Check");
		btnModifyCheck.setBounds(412, 199, 127, 43);
		add(btnModifyCheck);		
		lblRestaurantName = new JLabel("Welcome to XXX");
		lblRestaurantName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurantName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRestaurantName.setBounds(273, 77, 181, 35);
		add(lblRestaurantName);	
	}
	private class DineInBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fTableNo = new TableNo();
			
		}
	}
	private class PickupBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DishSelect pickup = new DishSelect("Pick Up");
			
		}
	}
	private class DeliveryBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fDelivery = new Delivery();
			
		}
	}
	
}
class TableNo extends JFrame{
	//define all swing class here
	private JLabel Title;
	private JPanel tableArea;
	private JButton table1, table2, table3, table4, table5;
	private JButton table11,table12,table13,table14,table15;
	private JButton table21, table22, table23, table24, table25;
	private DishSelect dishSelect;
	
	public TableNo(){
		initialize(); 
		table1.addActionListener(new Table1btn());
		table2.addActionListener(new Table2btn());
		table3.addActionListener(new Table3btn());
		table4.addActionListener(new Table4btn());
		table5.addActionListener(new Table5btn());
		table11.addActionListener(new Table11btn());
		table12.addActionListener(new Table12btn());
		table13.addActionListener(new Table13btn());
		table14.addActionListener(new Table14btn());
		table15.addActionListener(new Table15btn());
	}
	private void initialize(){
		this.setBounds(100, 100, 800, 600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		//this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setVisible(true);
		Title = new JLabel("Select table no in the section");
		//Title.setSize(600, 100);
		tableArea = new JPanel();		
		tableArea.setLayout(new GridLayout(5,4,20,30));
		tableArea.setBorder(BorderFactory.createTitledBorder("Table Area"));
		this.add(Title,BorderLayout.NORTH);
		this.add(tableArea,BorderLayout.CENTER);
		table1 = new JButton("table1");
		table2 = new JButton("table2");
		table3 = new JButton("table3");
		table4 = new JButton("table4");
		table5 = new JButton("table5");		
		table11 = new JButton("table11");
		table12 = new JButton("table12");
		table13 = new JButton("table13");
		table14 = new JButton("table14");
		table15 = new JButton("table15");		
		tableArea.add(table1);
		tableArea.add(table2);
		tableArea.add(table3);
		tableArea.add(table4);
		tableArea.add(table5);
		tableArea.add(table11);
		tableArea.add(table12);
		tableArea.add(table13);
		tableArea.add(table14);
		tableArea.add(table15);	
		//pack();
	}

	private class Table1btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table1.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table2btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table2.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table3btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table3.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table4btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table4.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table5btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table5.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table11btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table11.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table12btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table12.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table13btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table13.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table14btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table14.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}
	private class Table15btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table15.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}

}
class DishSelect extends JFrame implements Printable{
	private JLabel title;
	private JPanel leftPanel;
	private JPanel[] cardpanel;
	private CardLayout card; 
	private JButton lunch5, lunch1, lunch2, lunch3, lunch4;
	private JButton seafood1, seafood2,seafood3,seafood4; // text1,text2,text5,text6,text7,text8,text9,text10;			//need more
	private JButton beef1, beef2, beef3, beef4;
	private JButton chicken1, chicken2, chicken3, chicken4;
	private JButton noodle1, noodle2, noodle3, noodle4;
	private JButton sushi1, sushi2, sushi3, sushi4;
	private JButton soup1, soup2, soup3, soup4;
	private JButton wine1, wine2, wine3, wine4;
	private static double subtotal = 0.0;
	private JTextField price1, price2, price3;		//need more
	//middle panel, actually is the left
	private JPanel midPanel;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	//dishpanel, aapear in the middle
	private JPanel dishPanel;
	private JLabel picLabel;
	private JTextArea dishText;
	private ImageIcon background;
	//bottom panel, all button
	private JPanel eventPanel;
	private JButton sendBtn, deleteBtn, clearBtn, exitBtn;
	
	public DishSelect(String id){
		initialize(id);
		exitBtn.addActionListener(new exitBtn());
		sendBtn.addActionListener(new sendBtn());
		btn1.addActionListener(new ClassBtn());
		btn2.addActionListener(new ClassBtn());
		btn3.addActionListener(new ClassBtn());
		btn4.addActionListener(new ClassBtn());
		btn5.addActionListener(new ClassBtn());
		btn6.addActionListener(new ClassBtn());
		btn7.addActionListener(new ClassBtn());
		btn8.addActionListener(new ClassBtn());
		lunch1.addActionListener(new ChooseBtn());
		lunch2.addActionListener(new ChooseBtn());
	}
	
	private void initialize(String id){
		this.setTitle("Please select your dishes");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setResizable(false);
		this.setVisible(true);
		//set up the top border
		title = new JLabel(id);
		title.setBorder(BorderFactory.createTitledBorder("Welcome"));
		title.setFont(new   java.awt.Font("Dialog",1,25));   
		title.setForeground(Color.red);
		this.add(title, BorderLayout.NORTH);
		
		//set up the left, include text field of input********************************************************
		leftPanel = new JPanel();
		leftPanel.setBorder(BorderFactory.createTitledBorder("Your Choice"));
		card = new CardLayout();
		leftPanel.setLayout(card);
		//JPanel seafoodpanel = new JPanel();
		JPanel cardpanel[] = new JPanel[8];
		for(int i=0;i<8;i++){
			cardpanel[i] = new JPanel();
			cardpanel[i].setLayout(new GridLayout(4,2));
		}
		lunch1 = new JButton();lunch2 = new JButton();lunch3 = new JButton();lunch4 = new JButton();
		seafood1 = new JButton();seafood2 = new JButton();seafood3 = new JButton();seafood4 = new JButton();
		beef1 = new JButton(); beef2 = new JButton(); beef3 = new JButton(); beef4 = new JButton();
		chicken1 = new JButton(); chicken2 = new JButton(); chicken3 = new JButton(); chicken4 = new JButton();
		noodle1 = new JButton(); noodle2 = new JButton(); noodle3 = new JButton(); noodle4 = new JButton();
		sushi1 = new JButton(); sushi2 = new JButton(); sushi3 = new JButton(); sushi4 = new JButton();
		soup1 = new JButton(); soup2 = new JButton(); soup3 = new JButton(); soup4 = new JButton();		
		wine1 = new JButton(); wine2 = new JButton(); wine3 = new JButton(); wine4 = new JButton();
		lunch1 = new JButton("Banana Bread French Toast -- $7.95");	//define lunch button 
		lunch2 = new JButton("Rosted Turkey -- $9.95");
		lunch3 = new JButton("Pumplin waffle -- $8.95");
		lunch4 = new JButton("Southwestern Club -- $6.95");
		cardpanel[0].add(lunch1);										//add lunch button
		cardpanel[0].add(lunch2);
		cardpanel[0].add(lunch3);
		cardpanel[0].add(lunch4);	
		
		seafood1 = new JButton("crab -- $11.95");						//define seafood button
		ImageIcon  sea1 = new ImageIcon("icon/seafood1.jpg");
		seafood1.setIcon(sea1);
		seafood2 = new JButton("Scallop -- $12.95");
		ImageIcon  scallop = new ImageIcon("icon/scallop.jpg");
		seafood2.setIcon(scallop);
		seafood3 = new JButton("Salmon -- $15.95");
		//ImageIcon salmon = new ImageIcon("icon/salmon.jpg");
		seafood4 = new JButton("Combo -- $ 18.95");		
		cardpanel[1].add(seafood1);									//add seafood button
		cardpanel[1].add(seafood2);
		cardpanel[1].add(seafood3);
		cardpanel[1].add(seafood4);
		
		beef1 = new JButton("Jello with fruit -- $13.95");			//define beef button
		beef2 = new JButton("Beef with broccoli -- $12.95");
		beef3 = new JButton("Filet Steak -- $16.95");
		beef4 = new JButton("Beef Sirloin -- $14.95");
		cardpanel[2].add(beef1);										//add beef button
		cardpanel[2].add(beef2);
		cardpanel[2].add(beef3);
		cardpanel[2].add(beef4);
		
		chicken1 = new JButton("Bufflo Chicken -- $10.45");			//define chicken button
		chicken2 = new JButton("Buttermilk Chicken -- $11.95");
		chicken3 = new JButton("Chicken sandwich -- $9.95");
		chicken4 = new JButton("Chicken salad combo-- $12.95");
		cardpanel[3].add(chicken1);									//add chicken button
		cardpanel[3].add(chicken2);
		cardpanel[3].add(chicken3);
		cardpanel[3].add(chicken4);
		
		noodle1 = new JButton("Penne Rosa -- $12.45");				//define noodle button
		noodle2 = new JButton("Japanese Pan Noodles -- $14.95");
		noodle3 = new JButton("MacCheese Pad -- $13.95");
		noodle4 = new JButton("Whole Grain Fresca -- $15.95");
		cardpanel[4].add(noodle1);									//add noodle button
		cardpanel[4].add(noodle2);
		cardpanel[4].add(noodle3);
		cardpanel[4].add(noodle4);
		
		sushi1 = new JButton("California Roll -- $6.45");				//define sushi button
		sushi2 = new JButton("Spicy Tuna Roll -- $6.95");
		sushi3 = new JButton("Amazing Roll -- $7.95");
		sushi4 = new JButton("Turando Roll -- $8.95");
		cardpanel[5].add(sushi1);										//add sushi button
		cardpanel[5].add(sushi2);
		cardpanel[5].add(sushi3);
		cardpanel[5].add(sushi4);
		
		soup1 = new JButton("Hot & Sour Soup -- $2.45");				//define soup button
		soup2 = new JButton("Creme Chicken Soup -- $5.95");
		soup3 = new JButton("Turkey Chill Soup -- $4.95");
		soup4 = new JButton("Broccoli Cheddar Soup -- $3.95");
		cardpanel[6].add(soup1);										//add soup button
		cardpanel[6].add(soup2);
		cardpanel[6].add(soup3);
		cardpanel[6].add(soup4);
		
		wine1 = new JButton("Plum Wine -- $6.45");					//define wine button
		wine2 = new JButton("Merlot -- $5.95");
		wine3 = new JButton("Chardonnay -- $7.95");
		wine4 = new JButton("Whisky -- $4.95");
		cardpanel[7].add(wine1);										//add wine button
		cardpanel[7].add(wine2);
		cardpanel[7].add(wine3);
		cardpanel[7].add(wine4);
		
		leftPanel.add("lunch",cardpanel[0]);				//add to the leftpanel
		leftPanel.add("seafood",cardpanel[1]);		
		leftPanel.add("beef", cardpanel[2]);
		leftPanel.add("chicken",cardpanel[3]);
		leftPanel.add("noodle",cardpanel[4]);
		leftPanel.add("sushi",cardpanel[5]);		
		leftPanel.add("soup", cardpanel[6]);
		leftPanel.add("wine",cardpanel[7]);
		
		card.show(leftPanel, "lunch");
		//card.first(leftPanel);

		this.add(leftPanel,BorderLayout.WEST);
		
		//set up the middle(right), include the dishes class**********************************************************
		midPanel = new JPanel();
		midPanel.setBorder(BorderFactory.createTitledBorder("Dish Class"));
		midPanel.setLayout(new GridLayout(8,1));
		btn1 = new JButton("Lunch Special");
		btn2 = new JButton("Seafood");
		btn3 = new JButton("Beef");
		btn4 = new JButton("Chicken");
		btn5 = new JButton("Noodle");
		btn6 = new JButton("Suchi & Habachi");
		btn7 = new JButton("Soup");
		btn8 = new JButton("Wine");
		
		midPanel.add(btn1);
		midPanel.add(btn2);
		midPanel.add(btn3);
		midPanel.add(btn4);
		midPanel.add(btn5);
		midPanel.add(btn6);
		midPanel.add(btn7);
		midPanel.add(btn8);
		
		this.add(midPanel,BorderLayout.EAST);
		
		//set up mid/right panel, include calculate price
		//background = new ImageIcon("Seafood.jpg");
		dishPanel = new JPanel();
		dishText = new JTextArea(20,20);
		dishPanel.add(dishText);
		//picLabel = new JLabel(background);
		//this.add(picLabel,BorderLayout.CENTER);
		this.add(dishPanel,BorderLayout.CENTER);
		
		//set up the bottom panel
		eventPanel = new JPanel();
		eventPanel.setLayout(new FlowLayout());
		sendBtn = new JButton("Send to Kitchen");
		deleteBtn = new JButton("Delete item");
		clearBtn = new JButton("clear");
		exitBtn = new JButton("Exit");
		
		eventPanel.add(sendBtn);
		eventPanel.add(deleteBtn);
		eventPanel.add(clearBtn);
		eventPanel.add(exitBtn);
		//pack();
		this.add(eventPanel,BorderLayout.SOUTH);
	}
	
	private class ChooseBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == lunch1){
				subtotal = subtotal + 7.95;
				dishText.append("Banana Bread French Toast -- $7.95\n");
			}
			else if(e.getSource() == lunch2){
				subtotal = subtotal + 4.5;
				dishText.append("Another\n");
			}
		}		
	}
	private class ClassBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btn1)
				card.show(leftPanel, "lunch");
			else if(e.getSource() == btn2)
				card.show(leftPanel, "seafood");
			else if(e.getSource() == btn3)
				card.show(leftPanel, "beef");
			else if(e.getSource() == btn4)
				card.show(leftPanel, "chicken");
			else if(e.getSource() == btn5)
				card.show(leftPanel, "noodle");
			else if(e.getSource() == btn6)
				card.show(leftPanel, "sushi");
			else if(e.getSource() == btn7)
				card.show(leftPanel, "soup");
			else if(e.getSource() == btn8)
				card.show(leftPanel, "wine");
		}		
	}
	
	private class sendBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//add a communication to a print, need socket
			PrintService[] service = PrintServiceLookup.lookupPrintServices(null, null);
			
			//****************
			PrinterJob job = PrinterJob.getPrinterJob();
			boolean doPrint = job.printDialog();
			if (doPrint) {
			    try {
			        job.print();
			    } catch (PrinterException pe) {
			    	pe.printStackTrace();
			        // The job did not successfully
			        // complete
			    }
			}
		}		
	}private class deleteBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//delete last item
		}
	}
	private class clearBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			subtotal = 0;
			//clean all JTextArea
		}		
	}
	private class exitBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dispose();
		}		
	}
	@Override
	public int print(Graphics gp, PageFormat pf, int page)
			throws PrinterException {
		 // We have only one page, and 'page'
	    // is zero-based
	    if (page > 0) {
	         return NO_SUCH_PAGE;
	    }
	    System.out.println("Now print something");
	    // User (0,0) is typically outside the
	    // imageable area, so we must translate
	    // by the X and Y values in the PageFormat
	    // to avoid clipping.
	    Graphics2D g2d = (Graphics2D)gp;
	    g2d.setColor(Color.black);
	    g2d.translate(pf.getImageableX(), pf.getImageableY());

	    // Now we perform our rendering
	    gp.drawString("Hello world!", 100, 100);

	    // tell the caller that this page is part
	    // of the printed document
	    return PAGE_EXISTS;
	}
	
}
public class MainMenu {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String host = "jdbc:mysql://localhost/";
	//  Database credentials
	static final String USER = "root";			//user in my computer
	static final String PASS = "ylwwtqq";
	
	public MainFrame mainFrame;	//private JFrame frame;
	//public TableNo fTableNo; 	//private JFrame fTableNo;
	//public JFrame fDishChoose;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					//window.mainFrame.setVisible(true); //window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
		Connection conn = null;
		Statement stmt = null;
		String createDatabase;
		try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(host,USER,PASS);
	      stmt = conn.createStatement(); 
	      
	      createDatabase = "CREATE DATABASE restaurant";
	      stmt.executeUpdate(createDatabase);
	      System.out.println("The database restaurant created.");
	      
	      
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
		   if(se.getErrorCode() == 1007)
			   System.out.println(se.getMessage());
		   else
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new MainFrame();
		//mainFrame.setVisible(true);
		/*
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnDineIn = new JButton("Dine In");
		btnDineIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame fDineIn = new JFrame();
				fDineIn.setSize(400,300);
				fDineIn.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnDineIn.setBounds(179, 145, 127, 43);
		frame.getContentPane().add(btnDineIn);
		
		JButton btnPickup = new JButton("Pick up");
		btnPickup.setBounds(412, 145, 127, 43);
		frame.getContentPane().add(btnPickup);
		
		JButton btnDelivery = new JButton("Delivery");
		btnDelivery.setBounds(179, 199, 127, 43);
		frame.getContentPane().add(btnDelivery);
		
		JButton btnModifyCheck = new JButton("Modify Check");
		btnModifyCheck.setBounds(412, 199, 127, 43);
		frame.getContentPane().add(btnModifyCheck);
		
		JLabel lblRestaurantName = new JLabel("Restaurant name");
		lblRestaurantName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurantName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRestaurantName.setBounds(273, 77, 181, 35);
		frame.getContentPane().add(lblRestaurantName);
		*/
		
	}
}