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

class MainFrame extends JFrame{
	
	private TableNo fTableNo;
	private Delivery fDelivery;
	private JPanel main;
	
	private JButton btnDineIn, btnPickup, btnDelivery, btnModifyCheck;
	private JLabel lblRestaurantName;
	
	public MainFrame(){
		initialize();		
		btnDineIn.addActionListener(new DineInBtn());
		btnDelivery.addActionListener(new DeliveryBtn());
		btnPickup.addActionListener(new PickupBtn());
		btnModifyCheck.addActionListener(new ModifyBtn());
	}
	private void initialize(){
		this.setBounds(100, 100, 800, 600);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		//ImageIcon bgimage = new ImageIcon("icon.background.jpg");
		//this.drawImage
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
			DishSelect pickup = new DishSelect("00");
			
		}
	}
	private class DeliveryBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fDelivery = new Delivery();
			
		}
	}
	private class ModifyBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new Modify();
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
		table1 = new JButton("1");
		table2 = new JButton("2");
		table3 = new JButton("3");
		table4 = new JButton("4");
		table5 = new JButton("5");		
		table11 = new JButton("11");
		table12 = new JButton("12");
		table13 = new JButton("13");
		table14 = new JButton("14");
		table15 = new JButton("15");		
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
	/*public void paintComponent(Graphics g){
		int x=0,y=0;
		java.net.URL imgURL=getClass().getResource("icon/background.jpg");
	 
		ImageIcon icon=new ImageIcon(imgURL);
		g.drawImage(icon.getImage(),x,y,getSize().width,getSize().height,this);
		while(true){
			g.drawImage(icon.getImage(),x,y,this);
		    if(x>getSize().width && y>getSize().height)
		    	break;
		           //这段代码是为了保证在窗口大于图片时，图片仍能覆盖整个窗口
		     if(x>getSize().width){
		    	 x=0;
		    	 y+=icon.getIconHeight();
		     }
		     else
		    	 x+=icon.getIconWidth();
		}
	}*/
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
	private JButton lunch1, lunch2, lunch3, lunch4;
	private JButton seafood1, seafood2,seafood3,seafood4; // text1,text2,text5,text6,text7,text8,text9,text10;			//need more
	private JButton beef1, beef2, beef3, beef4;
	private JButton chicken1, chicken2, chicken3, chicken4;
	private JButton noodle1, noodle2, noodle3, noodle4;
	private JButton sushi1, sushi2, sushi3, sushi4;
	private JButton soup1, soup2, soup3, soup4;
	private JButton wine1, wine2, wine3, wine4;
	private static double subtotal = 0.0;
	//middle panel, actually is the left
	private JPanel midPanel;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	//dishpanel, aapear in the middle
	private JPanel dishPanel;
	private JTextArea dishText;
	//bottom panel, all button
	private JPanel eventPanel;
	private JButton calculateBtn, sendBtn, clearBtn, closeBtn, exitBtn;
	private int tableNumber;
	private static boolean[] ifClose = new boolean[100];
	private static int checkNo = 0;
	public String dishContent;
	
	public DishSelect(String id){
		initialize(id);
		//tableNumber = Integer.parseInt(id);
		//ifClose[tableNumber] = false;
				
		//exitBtn.addActionListener(new exitBtn());
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
		lunch3.addActionListener(new ChooseBtn());
		lunch4.addActionListener(new ChooseBtn());
		seafood1.addActionListener(new ChooseBtn());
		seafood2.addActionListener(new ChooseBtn());
		seafood3.addActionListener(new ChooseBtn());
		seafood4.addActionListener(new ChooseBtn());
		beef1.addActionListener(new ChooseBtn());
		beef2.addActionListener(new ChooseBtn());
		beef3.addActionListener(new ChooseBtn());
		beef4.addActionListener(new ChooseBtn());
		chicken1.addActionListener(new ChooseBtn());
		chicken2.addActionListener(new ChooseBtn());
		chicken3.addActionListener(new ChooseBtn());
		chicken4.addActionListener(new ChooseBtn());
		noodle1.addActionListener(new ChooseBtn());
		noodle2.addActionListener(new ChooseBtn());
		noodle3.addActionListener(new ChooseBtn());
		noodle4.addActionListener(new ChooseBtn());
		sushi1.addActionListener(new ChooseBtn());
		sushi2.addActionListener(new ChooseBtn());
		sushi3.addActionListener(new ChooseBtn());
		sushi4.addActionListener(new ChooseBtn());
		soup1.addActionListener(new ChooseBtn());
		soup2.addActionListener(new ChooseBtn());
		soup3.addActionListener(new ChooseBtn());
		soup4.addActionListener(new ChooseBtn());
		wine1.addActionListener(new ChooseBtn());
		wine2.addActionListener(new ChooseBtn());
		wine3.addActionListener(new ChooseBtn());
		wine4.addActionListener(new ChooseBtn());
		
		calculateBtn.addActionListener(new calculateBtn());
		closeBtn.addActionListener(new closeBtn());
		clearBtn.addActionListener(new clearBtn());
	}
	
	private void initialize(String id){
		checkNo = checkNo + 1;
		this.setTitle("Please select your dishes");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setResizable(false);
		this.setVisible(true);
		//set up the top border
		title = new JLabel("Table "+id);
		title.setBorder(BorderFactory.createTitledBorder("Welcome to XXX restaurant"));
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
		ImageIcon lun1 = new ImageIcon("icon/banana-bread.jpg");
		lunch1.setIcon(lun1);
		lunch2 = new JButton("Rosted Turkey -- $9.95");
		ImageIcon lun2 = new ImageIcon("icon/roasted-turkey.jpeg");
		lunch2.setIcon(lun2);
		lunch3 = new JButton("Pumplin waffle -- $8.95");
		ImageIcon lun3 = new ImageIcon("icon/pumpkin-waffles.jpg");
		lunch3.setIcon(lun3);
		lunch4 = new JButton("Southwestern Club -- $6.95");
		ImageIcon lun4 = new ImageIcon("icon/southwestern-club.jpg");
		lunch4.setIcon(lun4);
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
		ImageIcon sea3 = new ImageIcon("icon/salmon.jpg");
		seafood3.setIcon(sea3);
		seafood4 = new JButton("Combo -- $ 18.95");	
		ImageIcon sea4 = new ImageIcon("icon/combo-seafood.jpg");
		seafood4.setIcon(sea4);
		cardpanel[1].add(seafood1);									//add seafood button
		cardpanel[1].add(seafood2);
		cardpanel[1].add(seafood3);
		cardpanel[1].add(seafood4);
		
		beef1 = new JButton("Jello with fruit -- $13.95");			//define beef button
		ImageIcon bee1 = new ImageIcon("icon/jello-beef.jpeg");
		beef1.setIcon(bee1);
		beef2 = new JButton("Beef with broccoli -- $12.95");
		ImageIcon bee2 = new ImageIcon("icon/beef-broccoli.jpg");
		beef2.setIcon(bee2);
		beef3 = new JButton("Filet Steak -- $16.95");
		ImageIcon bee3 = new ImageIcon("icon/filet-steak.jpg");
		beef3.setIcon(bee3);
		beef4 = new JButton("Beef Sirloin -- $14.95");
		ImageIcon bee4 = new ImageIcon("icon/beef-sirloin.jpg");
		beef4.setIcon(bee4);
		cardpanel[2].add(beef1);										//add beef button
		cardpanel[2].add(beef2);
		cardpanel[2].add(beef3);
		cardpanel[2].add(beef4);
		
		chicken1 = new JButton("Bufflo Chicken -- $10.45");			//define chicken button
		ImageIcon chick1 = new ImageIcon("icon/bufflo-chicken.jpg");
		chicken1.setIcon(chick1);
		chicken2 = new JButton("Buttermilk Chicken -- $11.95");
		ImageIcon chick2 = new ImageIcon("icon/buttermilk-chicken.jpg");
		chicken2.setIcon(chick2);
		chicken3 = new JButton("Chicken sandwich -- $9.95");
		ImageIcon chick3 = new ImageIcon("icon/chicken-sandwich.jpg");
		chicken3.setIcon(chick3);
		chicken4 = new JButton("Chicken salad combo-- $12.95");
		ImageIcon chick4 = new ImageIcon("icon/chicken-salad.jpg");
		chicken4.setIcon(chick4);
		cardpanel[3].add(chicken1);									//add chicken button
		cardpanel[3].add(chicken2);
		cardpanel[3].add(chicken3);
		cardpanel[3].add(chicken4);
		
		noodle1 = new JButton("Penne Rosa -- $12.45");				//define noodle button
		ImageIcon nood1 = new ImageIcon("icon/penne-rosa.jpg");
		noodle1.setIcon(nood1);
		noodle2 = new JButton("Japanese Pan Noodles -- $14.95");
		ImageIcon nood2 = new ImageIcon("icon/japanese-noodle.jpg");
		noodle2.setIcon(nood2);
		noodle3 = new JButton("MacCheese Pad -- $13.95");
		ImageIcon nood3 = new ImageIcon("icon/maccheese-pad.jpg");
		noodle3.setIcon(nood3);
		noodle4 = new JButton("Whole Grain Fresca -- $15.95");
		ImageIcon nood4 = new ImageIcon("icon/whole-fresca.jpg");
		noodle4.setIcon(nood4);
		cardpanel[4].add(noodle1);									//add noodle button
		cardpanel[4].add(noodle2);
		cardpanel[4].add(noodle3);
		cardpanel[4].add(noodle4);
		
		sushi1 = new JButton("California Roll -- $6.45");				//define sushi button
		ImageIcon sush1 = new ImageIcon("icon/california-roll.jpg");
		sushi1.setIcon(sush1);
		sushi2 = new JButton("Spicy Tuna Roll -- $6.95");
		ImageIcon sush2 = new ImageIcon("icon/spicy-tuna.jpg");
		sushi2.setIcon(sush2);
		sushi3 = new JButton("Amazing Roll -- $7.95");
		ImageIcon sush3 = new ImageIcon("icon/amazing-roll.jpg");
		sushi3.setIcon(sush3);
		sushi4 = new JButton("Turando Roll -- $8.95");
		ImageIcon sush4 = new ImageIcon("icon/turnado-roll.jpg");
		sushi4.setIcon(sush4);
		cardpanel[5].add(sushi1);										//add sushi button
		cardpanel[5].add(sushi2);
		cardpanel[5].add(sushi3);
		cardpanel[5].add(sushi4);
		
		soup1 = new JButton("Hot & Sour Soup -- $2.45");				//define soup button
		ImageIcon sou1 = new ImageIcon("icon/hot-and-sour-soup.jpg");
		soup1.setIcon(sou1);
		soup2 = new JButton("Creme Chicken Soup -- $5.95");
		ImageIcon sou2 = new ImageIcon("icon/creamchickensoup.jpeg");
		soup2.setIcon(sou2);
		soup3 = new JButton("Turkey Chill Soup -- $4.95");
		ImageIcon sou3 = new ImageIcon("icon/turkey-chill-soup.jpg");
		soup3.setIcon(sou3);
		soup4 = new JButton("Broccoli Cheddar Soup -- $3.95");
		ImageIcon sou4 = new ImageIcon("icon/broccoli-cheddar.jpg");
		soup4.setIcon(sou4);
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
		dishText.setSize(40,60);
		//dishPanel.add(dishText);
		//picLabel = new JLabel(background);
		//this.add(picLabel,BorderLayout.CENTER);
		this.add(dishText,BorderLayout.CENTER);
		
		//set up the bottom panel
		eventPanel = new JPanel();
		eventPanel.setLayout(new FlowLayout());
		sendBtn = new JButton("Send Kitchen");
		closeBtn = new JButton("Close check");
		clearBtn = new JButton("clear & Exit");
		//exitBtn = new JButton("Exit");
		calculateBtn = new JButton("Calculate");
		eventPanel.add(calculateBtn);
		eventPanel.add(sendBtn);
		eventPanel.add(closeBtn);
		eventPanel.add(clearBtn);
		//eventPanel.add(exitBtn);
		//pack();
		this.add(eventPanel,BorderLayout.SOUTH);
	}
	private String getContent(){
		return dishText.getText();
	}
	
	private class ChooseBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == lunch1){
				subtotal = subtotal + 7.95;
				dishText.append("Banana Bread French Toast -- $7.95\n");
			}
			else if(e.getSource() == lunch2){
				subtotal = subtotal + 9.95;
				dishText.append("Rosted Tuekry -- $9.95\n");
			}
			else if(e.getSource() == lunch3){
				subtotal = subtotal + 8.95;
				dishText.append("Pumpklin waffle -- $8.95\n");
			}
			else if(e.getSource() == lunch4){
				subtotal = subtotal + 6.95;
				dishText.append("Southwestern Club -- $6.95\n");
			}
			else if(e.getSource() == seafood1){
				subtotal = subtotal + 11.95;
				dishText.append("Crab -- $11.95\n");
			}
			else if(e.getSource() == seafood2){
				subtotal = subtotal + 12.95;
				dishText.append("Scallop -- $12.95\n");
			}
			else if(e.getSource() == seafood3){
				subtotal = subtotal + 15.95;
				dishText.append("Salmon -- $15.95\n");
			}
			else if(e.getSource() == seafood4){
				subtotal = subtotal + 18.95;
				dishText.append("Combo -- $18.95\n");
			}
			else if(e.getSource() == beef1){
				subtotal = subtotal + 13.95;
				dishText.append("Jello with fruit -- $13.95\n");
			}
			else if(e.getSource() == beef2){
				subtotal = subtotal + 12.95;
				dishText.append("Beef with broccoli -- $12.95\n");
			}
			else if(e.getSource() == beef3){
				subtotal = subtotal + 16.95;
				dishText.append("Filet Steak -- $16.95\n");
			}
			else if(e.getSource() == beef4){
				subtotal = subtotal + 14.95;
				dishText.append("Beef Sirloin -- $14.95\n");
			}
			else if(e.getSource() == chicken1){
				subtotal = subtotal + 10.45;
				dishText.append("Bufflo Chicken -- $10.45\n");
			}
			else if(e.getSource() == chicken2){
				subtotal = subtotal + 11.95;
				dishText.append("Buttermilk Chicken -- $11.95\n");
			}
			else if(e.getSource() == chicken3){
				subtotal = subtotal + 9.95;
				dishText.append("Chicken sandwich -- $9.95\n");
			}
			else if(e.getSource() == chicken4){
				subtotal = subtotal + 12.95;
				dishText.append("Chicken salad combo -- $12.95\n");
			}
			else if(e.getSource() == noodle1){
				subtotal = subtotal + 12.45;
				dishText.append("Penna Rosa -- $12.45\n");
			}
			else if(e.getSource() == noodle2){
				subtotal = subtotal + 14.95;
				dishText.append("Japanese Pan Noodles -- $14.95\n");
			}
			else if(e.getSource() == noodle3){
				subtotal = subtotal + 13.95;
				dishText.append("MacCheese Pad -- $13.95\n");
			}
			else if(e.getSource() == noodle4){
				subtotal = subtotal + 15.95;
				dishText.append("Whole Grain Fresca -- $15.95\n");
			}
			else if(e.getSource() == sushi1){
				subtotal = subtotal + 6.45;
				dishText.append("California Roll -- $6.45\n");
			}
			else if(e.getSource() == sushi2){
				subtotal = subtotal + 6.95;
				dishText.append("Spicy Tuna Roll -- $6.95\n");
			}
			else if(e.getSource() == sushi3){
				subtotal = subtotal + 7.95;
				dishText.append("Amazing Roll -- $7.95\n");
			}
			else if(e.getSource() == sushi4){
				subtotal = subtotal + 8.95;
				dishText.append("Turnado Roll -- $8.95\n");
			}
			else if(e.getSource() == soup1){
				subtotal = subtotal + 2.45;
				dishText.append("Hot&Sour soup -- $2.45\n");
			}
			else if(e.getSource() == soup2){
				subtotal = subtotal + 5.95;
				dishText.append("Creme Chicken Soup -- $5.95\n");
			}
			else if(e.getSource() == soup3){
				subtotal = subtotal + 4.95;
				dishText.append("Turkey Chill Soup -- $4.95\n");
			}
			else if(e.getSource() == soup4){
				subtotal = subtotal + 3.95;
				dishText.append("Broccoli Cheddar Soup -- $3.95\n");
			}
			else if(e.getSource() == wine1){
				subtotal = subtotal + 6.45;
				dishText.append("Plum Wine -- $6.45\n");
			}
			else if(e.getSource() == wine2){
				subtotal = subtotal + 5.95;
				dishText.append("Merlot -- $5.95\n");
			}
			else if(e.getSource() == wine3){
				subtotal = subtotal + 7.95;
				dishText.append("Chardonnay -- $7.95\n");
			}
			else if(e.getSource() == wine4){
				subtotal = subtotal + 4.95;
				dishText.append("Whisky -- $4.95\n");
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
	private class calculateBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DecimalFormat dollar = new DecimalFormat("0.00");
			dishText.append("************************************");
			dishText.append("\nSubtotal: "+ String.valueOf(dollar.format(subtotal))+"\nTotal: "+ String.valueOf(dollar.format(subtotal*1.07)));
			dishText.append("\n-----------------------------------\n");
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
	}
	
	private class closeBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//ifClose[tableNumber] = true;
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
			String dateStr = sdf.format(d);
			
			Connection conn = null;
			Statement stmt = null;
			try{
			      Class.forName("com.mysql.jdbc.Driver");
			      conn = DriverManager.getConnection("jdbc:mysql://localhost/restaurant","root","ylwwtqq");
			      stmt = conn.createStatement(); 
			      String insert = "INSERT INTO history "
					+ "VALUES ( '" + dateStr + "', " + checkNo + ", '" + dishText.getText() + "', " + subtotal*1.07 + ")";
			      stmt.executeUpdate(insert);
			      JOptionPane.showMessageDialog(null, "Check succesfully added.");
			      
			      stmt.close();
			      conn.close();
			}catch(SQLException se){
				if(se.getErrorCode() == 1007)
					System.out.println(se.getMessage());
				else
		      //Handle errors for JDBC
					se.printStackTrace();
		   }catch(Exception ee){
		      //Handle errors for Class.forName
			   ee.printStackTrace();
		   }finally{
		      //finally block used to close resources
			   try{
				   if(stmt!=null)
					   stmt.close();
			   }catch(SQLException se2){
			   }
			   try{
				   if(conn!=null)
					   conn.close();
			   }catch(SQLException se){
				   se.printStackTrace();
			   }//end finally try
		   }
		}
		
	}
	private class clearBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			subtotal = 0;
			dishText.setText("");
			dispose();
		}		
	}
	private class exitBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//subtotal = 0;
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

	    Graphics2D g2d = (Graphics2D)gp;
	    g2d.setColor(Color.black);
	    g2d.translate(pf.getImageableX(), pf.getImageableY());

	    // Now we perform our rendering
	    gp.drawString(dishText.getText(), 100, 100);

	    // tell the caller that this page is part
	    // of the printed document
	    return PAGE_EXISTS;
	}
	
}
public class MainMenu {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String host = "jdbc:mysql://localhost/restaurant";
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
	public MainMenu(){
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
	      
	      /*createDatabase = "CREATE DATABASE restaurant";
	      stmt.executeUpdate(createDatabase);
	      System.out.println("The database restaurant created.");*/
	      
	      /*String createTable = "CREATE TABLE customer "
	      		+ " ( phone VARCHAR(20) not null, "
	      		+ "name VARCHAR(30) not null, "
	      		+ "address VARCHAR(50) not null, "
	      		+ "city VARCHAR(20) not null, "
	      		+ "st VARCHAR(10) not null, "
	      		+ "zip INTEGER not null,"
	      		+ "PRIMARY KEY (phone) ) "; 
	      stmt.executeUpdate(createTable);
	      System.out.println("Table customer created");*/
	      
	      stmt.executeUpdate("DROP TABLE history");
	      System.out.println("delete table");
	      
	      String createHistory = "CREATE TABLE history "
	      		+ "( date VARCHAR(20) not null, "
	      		+ "checkNo INT(10) not null, "
	      		+ "content VARCHAR(1000) not null, "
	      		+ "total float(6,4) not null, "
	      		+ "PRIMARY KEY (date,checkNo) )";
	      stmt.executeUpdate(createHistory);
	      System.out.println("Table History created");  
	      
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

		
	}
}