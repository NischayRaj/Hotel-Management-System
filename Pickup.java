

package hotel.management.system;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener{
	
	 JTable table;
	 JLabel lblAvailability, lblCleanStatus, lblprice, lblbed, lblroomno,l6,l7 ;
	 JButton submit,back;
         Choice typeofcar;
         JCheckBox available;

	public static void main(String[] args) {
	     new Pickup();
        }
	 Pickup() {
            //conn = Javaconnect.getDBConnection();
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 200, 1000, 600);

            table = new JTable();
            table.setBounds(0, 200, 1000, 300);
            add(table);

            submit = new JButton("Submit");
            submit.addActionListener(this); 
            submit.setBounds(300, 520, 120, 30);
            submit.setBackground(Color.BLACK);
            submit.setForeground(Color.WHITE);
            add(submit);
            
            back = new JButton("Back");
            back.addActionListener(this); 
            back.setBounds(500, 520, 120, 30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            add(back);
		
            JLabel text = new JLabel("Pickup Service");
            text.setFont(new Font("Tahome",Font.PLAIN,20));
            text.setBounds(400,30,200,30);
            add(text);
            
            JLabel lblbedtype = new JLabel("Type of Car");
            //lblbedtype.setFont(new Font("Tahome",Font.PLAIN,20));
            lblbedtype.setBounds(50,100,100,20);
            add(lblbedtype);
            
             typeofcar = new Choice();
             typeofcar.setBounds(150,100,200,25);
             add(typeofcar);
             
             try {
                 Conn c = new Conn();
                 
                 ResultSet rs = c.s.executeQuery("select * from driver");
                 while(rs.next()) {
                   typeofcar.add(rs.getString("brand"));  
                 }
             }catch (Exception e) {
                         e.printStackTrace();
                         }
            
            lblroomno = new JLabel("Name");
            lblroomno.setBounds(30,160,100,20);
            add(lblroomno);

            lblAvailability = new JLabel("Age");
            lblAvailability.setBounds(200, 160, 100, 20);
            add(lblAvailability);

            lblCleanStatus = new JLabel("Gender");
            lblCleanStatus.setBounds(330, 160, 100, 20);
            add(lblCleanStatus);

            lblprice = new JLabel("Company");
            lblprice.setBounds(460, 160, 100, 20);
            add(lblprice);

            lblbed = new JLabel("Brand");
            lblbed.setBounds(630, 160, 100, 20);
            add(lblbed);
            
            l6 = new JLabel("Availability");
            l6.setBounds(740, 160, 100, 20);
            add(l6);
            
            l7 = new JLabel("Location");
            l7.setBounds(880, 160, 100, 20);
            add(l7);
            
              try{
                Conn conn = new Conn();
                String query = "select * from driver";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch(Exception e1){
                            e1.printStackTrace();
                    }

            
            setVisible(true);
	}
         
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == submit) {
                try {
                    String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
                  
                    Conn conn = new Conn();
                    ResultSet rs;
                    
                        rs = conn.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
           setVisible(false);
           new Reception();
      }
}
}

    



