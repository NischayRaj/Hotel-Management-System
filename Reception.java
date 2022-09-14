
package hotel.management.system;


import javax.swing.*;
import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener {
         
        JButton NewCustomer,rooms,department,allEmployee,ManagerInfo,customers,searchRoom,update,roomstatus,pickup,checkout,logout;

	public static void main(String[] args) {
		new Reception();
	}
	
	Reception(){
           getContentPane().setBackground(Color.WHITE);
           setBounds(350, 200, 800, 570);
           setLayout(null);

           ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
           JLabel image = new JLabel(i1);
           image.setBounds(250,30,500,470);
           add(image);
		
		NewCustomer = new JButton("New Customer Form");
                NewCustomer.setBounds(10, 30, 200, 30);
                NewCustomer.setBackground(Color.BLACK);
                NewCustomer.setForeground(Color.WHITE);
                NewCustomer.addActionListener(this);
		add(NewCustomer);
		
		rooms = new JButton("Room");
                rooms.setBounds(10, 70, 200, 30);
                rooms.setBackground(Color.BLACK);
                rooms.setForeground(Color.WHITE);
                rooms.addActionListener(this); 
                add(rooms);
	
		department = new JButton("Department");
		department.setBounds(10, 110, 200, 30);
                department.setBackground(Color.BLACK);
                department.setForeground(Color.WHITE);
                department.addActionListener(this);
		add(department);
		
		allEmployee = new JButton("All Employee Info");
		allEmployee.addActionListener(this); 
		allEmployee.setBounds(10, 150, 200, 30);                
                allEmployee.setBackground(Color.BLACK);
                allEmployee.setForeground(Color.WHITE);
		add(allEmployee);
		
		customers = new JButton("Customer Info");
		customers.setBounds(10, 190, 200, 30);
                customers.setBackground(Color.BLACK);
                customers.setForeground(Color.WHITE);
                customers.addActionListener(this); 
                add(customers);
		
		ManagerInfo = new JButton("Manager Info");
		ManagerInfo.setBounds(10, 230, 200, 30);
                ManagerInfo.setBackground(Color.BLACK);
                ManagerInfo.setForeground(Color.WHITE);
                ManagerInfo.addActionListener(this); 
                add(ManagerInfo);
		
		checkout = new JButton("Check Out");
		checkout.addActionListener(this); 
		checkout.setBounds(10, 270, 200, 30);
                checkout.setBackground(Color.BLACK);
                checkout.setForeground(Color.WHITE);
                add(checkout);
		
		update = new JButton("Update Status");
		update.addActionListener(this); 
		update.setBounds(10, 310, 200, 30);
                update.setBackground(Color.BLACK);
                update.setForeground(Color.WHITE);
                add(update);
		
		roomstatus = new JButton("Update Room Status");
		roomstatus.addActionListener(this);
		roomstatus.setBounds(10, 350, 200, 30);
                roomstatus.setBackground(Color.BLACK);
                roomstatus.setForeground(Color.WHITE);
                add(roomstatus);
		
		pickup = new JButton("Pick up Service");
		pickup.setBounds(10, 390, 200, 30);
                pickup.addActionListener(this);
                pickup.setBackground(Color.BLACK);
                pickup.setForeground(Color.WHITE);
                add(pickup);
		
		searchRoom = new JButton("Search Room");
		searchRoom.setBounds(10, 430, 200, 30);
                searchRoom.setBackground(Color.BLACK);
                searchRoom.setForeground(Color.WHITE);
                searchRoom.addActionListener(this);
                add(searchRoom);

		logout = new JButton("Logout");
		logout.setBounds(10, 470, 200, 30);
                logout.addActionListener(this);
                logout.setBackground(Color.BLACK);
                logout.setForeground(Color.WHITE);
                add(logout);
               
                
                setVisible(true);
	}
        
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == NewCustomer) {
                setVisible(false);
                new AddCustomer();
            } else if(ae.getSource() == rooms) {
                setVisible(false);
                new Room();
            }
            else if(ae.getSource() == department) {
                setVisible(false);
                new Department();
        }
             else if(ae.getSource() == allEmployee) {
                setVisible(false);
                new EmployeeInfo();
}
            else if(ae.getSource() == ManagerInfo) {
                setVisible(false);
                new ManagerInfo();
}
            else if(ae.getSource() == customers) {
                setVisible(false);
                new CustomerInfo();
}
            else if(ae.getSource() == searchRoom) {
                setVisible(false);
                new SearchRoom();
}
        else if(ae.getSource() == update) {
                setVisible(false);
                new UpdateCheck();    
}
            else if(ae.getSource() == roomstatus) {
                setVisible(false);
                new UpdateRoom(); 
}
            else if(ae.getSource() == pickup) {
                setVisible(false);
                new Pickup(); 
}
             else if(ae.getSource() == checkout) {
                setVisible(false);
                new Checkout(); 
}
           else if(ae.getSource() == logout) {
                setVisible(false);
                System.exit(0);
}
}
}