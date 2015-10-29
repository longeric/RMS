import java.awt.*;


import javax.swing.*;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class MainFrame extends JFrame{
	
	private TableNo fTableNo;
	
	
	private JButton btnDineIn, btnPickup, btnDelivery, btnModifyCheck;
	private JLabel lblRestaurantName;
	
	public MainFrame(){
		
		this.setBounds(100, 100, 800, 600);
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
		
		btnDineIn.addActionListener(new DineInBtn());
	}
	
	private class DineInBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fTableNo = new TableNo();
			
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
	}
	private void initialize(){
		this.setBounds(100, 100, 800, 600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setVisible(true);
		Title = new JLabel("Select table no in the section");
		//Title.setSize(600, 100);
		tableArea = new JPanel();		
		tableArea.setLayout(new GridLayout(5,4,30,40));
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
	}
	private class Table1btn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String id = table1.getText();
			dishSelect = new DishSelect(id);//contruct with id
		}		
	}

}
class DishSelect extends JFrame{
	private JLabel title;
	private JPanel leftPanel;
	private JTextField text1,text2,text5,text6;			//need more
	private JLabel text3,text4;
	private JTextField price1, price2, price3;		//need more
	
	private JPanel midPanel;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	
	public DishSelect(String id){
		initialize(id);
	}
	
	private void initialize(String id){
		this.setTitle("Please select your dishes");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setVisible(true);
		//set up the top border
		title = new JLabel(id);
		title.setBorder(BorderFactory.createTitledBorder("Welcome"));
		title.setFont(new   java.awt.Font("Dialog",1,25));   
		title.setForeground(Color.red);
		this.add(title, BorderLayout.NORTH);
		
		//set up the left, include text field of input*******************************
		leftPanel = new JPanel();
		leftPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		leftPanel.setLayout(new GridLayout(8,1));
		text1 = new JTextField("waht is thatqewrqwr");
		text1.setHorizontalAlignment(JTextField.RIGHT);
		text2 = new JTextField("asdqweqwrqr");
		text2.setHorizontalAlignment(JTextField.RIGHT);
		text3 = new JLabel("dsa");
		text3.setHorizontalAlignment(JTextField.RIGHT);
		text4 = new JLabel("qwe");
		text4.setHorizontalAlignment(JTextField.RIGHT);
		text5 = new JTextField("qyrerey");
		text5.setHorizontalAlignment(JTextField.RIGHT);
				
		leftPanel.add(text1);
		leftPanel.add(text2);
		leftPanel.add(text3);
		leftPanel.add(text4);
		leftPanel.add(text5);
		
		text1.setBounds(0,0,290,50);		//这一部分看起来没用,因为 gridlayout
		text2.setBounds(0,0,120,20);
		text3.setBounds(0,0,220,20);
		text4.setBounds(0,0,120,60);
		text5.setBounds(0,0,120,20);
		
		this.add(leftPanel, BorderLayout.WEST);
		
		//set up the middle, include the dishes class*************************
		midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(4,2,30,30));
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
		
		//set up bottom panel, include calculate price
		
	}
	
}
public class MainMenu {

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