
package hotel.management.system;



import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
        JTextField t1;
        JLabel lblcheckintime, lblroomnumber,lblcheckouttime;
        JButton btnCheckOut,btnExit;
        Choice c1;

	public static void main (String[] args) {
	       new Checkout();
        }
	
	 Checkout() {	
             
                getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 400);
                setLayout(null);
		
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(350,50,400,250);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
                lblCheckOut.setForeground(Color.BLUE);
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(100, 20, 100, 30);
		add(lblCheckOut);
		
		JLabel lblid = new JLabel("Customer ID :");
		lblid.setBounds(30, 80, 100, 30);
		add(lblid);
                
                c1 = new Choice();
                c1.setBounds(150,80,150,25);
                add(c1);
                
                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(310,80,20,20);
                add(l2);
             
		JLabel lblRoom = new JLabel("Room Number:");
		lblRoom.setBounds(30,130,100,30);
		add(lblRoom);
		
                lblroomnumber = new JLabel();
                lblroomnumber.setBounds(150,130,100,30);
		add(lblroomnumber);
                
                
                JLabel lblcheckin = new JLabel("Checkin Time:");
		lblcheckin.setBounds(30,180,100,30);
		add(lblcheckin);
		
                lblcheckintime = new JLabel();
                lblcheckintime.setBounds(150,180,100,30);
		add(lblcheckintime);
                
                JLabel lblcheckout = new JLabel("Checkout Time:");
		lblcheckout.setBounds(30,230,100,30);
		add(lblcheckout);
		
                Date date = new Date();
                
                lblcheckouttime = new JLabel("" + date);
                lblcheckouttime.setBounds(150,230,150,30);
		add(lblcheckouttime);
		
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(this); 
                btnCheckOut.setBounds(30, 280, 120, 30);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		add(btnCheckOut);
			
		btnExit = new JButton("Back");
                btnExit.setBounds(170, 280, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		add(btnExit);
		btnExit.addActionListener(this);
                
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));  
                        lblroomnumber.setText(rs.getString("room"));
                        lblcheckintime.setText(rs.getString("checkintime"));
                    }
                    }catch(Exception e){ 
                        e.printStackTrace();
                    }
                  
                setVisible(true);
                    }
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnCheckOut) {

                String query1 = "Delete from customer where number = '"+c1.getSelectedItem()+"'";
                String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";

        try{
               Conn c = new Conn();
        
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Check Out Successful");
                setVisible(false);
                new Reception();
               
        }catch(Exception e){
                e.printStackTrace();
        }
        }
        else {
            setVisible(false);
            new Reception();
        }
        }
}
    
    
		