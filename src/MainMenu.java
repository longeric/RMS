import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class MainFrame extends JFrame{
	public MainFrame(){
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnDineIn = new JButton("Dine In");
		btnDineIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableNo fTableNo = new TableNo();
				fTableNo.setSize(400,300);
				fTableNo.setVisible(true);
				//frame.setVisible(false);
				
			}
		});
		btnDineIn.setBounds(179, 145, 127, 43);
		this.getContentPane().add(btnDineIn);
		
		JButton btnPickup = new JButton("Pick up");
		btnPickup.setBounds(412, 145, 127, 43);
		this.getContentPane().add(btnPickup);
		
		JButton btnDelivery = new JButton("Delivery");
		btnDelivery.setBounds(179, 199, 127, 43);
		this.getContentPane().add(btnDelivery);
		
		JButton btnModifyCheck = new JButton("Modify Check");
		btnModifyCheck.setBounds(412, 199, 127, 43);
		this.getContentPane().add(btnModifyCheck);
		
		JLabel lblRestaurantName = new JLabel("Restaurant name");
		lblRestaurantName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurantName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRestaurantName.setBounds(273, 77, 181, 35);
		this.getContentPane().add(lblRestaurantName);
	}
}
class TableNo extends JFrame{
	public TableNo(){
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	}
}
public class MainMenu {

	private MainFrame mainFrame;	//private JFrame frame;
	private TableNo fTableNo; 	//private JFrame fTableNo;
	private JFrame fDishChoose;
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
		mainFrame.setVisible(true);
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