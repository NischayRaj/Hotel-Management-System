
package hotel.management.system;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCheck extends JFrame implements ActionListener{
	
	JTextField txt_ID;
	JTextField txt_name;
	JTextField txt_check;
	JTextField txt_paid;
	JTextField txt_pending;

        JButton check, Exit, Update;
        Choice c1, c2;
	
	public static void main(String[] args) {
		new UpdateCheck();
	}
	
	 UpdateCheck()  {
		
                getContentPane().setBackground(Color.WHITE);
                setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 980, 500);
		
                JLabel lblUpdateStatus = new JLabel("Update Status");
		lblUpdateStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateStatus.setBounds(90,20,200,30);
                lblUpdateStatus.setForeground(Color.BLUE);
		add(lblUpdateStatus);
                
         
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
                JLabel l1 = new JLabel(i1);
                l1.setBounds(450,50,500,300);
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
		lblroom.setBounds(30, 120, 100, 20);
		add(lblroom);
                
                
                txt_ID = new JTextField();
                txt_ID.setBounds(200, 120, 150, 25);
		add(txt_ID);
		
		JLabel lblname = new JLabel("Name : ");
		lblname.setBounds(30, 160, 100, 20);
		add(lblname);
                
                txt_name = new JTextField();
		txt_name.setBounds(200, 160, 150, 25);
		add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lblCheck = new JLabel("Checked-in :");
		lblCheck.setBounds(30, 200, 100, 20);
		add(lblCheck);
		
                txt_check = new JTextField();
		txt_check.setBounds(200, 200, 150, 25);
		add(txt_check);
		
                
		JLabel lblpaid = new JLabel("Amount Paid (Rs) : ");
		lblpaid.setBounds(30, 240, 100, 20);
		add(lblpaid);
		
                txt_paid= new JTextField();
		txt_paid.setBounds(200, 240, 150, 25);
		add(txt_paid);
                
		JLabel lblpending = new JLabel("Pending Amount (Rs) : ");
		lblpending.setBounds(30, 280, 100, 20);
		add(lblpending);

		
                txt_pending = new JTextField();
		txt_pending.setBounds(200, 280, 150, 25);
		add(txt_pending);
		
		Update = new JButton("Update");
		Update.addActionListener(this);
                Update.setBounds(150, 340, 100, 30);
                Update.setBackground(Color.BLACK);
                Update.setForeground(Color.WHITE);
		add(Update);
		
               
		Exit = new JButton("Back");
		Exit.addActionListener(this);
		Exit.setBounds(270, 340, 100, 30);
                Exit.setBackground(Color.BLACK);
                Exit.setForeground(Color.WHITE);
		add(Exit);
		
		check = new JButton("Check");
		check.addActionListener(this); 
                check.setBounds(30, 340, 100, 30);
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
                    txt_name.setText(rs.getString("name"));    
                    txt_check.setText(rs.getString("checkintime"));    
                    txt_paid.setText(rs.getString("deposit"));    
                }
            
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = "+txt_ID.getText());
                while(rs2.next()){
                   String price = rs2.getString("price"); 
                   int amountpaid = Integer.parseInt(price) - Integer.parseInt(txt_paid.getText());
                   txt_pending.setText(""+ amountpaid);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
            else if(ae.getSource() == Update) {
             
                String number = c1.getSelectedItem();
                String room = txt_ID.getText(); //room_number;    
                String name = txt_name.getText(); //name    
                String checkin = txt_check.getText(); //status;    
                String deposit = txt_paid.getText(); //deposit    

                
               try {
                   
                Conn c= new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"'");

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


