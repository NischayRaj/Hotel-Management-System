

package hotel.management.system;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener{
	
	 JTable table;
	 JLabel lblAvailability, lblCleanStatus, lblprice, lblbed, lblroomno ;
	 JButton submit,back;
         JComboBox bed;
         JCheckBox available;

	public static void main(String[] args) {
	     new SearchRoom();
        }
	 SearchRoom() {
            //conn = Javaconnect.getDBConnection();
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 200, 1000, 600);

            table = new JTable();
            table.setBounds(0, 200, 1000, 300);
            add(table);

            try{
                Conn conn = new Conn();
                String query = "select * from Room";
                //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch(Exception e1){
                            e1.printStackTrace();
                    }

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
		
            JLabel text = new JLabel("Search for Room");
            text.setFont(new Font("Tahome",Font.PLAIN,20));
            text.setBounds(400,30,200,30);
            add(text);
            
            JLabel lblbedtype = new JLabel("Bed Type");
            //lblbedtype.setFont(new Font("Tahome",Font.PLAIN,20));
            lblbedtype.setBounds(50,100,100,20);
            add(lblbedtype);
            
            bed = new JComboBox(new String[] {"Single Bed", "Double Bed"});
            bed.setBounds(150,100,150,25);
            bed.setBackground(Color.WHITE);
            add(bed);
            
            available = new JCheckBox("Only Display Available");
            available.setBounds(650,100,150,25);
            available.setBackground(Color.WHITE);
            add(available);
            
            lblroomno = new JLabel("Room Number");
            lblroomno.setBounds(50,160,100,20);
            add(lblroomno);

            lblAvailability = new JLabel("Availability");
            lblAvailability.setBounds(270, 160, 100, 20);
            add(lblAvailability);

            lblCleanStatus = new JLabel("Cleaning Status");
            lblCleanStatus.setBounds(450, 160, 100, 20);
            add(lblCleanStatus);

            lblprice = new JLabel("Price");
            lblprice.setBounds(670, 160, 100, 20);
            add(lblprice);

            lblbed = new JLabel("Bed Type");
            lblbed.setBounds(870, 160, 100, 20);
            add(lblbed);
            
            setVisible(true);
	}
         
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == submit) {
                try {
                    String query1 = "select * from room where bed_type = '"+bed.getSelectedItem()+"'";
                    
                    String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bed.getSelectedItem()+"'";
                
                    Conn conn = new Conn();
                    ResultSet rs;
                    if(available.isSelected()) {
                        rs = conn.s.executeQuery(query2);
                    }
                    else {
                        rs = conn.s.executeQuery(query1);
                    }
                
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

    


