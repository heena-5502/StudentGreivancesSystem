package net.javaguides.swing;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.*;
/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField fname;
    private JTextField Iname;
    private JTextField mail;
    private JTextField num;
    private JTextField year;
    private JTextField dept;
    private JTextArea feed;

    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Grievance management system");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        lblNewUserRegister.setBounds(100, 0, 440, 45);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name *");
        lblName.setFont(new Font("Calibri", Font.BOLD, 14));
        lblName.setBounds(50,72,220,58);
        contentPane.add(lblName);
        fname = new JTextField();
        fname.setFont(new Font("Calibri", Font.PLAIN, 14));
        fname.setBounds(50,110, 200, 38);
        contentPane.add(fname);

        JLabel mmail= new JLabel("E-mail *");
        mmail.setFont(new Font("Calibri", Font.BOLD, 14));
        mmail.setBounds(50,152,220,58);
        contentPane.add(mmail);
        
        mail = new JTextField();
        mail.setFont(new Font("Calibri", Font.PLAIN, 14));
        mail.setBounds(50,190, 200, 38);
        contentPane.add(mail);

        JLabel cno= new JLabel();
        cno.setText("Contact No *");
        cno.setFont(new Font("Calibri", Font.BOLD, 14));
        cno.setBounds(50,232,220,58);
        contentPane.add(cno);
        
        num = new JTextField();
        num.setFont(new Font("Calibri", Font.PLAIN, 14));
        num.setBounds(50,270, 200, 38);
        contentPane.add(num);
 
        JLabel yr= new JLabel();
        yr.setText("Year *");
        yr.setFont(new Font("Calibri", Font.BOLD, 14));
        yr.setBounds(50,312,220,58);
        contentPane.add(yr);

        year = new JTextField();
        year.setFont(new Font("Calibri", Font.PLAIN, 14));
        year.setBounds(50,350, 200, 38);
        contentPane.add(year);
        
        JLabel dp= new JLabel();
        dp.setText("Department *");
        dp.setFont(new Font("Calibri", Font.BOLD, 14));
        dp.setBounds(50,392,220,58);
        contentPane.add(dp);
         
        dept= new JTextField();
        dept.setFont(new Font("Calibri", Font.PLAIN, 14));
        dept.setBounds(50,432, 200, 38);
        contentPane.add(dept);
        
        JLabel type1=new JLabel();
        type1.setText("Grievance details *");
        type1.setFont(new Font("Calibri", Font.BOLD, 14));
        type1.setBounds(300,72,200,58);
        contentPane.add(type1);
        
        feed = new JTextArea();
        feed.setFont(new Font("Calibri", Font.PLAIN, 14));
        feed.setBounds(300,118, 250, 248);
        feed.setLineWrap(true);
        contentPane.add(feed);
        

        btnNewButton = new JButton("SUBMIT");
        btnNewButton.addActionListener(new ActionListener() {
        	 boolean flag=false;
             String emailvalidation = "^[a-zA-Z0-9+_.-]+@(.+)$";  
             Pattern p= Pattern.compile(emailvalidation);
             Matcher mat= p.matcher(mail.getText());
            JFrame f= new JFrame();
            public void actionPerformed(ActionEvent e) {
                try
                {
                	if((feed.getText().isEmpty()) || (feed.getText() == null))
                    {
                        JOptionPane.showMessageDialog(f, "Grievance details cannot be empty");
                    }
                    else if((fname.getText().isEmpty()) || (fname.getText() == null))
                    {
                        JOptionPane.showMessageDialog(f, "First Name cannot be empty");
                    }
        else if((num.getText().isEmpty()) || (num.getText() == null))
                    {
                        JOptionPane.showMessageDialog(f, "Contact No cannot be empty");
                    }
                    else if((mail.getText().isEmpty()) || (mail.getText() == null))
                    {
                        JOptionPane.showMessageDialog(f, "Email cannot be empty");
                    }
                   // else if(!mat.matches())
                    //{
                      //  JOptionPane.showMessageDialog(f, "Please Enter a valid Email");
                //    }
                else if((year.getText().isEmpty()) || (year.getText() == null))
                    {
                        JOptionPane.showMessageDialog(f, "Year cannot be empty");
                    }else if((dept.getText().isEmpty()) || (dept.getText() == null))
                    {
                        JOptionPane.showMessageDialog(f, "Department cannot be empty");
                    }
                    else
                        flag=true; 
                        
                    if(flag)
                    {
                        
                        String s1= "Thank you for your valuable response!\n\nYour Responses are:\n";
                        String s2= "Name: "+fname.getText()+"\nEmail: "+mail.getText()+"\nContact No:"+num.getText()+"\nYear:"+year.getText()+"\nDepartment:"+dept.getText()+"\nGrievance Details:"+feed.getText();
                        String disp=s1+s2;
                        JOptionPane.showMessageDialog(f, disp);
                    
                	 String gName = fname.getText();
                     String gEmail= mail.getText();
                     String gContactNo = num.getText();
                     String gYear=year.getText();
                     String gDepartment=dept.getText();
                     String gGrievance=feed.getText();
                     
                 Connection con;
                 Class.forName("org.postgresql.Driver");
                 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123" );		        
                 String sql = "INSERT INTO feedback2 VALUES('"+gName+"','"+gEmail+"','"+gContactNo+"','"+gYear+"','"+gDepartment+"','"+gGrievance+"')";	  
               //  String sql="INSERT INTO weatherhistory VALUES ('"+formattedDate+"','"+r1+"','"+cit    +"')" ;
             
                Statement statement = con.createStatement();
               statement.executeUpdate(sql);			
                 JOptionPane.showMessageDialog(null, "Record Added Succssfully");	
                  fname.setText("");
                  fname.requestFocus();
                  mail.setText("");
                  num.setText("");
                  year.setText("");
                  dept.setText("");
                  feed.setText("");
                  
                }}
                catch(Exception e1)
                  {
             	System.out.println(e1.toString());
                  }
            }                    });
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
        btnNewButton.setBounds(360, 400, 100, 38);
        contentPane.add(btnNewButton);
        
        
    }

}
