package busreservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class details extends JFrame
{
    JFrame detailfrm =new JFrame();
    JTextField name=new JTextField();
    JTextField cnic=new JTextField();
    JTextField Contact=new JTextField();
    
    JLabel n=new JLabel();
    JLabel c=new JLabel();
    JLabel cn=new JLabel();
    JLabel d=new JLabel();
    JLabel s=new JLabel();
    JLabel g=new JLabel();
    JLabel head=new JLabel();

    
    JButton book = new JButton();
    JButton Reset = new JButton();
    JButton cancel=new JButton();

    
    Color col=new Color(0,173,239);
        String from,to,day,time,price;
        
        public void carry2(String b,String o, String d, String t, String p)
        {
            from=b;
            to=o;
            day = d;
            time = t;
            price = p;
            
        }
        
    public details()
    {
        
            detailfrm.setBounds(320,100,400,600);
            detailfrm.setVisible(true);
            detailfrm.setTitle("Bus Reservation System");
            detailfrm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            detailfrm.getContentPane().setBackground(Color.white);
            detailfrm.setLayout(null);
            detailfrm.getContentPane().setBackground(col);
            
            head.setText("PASSENGER DETAILS");
            head.setBounds(70, 50, 250, 35);
            head.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 22));
            head.setForeground(Color.white);
            detailfrm.add(head);
            
            
            
            n.setText("Name:");
            n.setBounds(30, 130, 100, 50);
            n.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 18));
            n.setForeground(Color.white);
            detailfrm.add(n);
            detailfrm.add(name);
            name.setBounds(160, 140, 200, 35);
            
            cn.setText("Cnic:");
            cn.setBounds(30, 210, 100, 50);
            cn.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 18));
            cn.setForeground(Color.white);
            detailfrm.add(cn);
            detailfrm.add(cnic);
            cnic.setBounds(160, 220, 200, 35); 
            
            c.setText("Contact #");
            c.setBounds(30, 290, 100, 50);
            c.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 18));
            c.setForeground(Color.white);
            detailfrm.add(c);
            detailfrm.add(Contact);
            Contact.setBounds(160, 300, 200, 35);


            book.setBounds(100, 400, 100, 40);
            book.setText("BOOK");
            book.setBackground(Color.white);
            book.addActionListener(new eventhandling1());
            detailfrm.add(book);
            
            Reset.setBounds(215, 400, 100, 40);
            Reset.setText("CANCEL");
            Reset.setBackground(Color.white);
            Reset.addActionListener(new eventhandling1());
            detailfrm.add(Reset);
            
    }

    public class eventhandling1 implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        String var=e.getActionCommand();
            
        if(var.compareTo("BOOK")==0){
        try{
           FileWriter f=new FileWriter(from+" to "+to+" - "+ day+ ".txt",true);
               f.write(","+name.getText()+","+Contact.getText()+","+cnic.getText()+","+day+","+time+","+price+"\n");
                              
               JOptionPane.showMessageDialog(detailfrm, "Seat Booked Successfully!\n Details: " +from+ " to "+to + "\n Day:  "+day+"\nTime:  "+time+"\nTicket Price:  "+price );
               detailfrm.dispose();
               f.close();
           }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }    
        }  
        
        else if(var.compareTo("CANCEL")==0)
        {
            detailfrm.dispose();
        }
        }          
    }
    
}