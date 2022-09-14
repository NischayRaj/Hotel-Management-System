
package hotel.management.system;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener{
	
	 JTable table;
	 JLabel lblAvailability, lblCleanStatus, lblprice, lblbed, lblroomno, lblph, lblem, lblad;
	 JButton back;

	public static void main(String[] args) {
	     new CustomerInfo();
        }
	 CustomerInfo() {
            //conn = Javaconnect.getDBConnection();
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 200, 1000, 600);

            table = new JTable();
            table.setBounds(0, 40, 1000, 400);
            add(table);

            try{
                Conn c = new Conn();
                String query = "select * from customer";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch(Exception e1){
                            e1.printStackTrace();
                    }

		
            back = new JButton("Back");
            back.addActionListener(this); 
            back.setBounds(420, 500, 110, 30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            add(back);
		
            lblroomno = new JLabel("Document Type");
            lblroomno.setBounds(10,10,100,20);
            add(lblroomno);

            lblAvailability = new JLabel("Number");
            lblAvailability.setBounds(160, 10, 100, 20);
            add(lblAvailability);

            lblCleanStatus = new JLabel("Name");
            lblCleanStatus.setBounds(290, 10, 100, 20);
            add(lblCleanStatus);

            lblprice = new JLabel("Gender");
            lblprice.setBounds(410, 10, 100, 20);
            add(lblprice);

            lblbed = new JLabel("Country");
            lblbed.setBounds(540, 10, 100, 20);
            add(lblbed);
            
            lblph = new JLabel("Room Number");
            lblph.setBounds(640, 10, 100, 20);
            add(lblph);
            
            lblem = new JLabel("Checkin time");
            lblem.setBounds(770, 10, 100, 20);
            add(lblem);
            
            lblad = new JLabel("Deposit");
            lblad.setBounds(890, 10, 100, 20);
            add(lblad);
            
            setVisible(true);
	}
         
        public void actionPerformed(ActionEvent ae) {
           setVisible(false);
           new Reception();
      }
}

    


