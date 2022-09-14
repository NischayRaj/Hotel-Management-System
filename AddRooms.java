
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRooms extends JFrame implements ActionListener{

   // private JPanel contentPane;
    JTextField tfroom,tfprice;
    JComboBox availablecombo , cleancombo, typecombo;
    JButton add,cancel;
    
    public AddRooms() {
          setBounds(330, 200, 940, 470);
	   getContentPane().setBackground(Color.WHITE);
           setLayout(null);
           
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
                //Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                //ImageIcon i2 = new ImageIcon(i3);
                JLabel image = new JLabel(i1);
                image.setBounds(400,30,500,300);
                add(image);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	heading.setBounds(150, 20, 200, 20);
	add(heading);
        
	
        
	JLabel lblroomno = new JLabel("Room Number");
	//lblroomno.setForeground(new Color(25, 25, 112));
	lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblroomno.setBounds(60, 80, 120, 30);
	add(lblroomno);
        
        
        tfroom = new JTextField();
	tfroom.setBounds(200, 80, 150, 30);
	add(tfroom);
        

	JLabel lblavailabel = new JLabel("Availability");
	//lblavailabel.setForeground(new Color(25, 25, 112));
	lblavailabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblavailabel.setBounds(60, 130, 120, 30);
	add(lblavailabel);
        
        String availableOptions[] = {"Available", "Occupied"};
        availablecombo = new JComboBox(availableOptions);
	availablecombo .setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);
	add(availablecombo );


	JLabel lblclean = new JLabel("Cleaning Status");
	//lblclean.setForeground(new Color(25, 25, 112));
	lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblclean.setBounds(60, 180, 120, 30);
	add(lblclean);
        
        cleancombo = new JComboBox(new String[] { "Cleaned", "Dirty" });
	cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
	add(cleancombo);

	JLabel lblprice = new JLabel("Price");
	//lblprice.setForeground(new Color(25, 25, 112));
	lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblprice.setBounds(60, 230, 120, 30);
	add(lblprice);
        
        tfprice = new JTextField();
	tfprice.setBounds(200, 230, 150, 30);
	add(tfprice);

        JLabel lbltype = new JLabel("Bed Type");
	//lbltype.setForeground(new Color(25, 25, 112));
	lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lbltype.setBounds(60, 280, 120, 30);
	add(lbltype);


        typecombo = new JComboBox(new String[] { "Single Bed", "Double Bed"});
	typecombo.setBounds(200, 280, 150, 30);
	add(typecombo);
 
	
	add = new JButton("Add Room");
	add.addActionListener(this);
	add.setBounds(60, 350, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	add(add);

	cancel = new JButton("Cancel");
	cancel.addActionListener(this);
	cancel.setBounds(220, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
	add(cancel);

	
        //contentPane.setBackground(Color.WHITE);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
      
            
            if(ae.getSource() == add){
                
                
                String roomnumber = tfroom.getText();
                String availability = (String)availablecombo.getSelectedItem();
                String status = (String)cleancombo.getSelectedItem();
                String price  = tfprice.getText();
                String type = (String)typecombo.getSelectedItem();
                
              
                try{
                Conn conn = new Conn();
                String str = "INSERT INTO room values( '"+roomnumber+"', '"+availability+"', '"+status+"','"+price+"', '"+type+"')";
		conn.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "New Room Successfully Added");
                setVisible(false);
               
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            else {
                setVisible(false);
            }
        }
    public static void main(String[] args) {
        new AddRooms();
    }
        }
    

