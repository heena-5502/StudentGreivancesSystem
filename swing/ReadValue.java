package net.javaguides.swing;
import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;

public class ReadValue extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnNewButton;
    JTable jt;
    DefaultTableModel tmodel;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReadValue frame = new ReadValue();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
       public ReadValue() {
       

        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 614, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
       
        btnNewButton = new JButton("Show");
        btnNewButton.addActionListener(new ActionListener() {
        	ResultSet rs=null;
            public void actionPerformed(ActionEvent e) {
                try
                {
                	
                 Connection con;
                 Class.forName("org.postgresql.Driver");
                 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123" );		        
                 String sql = "SELECT *FROM feedback2";	  
                 PreparedStatement statement = con.prepareStatement(sql);
                 rs=statement.executeQuery();
                tmodel=new DefaultTableModel();
                jt=new JTable(tmodel);
                tmodel.addColumn("Grievances");
           	 tmodel.insertRow(0,new Object[]{"Grievances"});

                contentPane.add(jt ); 
               
                jt.setBounds(170, 50, 450, 390);
                jt.setSize(400,500); 
             
                jt.setVisible(true); 

                 while(rs.next()) {
                	 String details=rs.getString("Grievance");
                	 tmodel.insertRow(1,new Object[]{details});
             
                    
                	 
                 }
               }
                catch(Exception e1)
                  {
             	System.out.println(e1.toString());
                  }

            }
        });
        
       
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(30, 10, 80, 50);
        contentPane.add(btnNewButton);
    }
}
