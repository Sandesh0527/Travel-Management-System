package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{
    
       JButton create, back;
       JTextField tfname, tfusername, tfpassword, tfanswer;
       Choice security;
       
                        
    Signup() {
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);
        
         tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(50, 60, 125, 25);
        p1.add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        
         JLabel lblpassword = new JLabel("Password");
         lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
         lblpassword.setBounds(50, 100, 125, 25);
         p1.add(lblpassword);
        
          tfpassword = new JTextField();
         tfpassword.setBounds(190, 100, 180, 25);
         tfpassword.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfpassword);
        
        
         JLabel lblsecurity = new JLabel("Security Question");
         lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
         lblsecurity.setBounds(50, 140, 125, 25);
         p1.add(lblsecurity);
        
        
        security = new Choice();
        security.add("Fav Character from The Boys");
        security.add("Fav Cricketer");
        security.add("Your Lucky Number");
        security.add("Your fav Coding language");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);
        
        
         JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(50, 180, 125, 25);
        p1.add(lblanswer);
        
         tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
         p1.add(tfanswer);
        
        
          create = new JButton("Create");
         create.setBackground(Color.WHITE);
         create.setForeground(new Color(133, 193, 233));
         create.setFont(new Font("Tahoma", Font.BOLD, 14));
         create.setBounds(80, 250, 100, 30);
         create.addActionListener(this);
         p1.add(create);
         
         
          back = new JButton("Back");
         back.setBackground(Color.WHITE);
         back.setForeground(new Color(133, 193, 233));
         back.setFont(new Font("Tahoma", Font.BOLD, 14));
         back.setBounds(250, 250, 100, 30);
         back.addActionListener(this);
         p1.add(back);
         
         
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
         Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(580, 50, 250, 250);
         add(image);
         
        setVisible(true); 
    }
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == create){
              String username = tfusername.getText();
              String name = tfname.getText();
              String password = tfpassword.getText();
              String question = security.getSelectedItem();
              String answer = tfanswer.getText();
              
              
              String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')" ;
              try{
                  Conn c = new Conn(); 
                  c.s.executeUpdate(query); 
                  
                  JOptionPane.showMessageDialog(null, "Account Created Successfully");
                  
                  setVisible(false);
                  new Login();
              }  catch(Exception e){
                  e.printStackTrace();
              }
          } else if (ae.getSource() == back){
                setVisible(false);
                new Login();
          }
      }
//    private JPanel contentPane;
//    private JTextField textField;
//    private JTextField textField_1;
//    private JTextField textField_2;
//    private JTextField textField_3;
//    private JButton b1, b2;
//    private JComboBox comboBox;


    public static void main(String[] args) {
        new Signup(); //setVisible(true);
    }
}

     
//        setBounds(600, 250, 700, 406);
//	contentPane = new JPanel();
//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//	setContentPane(contentPane);
//        contentPane.setBackground(Color.WHITE);
//	contentPane.setLayout(null);
//
//	JLabel lblUsername = new JLabel("Username :");
//	lblUsername.setForeground(Color.DARK_GRAY);
//	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
//	lblUsername.setBounds(99, 86, 92, 26);
//	contentPane.add(lblUsername);
//
//	JLabel lblName = new JLabel("Name :");
//	lblName.setForeground(Color.DARK_GRAY);
//	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
//	lblName.setBounds(99, 123, 92, 26);
//	contentPane.add(lblName);
//
//	JLabel lblPassword = new JLabel("Password :");
//	lblPassword.setForeground(Color.DARK_GRAY);
//	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
//	lblPassword.setBounds(99, 160, 92, 26);
//	contentPane.add(lblPassword);
//
//	JLabel lblAnswer = new JLabel("Answer :");
//	lblAnswer.setForeground(Color.DARK_GRAY);
//	lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
//	lblAnswer.setBounds(99, 234, 92, 26);
//	contentPane.add(lblAnswer);
//
//	comboBox = new JComboBox();
//	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
//			"Your child SuperHero?", "Your childhood Name ?" }));
//	comboBox.setBounds(265, 202, 148, 20);
//	contentPane.add(comboBox);
//
//	JLabel lblSecurityQuestion = new JLabel("Security Question :");
//	lblSecurityQuestion.setForeground(Color.DARK_GRAY);
//	lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
//	lblSecurityQuestion.setBounds(99, 197, 140, 26);
//	contentPane.add(lblSecurityQuestion);
//        
//        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
//        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i1);
//        
//        JLabel l6 = new JLabel(i2);
//        l6.setBounds(460, 70, 200, 200);
//        add(l6);
//
//        textField = new JTextField();
//	textField.setBounds(265, 91, 148, 20);
//	contentPane.add(textField);
//	textField.setColumns(10);
//
//	textField_1 = new JTextField();
//	textField_1.setColumns(10);
//	textField_1.setBounds(265, 128, 148, 20);
//	contentPane.add(textField_1);
//
//        textField_2 = new JTextField();
//	textField_2.setColumns(10);
//	textField_2.setBounds(265, 165, 148, 20);
//	contentPane.add(textField_2);
//
//	textField_3 = new JTextField();
//	textField_3.setColumns(10);
//	textField_3.setBounds(265, 239, 148, 20);
//	contentPane.add(textField_3);
//
//	b1 = new JButton("Create");
//	b1.addActionListener(this);
//	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
//	b1.setBounds(140, 289, 100, 30);
//        b1.setBackground(Color.BLACK);
//        b1.setForeground(Color.WHITE);
//	contentPane.add(b1);
//
//	b2 = new JButton("Back");
//	b2.addActionListener(this);
//	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
//	b2.setBounds(300, 289, 100, 30);
//	b2.setBackground(Color.BLACK);
//        b2.setForeground(Color.WHITE);
//	contentPane.add(b2);
//
//	JPanel panel = new JPanel();
//	panel.setForeground(new Color(34, 139, 34));
//	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
//			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
//	panel.setBounds(31, 30, 640, 310);
//        panel.setBackground(Color.WHITE);
//	contentPane.add(panel);
//    }
//    
//    public void actionPerformed(ActionEvent ae){
//        try{
//            Conn con = new Conn();
//            
//            if(ae.getSource() == b1){
//                String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";
//		PreparedStatement st = con.c.prepareStatement(sql);
//
//		st.setString(1, textField.getText());
//                st.setString(2, textField_1.getText());
//		st.setString(3, textField_2.getText());
//		st.setString(4, (String) comboBox.getSelectedItem());
//		st.setString(5, textField_3.getText());
//
//		int i = st.executeUpdate();
//		if (i > 0){
//                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
//                }
//
//                textField.setText("");
//                textField_1.setText("");
//		textField_2.setText("");
//		textField_3.setText("");
//            }
//            if(ae.getSource() == b2){
//                this.setVisible(false);
//                new Login().setVisible(true);
//			
//            }
//        }catch(Exception e){
//                System.out.println(e);
//        }
//    }
//}