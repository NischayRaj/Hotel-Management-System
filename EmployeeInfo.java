
package hotel.management.system;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class EmployeeInfo extends JFrame implements ActionListener{
	
	 JTable table;
	 JLabel lblAvailability, lblCleanStatus, lblprice, lblbed, lblroomno, lblph, lblem, lblad;
	 JButton back;

	public static void main(String[] args) {
	     new EmployeeInfo();
        }
	 EmployeeInfo() {
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
                String query = "select * from Employee";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch(Exception e1){
                            e1.printStackTrace();
                    }
		    
		
//            JButton btnLoadData = new JButton("Load Data");
//            btnLoadData.addActionListener(this); 
//            btnLoadData.setBounds(100, 470, 120, 30);
//            btnLoadData.setBackground(Color.BLACK);
//            btnLoadData.setForeground(Color.WHITE);
//            add(btnLoadData);
		
            back = new JButton("Back");
            back.addActionListener(this); 
            back.setBounds(420, 500, 110, 30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            add(back);
		
            lblroomno = new JLabel("Name");
            lblroomno.setBounds(40,10,100,20);
            add(lblroomno);

            lblAvailability = new JLabel("Age");
            lblAvailability.setBounds(170, 10, 100, 20);
            add(lblAvailability);

            lblCleanStatus = new JLabel("Gender");
            lblCleanStatus.setBounds(290, 10, 100, 20);
            add(lblCleanStatus);

            lblprice = new JLabel("Job");
            lblprice.setBounds(400, 10, 100, 20);
            add(lblprice);

            lblbed = new JLabel("Salary");
            lblbed.setBounds(540, 10, 100, 20);
            add(lblbed);
            
            lblph = new JLabel("Phone");
            lblph.setBounds(670, 10, 100, 20);
            add(lblph);
            
            lblem = new JLabel("Email");
            lblem.setBounds(790, 10, 100, 20);
            add(lblem);
            
            lblad = new JLabel("Aadhar");
            lblad.setBounds(910, 10, 100, 20);
            add(lblad);
            
            setVisible(true);
	}
         
        public void actionPerformed(ActionEvent ae) {
           setVisible(false);
           new Reception();
      }
}

    

