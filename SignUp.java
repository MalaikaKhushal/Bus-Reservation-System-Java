package busreservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignUp extends JFrame
{

    JFrame frm=new JFrame();
    
    JLabel signup =new JLabel();
    JLabel name =new JLabel();
    JLabel user=new JLabel();
    JLabel pass=new JLabel();
    
    JTextField txtnam=new JTextField();
    JTextField txtuser =new JTextField();
    JPasswordField txtpass =new JPasswordField();
    
    JButton save=new JButton();
    JButton cancel=new JButton();
    
    Color cl= new Color(0,173,239);
    
    
    public SignUp()
    {
    frm.setBounds(450,180,350,500);
    frm.getContentPane().setBackground(cl);
    frm.setTitle("SIGNUP");
    frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    frm.setVisible(true);
    frm.setLayout(null);
    
    signup.setText("SIGNUP");
    signup.setBounds(135,10,100,50);
    signup.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
    signup.setForeground(Color.white);
    frm.add(signup);
    
    
    name.setText("Name:");
    name.setBounds(50, 75, 150, 50);
    name.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
    name.setForeground(Color.white);
    frm.add(name);
    
    txtnam.setBounds(115, 85, 200, 35);
    frm.add(txtnam);
    
    user.setText("User Name:");
    user.setBounds(5, 135, 150, 50);
    user.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
    user.setForeground(Color.white);
    frm.add(user);
    
    txtuser.setBounds(115, 145, 200, 35);
    frm.add(txtuser);
    
    pass.setText("Password:");
    pass.setBounds(15, 195, 150, 50);
    pass.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
    pass.setForeground(Color.white);
    frm.add(pass);
    
    txtpass.setBounds(115, 205, 200, 35);
    frm.add(txtpass);
    
    save.setText("SIGN UP");
    save.setBounds(65, 310, 100, 40);
    save.setBackground(Color.white);
    save.addActionListener(new eventhandeler());
    frm.add(save);
    
    cancel.setText("CANCEL");
    cancel.setBounds(195, 310, 100, 40);
    cancel.setBackground(Color.white);
    cancel.addActionListener(new eventhandeler());
    frm.add(cancel);
    }
    
    public class eventhandeler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        String var=e.getActionCommand();
        if(var.compareTo("SIGN UP")==0){
            
            try{
            FileWriter signupfile=new FileWriter("Signup File.txt",true);
            
            String pass=String.valueOf(txtpass.getPassword());
            signupfile.write(txtnam.getText()+","+txtuser.getText()+","+pass+"\n");
            
            JOptionPane.showMessageDialog(frm, "Sign Up Successfully!");
            signupfile.close();
            }
            catch(Exception ex){
             System.out.println("A eror is found in Writing File");
            }
            
            frm.dispose();   
        }
        else if(var.compareTo("CANCEL")==0){
            frm.dispose();
        }
        }
    
    
    }
   
}