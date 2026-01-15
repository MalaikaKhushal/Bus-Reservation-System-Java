package busreservationsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class mainpage extends JFrame{
    
            JFrame mainfrm =new JFrame();
            
            ImageIcon b=new ImageIcon(this.getClass().getResource("Bus-Reservation.jpg"));
            ImageIcon tb=new ImageIcon(this.getClass().getResource("ticket booking.jpg"));
            ImageIcon bs=new ImageIcon(this.getClass().getResource("bus status.jpg"));
            ImageIcon bd=new ImageIcon(this.getClass().getResource("bus details.jpg"));
            ImageIcon rt=new ImageIcon(this.getClass().getResource("return ticket.jpg"));
           
            JLabel lbmain=new JLabel();
            JButton booking=new JButton(tb);
            JButton status=new JButton(bs);
            JButton details=new JButton(bd);
            JButton cancle=new JButton(rt);
            
             Color c=new Color(0,173,239);
             
        public mainpage()
        {
            mainfrm.setTitle("Bus Reservation System");
            mainfrm.setBounds(180,90,1055,650);
            mainfrm.setVisible(true);
            mainfrm.setDefaultCloseOperation(EXIT_ON_CLOSE);
            mainfrm.getContentPane().setBackground(Color.white);
            mainfrm.setLayout(null);
            mainfrm.getContentPane().setBackground(c);
            
            
            lbmain.setBounds(0,0, b.getIconWidth(), b.getIconHeight()-140);
            lbmain.setIcon(b);
            mainfrm.add(lbmain);
            
            booking.setBounds(170,380, tb.getIconWidth()-10, tb.getIconHeight()-10);
            booking.setText("Ticket");
            booking.addActionListener(new eventhandling0());
            mainfrm.add(booking);
            
            
            status.setBounds(320,380, bs.getIconWidth()-10, bs.getIconHeight()-10);
            status.setText("Bus Status");
            status.addActionListener(new eventhandling0());
            mainfrm.add(status);
            
            details.setBounds(620,380, bd.getIconWidth()-10, bd.getIconHeight()-10);
            details.setText("busDetails");
            details.addActionListener(new eventhandling0());
            mainfrm.add(details);
            
            cancle.setBounds(770,380, rt.getIconWidth()-10, rt.getIconHeight()-10);
            cancle.setText("Cancel");
            cancle.addActionListener(new eventhandling0());
            mainfrm.add(cancle);
        }
        
        public class eventhandling0 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        String var=e.getActionCommand();
        
        if(var.compareTo("Ticket")==0){  
        Busses a=new Busses();
        }
        
        else if(var.compareTo("Cancel")==0){  
        cancelbus b=new cancelbus();
        }
        
        else if(var.compareTo("Bus Status")==0){  
        busstatus bs=new busstatus();
        }
        
        else if(var.compareTo("busDetails")==0){  
        BusDetails bd=new BusDetails();
        }
        
        }

       }
        
}