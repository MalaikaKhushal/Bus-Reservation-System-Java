package busreservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignIn extends JFrame {
    
    JFrame frm =new JFrame();
    JTextField User=new JTextField();
    ImageIcon bus=new ImageIcon(this.getClass().getResource("BUS-Ticketing-Management.jpg"));
    JPasswordField pass=new JPasswordField();
    JLabel lbmain=new JLabel();
    JLabel Signin=new JLabel();
    JButton sbtn=new JButton();
    JButton lbtn=new JButton();
    JButton admin=new JButton();
    Color c=new Color(0,173,239);
    
    public SignIn()
    {
        frm.setTitle("Bus Reservation System");
        frm.setBounds(180,130,1091,550);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm.getContentPane().setBackground(Color.white);
        frm.setLayout(null);
        frm.add(lbmain);
        
        
        lbmain.setBounds(400,0, bus.getIconWidth(), bus.getIconHeight());
        lbmain.setIcon(bus);
        
       
        Signin.setText("SIGN IN");
        Signin.setBounds(160, 50, 100,100);
        Signin.setForeground(c);
        Signin.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        frm.add(Signin);
        
        
        frm.add(User);
        User.setText("Enter your Username");
        User.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
        User.setBounds(70, 180, 250, 40);
        User.addMouseListener(new mouse());
        
        
        frm.add(pass);
        pass.setText("Enter your Password");
        pass.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
        pass.setBounds(70, 250, 250, 40);
        
        
        sbtn.setText("SIGN UP");
        sbtn.setBounds (205, 320, 100, 40);
        sbtn.setBackground(c);
        sbtn.setForeground(Color.white);
        sbtn.addActionListener(new eventhandling1());
        frm.add(sbtn);
        
        
        lbtn.setText("LOG IN");
        lbtn.setBounds(90, 320, 100, 40);
        lbtn.setBackground(c);
        lbtn.setForeground(Color.white);
        lbtn.addActionListener(new eventhandling1());
        frm.add(lbtn);
        
        
        admin.setText("For Admin Login");
        admin.setBounds(124, 370, 150, 40);
        admin.setBackground(c);
        admin.setForeground(Color.white);
        admin.addActionListener(new eventhandling1());
        frm.add(admin);
       
        setVisible(true);
    }
    
    public class eventhandling1 implements ActionListener{
    
        String [] username=new String[100];
        String [] password=new String[100];
        String [] temp;
        int n=0;
        
        @Override
        public void actionPerformed(ActionEvent e) {
        String var=e.getActionCommand();
        
        try{
        File f=new File("Signup File.txt");
        Scanner input=new Scanner(f);
        
        while(input.hasNext()){
        String signindata=input.nextLine();
        temp=signindata.split(",");
        username[n]=temp[1];
        password[n]=temp[2];
        n++;
        }
        
        input.close();
        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
        } 
        
        try{
        if(var.compareTo("LOG IN")==0){
            String Password=String.valueOf(pass.getPassword());
            for(int i=0;i<username.length;i++){
            if(User.getText().compareTo(username[i])==0&&Password.compareTo(password[i])==0){
                frm.dispose();
                mainpage m=new mainpage();
               
                break;
            }
            }
        }
        else if(var.compareTo("SIGN UP")==0){
        
        SignUp s1=new SignUp();
        }
        
        else if(var.compareTo("For Admin Login")==0){
        
        AdminSignIn s1 =new AdminSignIn();
        }
        
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(frm, "Username or Password is incorrect!");
                }
        }  
        }

    
    public class mouse implements MouseListener{
        
        @Override
        public void mouseClicked(MouseEvent e) {
            User.setText("");
            pass.setText("");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {  
        }

        @Override
        public void mouseExited(MouseEvent e) {  
        }
    
    }
    
    }