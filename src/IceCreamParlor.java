import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.*;

public class IceCreamParlor  extends JFrame implements ActionListener{
	
	
	JButton  ic1 ,ic2 ,ic3 ,ic4;
	JLabel icon , ick1 ,ick2 , ick3 ,ick4;
	String iconPath = "icons/baskinLogo.jpg";
	String icec1 = "icons/cone.jpg";
	String icec2 = "icons/chocoBalls.jpg";
	String icec3 = "icons/cup.jpg";
	String icec4 = "icons/pudding.png";
	JLabel billLabel, items;
	JTextArea bill;
	JButton billprint , reset;
	JScrollPane jp;
	
	
	LinkList list = new LinkList();
	
	
	
	
	public IceCreamParlor() {
		list.createList(0);

		
		
		
		super.getContentPane().setBackground(Color.WHITE);
		super.setTitle("Ice Cream Parlor");
		super.setBounds(100, 60, 1000, 650);
		super.setResizable(false);
		//--
		
		icon = new JLabel();
		icon.setBounds(360, 0, 150, 150);
		super.add(icon);
		ImageIcon ikon = new ImageIcon(iconPath);
		icon.setIcon(ikon);
		
		billLabel = new  JLabel("Bill Generation"); 
		billLabel.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
		billLabel.setBounds(590, 100, 200, 20);
		super.add(billLabel);
		
		

		items = new  JLabel("Ice Creams Avalible"); 
		items.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 20));
		items.setBounds(80, 100, 200, 20);
		super.add(items);
		
		ic1 = new JButton();
		ic1.setBounds(80, 200, 90, 85);
		super.add(ic1);
		ImageIcon ica = new ImageIcon(icec1);
		ic1.setIcon(ica);
		ic1.addActionListener(this);
		
		ick1  = new JLabel("Choclate Cone (Rs 40 INR)");
		ick1.setBounds(80, 290, 200, 15);
		super.add(ick1);
		
		
		
		
		ic2 = new JButton();
		ic2.setBounds(80, 420, 90, 85);
		super.add(ic2);
		ImageIcon icb = new ImageIcon(icec2);
		ic2.setIcon(icb);
		ic2.addActionListener(this);
		
		ick2  = new JLabel("Vanilla Choco Balls (Rs 140 INR)");
		ick2.setBounds(80, 510, 200, 15);
		super.add(ick2);
		
		
		
		
		
		ic3 = new JButton();
		ic3.setBounds(290, 200, 90, 85);
		super.add(ic3);
		ImageIcon icc = new ImageIcon(icec3);
		ic3.setIcon(icc);
		ic3.addActionListener(this);
		
		ick3  = new JLabel("Pinaple Bucket (Rs 340 INR)");
		ick3.setBounds(290, 290, 200, 15);
		super.add(ick3);
		
		
		
		ic4 = new JButton();
		ic4.setBounds(290, 420, 90, 85);
		super.add(ic4);
		ImageIcon icd = new ImageIcon(icec4);
		ic4.setIcon(icd);
		ic4.addActionListener(this);
		

		ick4  = new JLabel("Vanilla + Choco + Butter Scotch bucket (Rs 1140 INR)");
		ick4.setBounds(290, 510, 299, 15);
		super.add(ick4);
		
		
		bill = new JTextArea();
		jp = new JScrollPane(bill);
		jp.setBounds(590, 150, 350, 400);
		super.add(jp);
		bill.setEditable(false);
		bill.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 15));
		jp.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		
		billprint = new JButton("Get Bill");
		billprint.setBounds(590, 560, 100, 25);
		super.add(billprint);
		billprint.addActionListener(this);

		

		reset = new JButton("Reset ");
		reset.setBounds(700, 560, 100, 25);
		super.add(reset);
		reset.addActionListener(this);

		
		
		//--
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		
		
	}	
	
	public static void main(String[] args) {
		IceCreamParlor ref = new IceCreamParlor();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		
		int total;
		int priceic1;int priceic2;int priceic3;int priceic4;
		
		
		if(e.getSource()==ic1) {
			
			priceic1= 40;
			String prev = bill.getText();
			bill.setText(prev+"\n\nChoclate cone : Rs "+priceic1+" INR");
			
			list.addNodeEnd(priceic1);
		
			
			
		}
		if(e.getSource()==ic2) {
			String prev = bill.getText();
			priceic2= 140;
			bill.setText(prev+"\n\nVanilla choco balls : Rs "+priceic2+" INR");
			list.addNodeEnd(priceic2);
		
		}if(e.getSource()==ic3) {
			String prev = bill.getText();
			priceic3= 340;
			bill.setText(prev+"\n\nPinaple Bucket : Rs "+priceic3+" INR");
			list.addNodeEnd(priceic3);
			
		}if(e.getSource()==ic4) {
			String prev = bill.getText();
			priceic4= 1140;
			bill.setText(prev+"\n\nVanilla + Choco + Butter Scotch bucket : Rs "+priceic4+" INR");
			list.addNodeEnd(priceic4);
			
		}
		if(e.getSource()==billprint) {
			String prev = bill.getText();
			 total = list.addAllItems();
			
			bill.setText("Your Bill :\n\n"+prev+"\n\n\n\n\n\n\nTotal Amount To pay : Rs "+total+" INR (inc Service Tax.)\n"+ "\nTotal items :"+(list.getItemCount()-1));
			
			String data =  bill.getText();
			File folder = new File("c:/iceCreamParlorBills");
			folder.mkdir();
			
			try {
				FileOutputStream foss = new FileOutputStream("c:/iceCreamParlorBills/Bills.txt");
				foss.write(data.getBytes());
				
				//Runtime.getRuntime().exec("cmd/c start c:/iceCreamParlorBills/Bills.txt");
				
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		if(e.getSource()==reset) {
			bill.setText("");
			total=0;
			int i = list.getItemCount();
			for(int j=1;j<i ;j++) {
				list.delNodeEnd();
			}
		}
		
	}

}
