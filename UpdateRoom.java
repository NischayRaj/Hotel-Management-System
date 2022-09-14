
package hotel.management.system;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame implements ActionListener{
	
	JTextField txt_ID;
	JTextField txt_available;
	JTextField txt_status;
	JTextField txt_paid;
	JTextField txt_pending;

        JButton check, Exit, Update;
        Choice c1, c2;
	
	public static void main(String[] args) {
		new UpdateRoom();
	}
	
	 UpdateRoom()  {
		
                getContentPane().setBackground(Color.WHITE);
                setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 980, 460);
		
                JLabel lblUpdateStatus = new JLabel("Update Room Status");
		lblUpdateStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateStatus.setBounds(30,20,250,30);
                lblUpdateStatus.setForeground(Color.BLUE);
		add(lblUpdateStatus);
                
         
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
                Image i2 = i1.getImage().getScaledInstance(500,200,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel l1 = new JLabel(i3);
                l1.setBounds(400,50,500,300);
                add(l1);
		
		JLabel lblid = new JLabel("Customer ID:");
		lblid.setBounds(30, 80, 100, 20);
		add(lblid);
                
                c1 = new Choice();
                c1.setBounds(200, 80, 150, 25);
		add(c1);
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ 
                    e.printStackTrace();
                }
              
		JLabel lblroom = new JLabel("Room Number :");
		lblroom.setBounds(30, 130, 100, 20);
		add(lblroom);
                
                
                txt_ID = new JTextField();
                txt_ID.setBounds(200, 130, 150, 25);
		add(txt_ID);
		
		JLabel lblname = new JLabel("Availability : ");
		lblname.setBounds(30, 180, 100, 20);
		add(lblname);
                
                txt_available = new JTextField();
		txt_available.setBounds(200, 180, 150, 25);
		add(txt_available);
		
		
		JLabel lblCheck = new JLabel("Cleaning Status :");
		lblCheck.setBounds(30, 230, 100, 20);
		add(lblCheck);
		
                txt_status = new JTextField();
		txt_status.setBounds(200, 230, 150, 25);
		add(txt_status);
		
		Update = new JButton("Update");
		Update.addActionListener(this);
                Update.setBounds(150, 300, 100, 30);
                Update.setBackground(Color.BLACK);
                Update.setForeground(Color.WHITE);
		add(Update);
		
               
		Exit = new JButton("Back");
		Exit.addActionListener(this);
		Exit.setBounds(270, 300, 100, 30);
                Exit.setBackground(Color.BLACK);
                Exit.setForeground(Color.WHITE);
		add(Exit);
		
		check = new JButton("Check");
		check.addActionListener(this); 
                check.setBounds(30, 300, 100, 30);
                check.setBackground(Color.BLACK);
                check.setForeground(Color.WHITE);
		add(check);
                
                setVisible(true);
         }
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == check) {
                String id = c1.getSelectedItem();
                String query = "select * from customer where number = '"+id+"'";
             
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                while(rs.next()){
                    txt_ID.setText(rs.getString("room"));        
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = "+txt_ID.getText());
                while(rs2.next()){
                 txt_available.setText(rs2.getString("availability"));
                 txt_status.setText(rs2.getString("cleaning_status"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
            else if(ae.getSource() == Update) {
             
                String number = c1.getSelectedItem();
                String room = txt_ID.getText(); //room_number;    
                String available = txt_available.getText(); //name    
                String status = txt_status.getText(); //status;    
             
               try {
                   
                Conn c= new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"'");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                 setVisible(false);
                 new Reception();
              
            }catch(Exception ee){
                System.out.println(ee);
            }				
		
            }
            else {
                setVisible(false);
                 new Reception();
            }
	}

}


