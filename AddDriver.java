
package hotel.management.system;



import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDriver extends JFrame implements ActionListener{

   // private JPanel contentPane;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox gendercombo,availablecombo;
    JButton add,cancel;
    
     AddDriver() {
          setBounds(300, 200, 980, 470);
	   getContentPane().setBackground(Color.WHITE);
           setLayout(null);
           
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400,30,500,300);
            add(image);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	heading.setBounds(150, 10, 200, 20);
	add(heading);
        
	JLabel lblroomno = new JLabel("Name");
	//lblroomno.setForeground(new Color(25, 25, 112));
	lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblroomno.setBounds(60, 70, 120, 30);
	add(lblroomno);
        
        tfname = new JTextField();
	tfname.setBounds(200, 70, 150, 30);
	add(tfname);
        

	JLabel lblage = new JLabel("Age");
	//lblavailabel.setForeground(new Color(25, 25, 112));
	lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblage.setBounds(60, 110, 120, 30);
	add(lblage);
        
        tfage = new JTextField();
	tfage.setBounds(200, 110, 150, 30);
	add(tfage);
        

	JLabel lblclean = new JLabel("Gender");
	//lblclean.setForeground(new Color(25, 25, 112));
	lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblclean.setBounds(60, 150, 120, 30);
	add(lblclean);
        
        gendercombo = new JComboBox(new String[] { "Male", "Female" });
	gendercombo.setBounds(200, 150, 150, 30);
        gendercombo.setBackground(Color.WHITE);
	add(gendercombo);

	JLabel lblprice = new JLabel("Car Company");
	//lblprice.setForeground(new Color(25, 25, 112));
	lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblprice.setBounds(60, 190, 120, 30);
	add(lblprice);
        
        tfcompany = new JTextField();
	tfcompany.setBounds(200, 190, 150, 30);
	add(tfcompany);

        JLabel lbltype = new JLabel("Car Model");
	//lbltype.setForeground(new Color(25, 25, 112));
	lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lbltype.setBounds(60, 230, 120, 30);
	add(lbltype);

        
        tfmodel = new JTextField();
	tfmodel.setBounds(200, 230, 150, 30);
	add(tfmodel);
        
        JLabel lblavailable= new JLabel("Availability");
	//lbltype.setForeground(new Color(25, 25, 112));
	lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblavailable.setBounds(60, 270, 120, 30);
	add(lblavailable);
 
	
        availablecombo = new JComboBox(new String[] { "Available", "Busy" });
	availablecombo.setBounds(200, 270, 150, 30);
        availablecombo.setBackground(Color.WHITE);
	add(availablecombo);
        
          JLabel lbllocation= new JLabel("Location");
	//lbltype.setForeground(new Color(25, 25, 112));
	lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lbllocation.setBounds(60, 310, 120, 30);
	add(lbllocation);

        
        tflocation = new JTextField();
	tflocation.setBounds(200, 310, 150, 30);
	add(tflocation);
        
	add = new JButton("Add Driver");
	add.addActionListener(this);
	add.setBounds(60, 370, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	add(add);

	cancel = new JButton("Cancel");
	cancel.addActionListener(this);
	cancel.setBounds(220, 370, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
	add(cancel);

	
        //contentPane.setBackground(Color.WHITE);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
      
            
            if(ae.getSource() == add){
                
                
                String name = tfname.getText();
                String age = tfage.getText();
                String gender = (String)gendercombo.getSelectedItem();
                String company  = tfcompany.getText();
                String brand = tfmodel.getText();
                String available = (String)availablecombo.getSelectedItem();
                String location = tflocation.getText();
                
              
                try{
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"', '"+location+"')";
		conn.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "New Driver Successfully Added");
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
        new AddDriver();
    }
        }
    
