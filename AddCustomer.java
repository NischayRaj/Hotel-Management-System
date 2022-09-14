
package hotel.management.system;



import java.awt.*;
import java.sql.*;	
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{

	JTextField tfno,tfname,tfcountry,tfdeposit;
        JComboBox comboId;
        JRadioButton rmale,rfemale;
        JLabel checkintime;
        JButton add, back;
        Choice croom;
	
        
	public static void main(String[] args) {
          new AddCustomer();
	}

	 AddCustomer() {
             
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 800, 550);
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        JLabel lblform = new JLabel("NEW CUSTOMER FORM");
        lblform.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblform.setBounds(100, 20, 300, 30);
        add(lblform);

        JLabel lblId = new JLabel("ID :");
        lblId.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblId.setBounds(35, 80, 100, 20);
        add(lblId);

        comboId = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        comboId.setBounds(200,80,150,25);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        JLabel lblno = new JLabel("Number :");
        lblno.setBounds(35, 120, 100, 20);
        lblno.setFont(new Font("Yu Mincho", Font.PLAIN, 20));  
        add(lblno);

        tfno = new JTextField();
        tfno.setBounds(200, 120, 150, 25);
        add(tfno);
        //tfno.setColumns(10);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Yu Mincho", Font.PLAIN, 20)); 
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        //t2.setColumns(10);


        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 200, 100, 20);
        lblGender.setFont(new Font("Yu Mincho", Font.PLAIN, 20)); 
        add(lblGender);

        rmale = new JRadioButton("Male");
        rmale.setFont(new Font("Raleway", Font.BOLD, 14));
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setFont(new Font("Raleway", Font.BOLD, 14));
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 240, 100, 20);
        lblCountry.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        add(lblCountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);

        JLabel lblReserveRoomNumber = new JLabel("Room No :");
        lblReserveRoomNumber.setBounds(35, 280, 100, 20);
        lblReserveRoomNumber.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        add(lblReserveRoomNumber);

        croom = new Choice();
        try{
        Conn c = new Conn();

        ResultSet rs = c.s.executeQuery("select * from room where availability = 'Available'");
        while(rs.next()){
           croom.add(rs.getString("roomnumber"));    
            } 
        }catch(Exception e){ 
            e.printStackTrace();
        }
        croom.setBounds(200, 280, 150, 25);
        add(croom);

        JLabel lbltime = new JLabel("Checkin Time :");
        lbltime.setBounds(35, 320, 150, 20);
        lbltime.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        add(lbltime);

        Date date = new Date();

        checkintime = new JLabel("" +date);
        checkintime.setBounds(200,320,200,25);
        checkintime.setFont(new Font("Yu Mincho", Font.PLAIN, 14));
        add(checkintime);

        JLabel lblDeposite = new JLabel("Deposit :");
        lblDeposite.setBounds(35, 360, 100, 20);
        lblReserveRoomNumber.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        add(lblDeposite);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        add(tfdeposit);
		

        add = new JButton("Add");
        add.setBounds(50,410,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
         
        back = new JButton("Back");
        back.setBounds(200, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back); 
        
        setVisible(true);
         }
        public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== add) {
        String id = (String)comboId.getSelectedItem(); 
        String number =  tfno.getText();
        String name =  tfname.getText();
        String gender =  null;

        if(rmale.isSelected()){ 
            gender = "Male";
        }
        else if(rfemale.isSelected()){ 
            gender = "Female";
        }

        String country = tfcountry.getText();
        String room = croom.getSelectedItem();
        String time = checkintime.getText();
        String deposit = tfdeposit.getText();

        try {
        String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
        String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";

        Conn conn = new Conn();
        conn.s.executeUpdate(query);
        conn.s.executeUpdate(query2);
        JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
        setVisible(false);
        new Reception();
                
        }catch(Exception e){
                e.printStackTrace();
        }
        }
        else if(ae.getSource() == back) { 
            setVisible(false);
             new Reception();
                           
	}      
	}
        } 

