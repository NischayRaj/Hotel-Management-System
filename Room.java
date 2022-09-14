
package hotel.management.system;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class Room extends JFrame implements ActionListener{
	
	 JTable table;
	 JLabel lblAvailability, lblCleanStatus, lblprice, lblbed, lblroomno ;
	 JButton back;

	public static void main(String[] args) {
	     new Room();
        }
	 Room() {
            //conn = Javaconnect.getDBConnection();
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 200, 1050, 600);

            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
            Image i2 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(500,0,600,600);
            add(image);
                
		
            table = new JTable();
            table.setBounds(0, 40, 500, 400);
            add(table);

            try{
                Conn c = new Conn();
                String query = "select * from Room";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch(Exception e1){
                            e1.printStackTrace();
                    }

            back = new JButton("Back");
            back.addActionListener(this); 
            back.setBounds(200, 500, 110, 30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            add(back);
		
            lblroomno = new JLabel("Room Number");
            lblroomno.setBounds(10,10,100,20);
            add(lblroomno);

            lblAvailability = new JLabel("Availability");
            lblAvailability.setBounds(120, 10, 100, 20);
            add(lblAvailability);

            lblCleanStatus = new JLabel("Clean Status");
            lblCleanStatus.setBounds(230, 10, 100, 20);
            add(lblCleanStatus);

            lblprice = new JLabel("Price");
            lblprice.setBounds(330, 10, 100, 20);
            add(lblprice);

            lblbed = new JLabel("Bed Type");
            lblbed.setBounds(410, 10, 100, 20);
            add(lblbed);
            
            setVisible(true);
	}
         
        public void actionPerformed(ActionEvent ae) {
           setVisible(false);
           new Reception();
      }
}

    

