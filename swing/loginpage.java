package net.javaguides.swing;
import java.awt.Container;
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
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class loginpage extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton b1;   
    private JLabel userLabel, passLabel;  
    private JTextField  textField1, textField2;  
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginpage frame = new loginpage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public loginpage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        setSize(400, 450);
        //setBounds(450, 190, 500, 500);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        userLabel = new JLabel();  
        userLabel.setText("Username:");      
        userLabel.setFont(new Font("Calibri", Font.BOLD, 14));
       userLabel.setBounds(50,72,220,58);
        contentPane.add(userLabel);
 
        textField1 = new JTextField();  
        textField1.setFont(new Font("Calibri", Font.PLAIN, 14));
        textField1.setBounds(50,110, 200, 38);
        contentPane.add(textField1);

        passLabel = new JLabel();  
        passLabel.setText("Password:");        
         passLabel.setFont(new Font("Calibri", Font.BOLD, 14));
passLabel.setBounds(50,152,220,58); 
contentPane.add(passLabel);

textField2 = new JPasswordField();     
textField2.setFont(new Font("Calibri", Font.PLAIN, 14));
textField2.setBounds(50,190, 200, 38);
contentPane.add(textField2);

b1 = new JButton("LOGIN");  

        
        //btnNewBut = new JButton("Login");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String userValue = textField1.getText();         
                String passValue = textField2.getText();        
                  
                
                      
                try {
                    if (userValue.equals("user") && passValue.equals("user")) {    
                	UserRegistration u=new UserRegistration();
                	u.setVisible(true);
//                	this.setVisible(false);
                	  
                    }
                    else if(userValue.equals("admin") && passValue.equals("admin")) {
                    	ReadValue v=new ReadValue();
                    	v.setVisible(true);
                    }
                  else {
            	   //ReadValue v=new ReadValue();
            	   //v.setVisible(true);
                   System.out.println("Please enter valid username and password");  
 
                    }
                	
                }
                catch(Exception e1) {
                 	System.out.println(e1.toString());

                }
                

            }
        });
        b1.setFont(new Font("Calibri", Font.BOLD, 14));
        b1.setBounds(100, 240, 100, 38);
        contentPane.add(b1);

   }

}
