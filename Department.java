
package hotel.management.system;

import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener{
	
	 JTable table;
	 JLabel lblAvailability, lblCleanStatus, lblprice, lblbed, lblroomno ;
	 JButton back;

	public static void main(String[] args) {
	     new Department();
        }
	 Department() {
            //conn = Javaconnect.getDBConnection();
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(400, 200, 700, 480);

            table = new JTable();
            table.setBounds(0, 50, 700, 350);
            add(table);

            try{
                Conn c = new Conn();
                String query = "select * from Department";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch(Exception e1){
                            e1.printStackTrace();
                    }
	
            back = new JButton("Back");
            back.addActionListener(this); 
            back.setBounds(280, 400, 120, 30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            add(back);
		
            lblroomno = new JLabel("Deaprtment");
            lblroomno.setBounds(100,10,100,20);
            add(lblroomno);

            lblAvailability = new JLabel("Budget");
            lblAvailability.setBounds(420, 10, 100, 20);
            add(lblAvailability);

            setVisible(true);
	}
         
        public void actionPerformed(ActionEvent ae) {
           setVisible(false);
           new Reception();
      }
}

    

