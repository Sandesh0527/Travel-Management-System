package travel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, password;
    JTextField tfpassword, tfusername ;
    
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        
         JPanel p1 = new JPanel();
         p1.setBackground(new Color(131, 193, 233));
         p1.setBounds(0, 0, 400, 400);
         p1.setLayout(null);
         add(p1);
         
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
         Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(100, 120, 200, 200);
         p1.add(image);
         
         JPanel p2 = new JPanel();
         p2.setLayout(null);
         p2.setBounds(400, 30, 450, 300);
         add(p2);
         
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(60, 20, 100, 25);
         lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
         p2.add(lblusername);
        
         
         tfusername = new JTextField();
         tfusername.setBounds(60, 60, 300, 30);
         tfusername.setBorder(BorderFactory.createEmptyBorder());
         p2.add(tfusername);
         
         JLabel lblpassword = new JLabel("Password");
         lblpassword.setBounds(60, 110, 100, 25);
         lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
         p2.add(lblpassword);
        
         
         tfpassword = new JTextField();
         tfpassword.setBounds(60, 150, 300, 30);
         tfpassword.setBorder(BorderFactory.createEmptyBorder());
         p2.add(tfpassword);
       
         login = new JButton("Login");
         login.setBounds(60, 200, 130, 30);
         login.setBackground(new Color(133, 193, 233));
         login.setForeground(Color.WHITE);
         login.setBorder(new LineBorder(new Color(133, 193, 233)));
         login.addActionListener(this);
         p2.add(login);
         
          signup = new JButton("Signup");
         signup.setBounds(230, 200, 130, 30);
         signup.setBackground(new Color(133, 193, 233));
         signup.setForeground(Color.WHITE);
         signup.setBorder(new LineBorder(new Color(133, 193, 233)));
         signup.addActionListener(this);
         p2.add(signup);
         
          password = new JButton("Forgot Password");
         password.setBounds(130, 250, 130, 30);
         password.setBackground(new Color(133, 193, 233));
         password.setForeground(Color.WHITE);
         password.setBorder(new LineBorder(new Color(133, 193, 233)));
         password.addActionListener(this);
         p2.add(password);
         
         JLabel text = new JLabel("Trouble in login...");
         text.setBounds(300, 250, 150, 20);
         text.setForeground(Color.RED);
         p2.add(text);
         
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login){
            
            try {
                String username = tfusername.getText();
                String pass = tfpassword.getText();
            
                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
               ResultSet rs =  c.s.executeQuery(query);
               if(rs.next()) {
                   setVisible(false);
                   new Loading(username);
               } else{
                   JOptionPane.showMessageDialog(null, "Incorrect username or password");
               }
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args){
        new Login();
    }
}

//public class Login extends JFrame implements ActionListener{
//
//	private JPanel panel;
//	private JTextField textField;
//	private JPasswordField passwordField;
//        private JButton b1,b2,b3;
//
//
//	public Login() {
//            
//	setBackground(new Color(255, 255, 204));	
//        setBounds(550, 250, 700, 400);
//		
//        panel = new JPanel();
//	panel.setBackground(Color.WHITE);
//	setContentPane(panel);
//	panel.setLayout(null);
//
//	JLabel l1 = new JLabel("Username : ");
//	l1.setBounds(124, 89, 95, 24);
//	panel.add(l1);
//
//	JLabel l2 = new JLabel("Password : ");
//	l2.setBounds(124, 124, 95, 24);
//	panel.add(l2);
//
//	textField = new JTextField();
//	textField.setBounds(210, 93, 157, 20);
//	panel.add(textField);
//	
//	passwordField = new JPasswordField();
//	passwordField.setBounds(210, 128, 157, 20);
//	panel.add(passwordField);
//
//	JLabel l3 = new JLabel("");
//	l3.setBounds(377, 79, 46, 34);
//	panel.add(l3);
//
//	JLabel l4 = new JLabel("");
//	l4.setBounds(377, 124, 46, 34);
//	panel.add(l3);
//
//        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/login.png"));
//        Image i1 = c1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i1);
//        
//        
//        JLabel l6 = new JLabel(i2);
//        l6.setBounds(480, 70, 150, 150);
//        add(l6);
//        
//        
//	b1 = new JButton("Login");
//	b1.addActionListener(this);
//                
//	b1.setForeground(new Color(46, 139, 87));
//	b1.setBackground(new Color(176, 224, 230));
//	b1.setBounds(149, 181, 113, 25);
//	panel.add(b1);
//		
//        b2 = new JButton("SignUp");
//	b2.addActionListener(this);
//	
//	b2.setForeground(new Color(139, 69, 19));
//	b2.setBackground(new Color(255, 235, 205));
//	b2.setBounds(289, 181, 113, 25);
//	panel.add(b2);
//
//	b3 = new JButton("Forgot Password");
//	b3.addActionListener(this);
//	
//        b3.setForeground(new Color(205, 92, 92));
//	b3.setBackground(new Color(253, 245, 230));
//	b3.setBounds(199, 231, 179, 25);
//	panel.add(b3);
//
//	JLabel l5 = new JLabel("Trouble in Login?");
//	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
//	l5.setForeground(new Color(255, 0, 0));
//	l5.setBounds(70, 235, 110, 20);
//	panel.add(l5);
//
//        JPanel panel2 = new JPanel();
//        panel2.setBackground(new Color(255, 255, 204));
//        panel2.setBounds(24, 40, 434, 263);
//        panel.add(panel2);
//	}
//        
//        public void actionPerformed(ActionEvent ae){
//            if(ae.getSource() == b1){
//                Boolean status = false;
//		try {
//                    Conn con = new Conn();
//                    String sql = "select * from account where username=? and password=?";
//                    PreparedStatement st = con.c.prepareStatement(sql);
//
//                    st.setString(1, textField.getText());
//                    st.setString(2, passwordField.getText());
//
//                    ResultSet rs = st.executeQuery();
//                    if (rs.next()) {
//                        this.setVisible(false);
//                        new Loading(textField.getText()).setVisible(true);
//                    } else
//			JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
//                       
//		} catch (Exception e2) {
//                    e2.printStackTrace();
//		}
//            }
//            if(ae.getSource() == b2){
//                setVisible(false);
//		Signup su = new Signup();
//		su.setVisible(true);
//            }   
//            if(ae.getSource() == b3){
//                setVisible(false);
//		ForgotPassword forgot = new ForgotPassword();
//		forgot.setVisible(true);
//            }
//        }
//        
//  	public static void main(String[] args) {
//                new Login().setVisible(true);
//	}
//
//}