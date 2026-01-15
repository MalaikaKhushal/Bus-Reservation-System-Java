package busreservationsystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class busstatus extends JFrame{
    
    JFrame busfrm =new JFrame();
    JButton book=new JButton();
    JButton back=new JButton();
    JLabel head=new JLabel();
    Color col=new Color(0,173,239);
    JComboBox<String> from;
    JComboBox<String> to;
    JComboBox<String> day;
    
    String[] fromCity = new String[1000];
    String[] toCity = new String[1000];
    String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    
    public busstatus()
    {
               
        

            try {
                BufferedReader reader = new BufferedReader(new FileReader("buses.txt"));
                String line;
                int i = 0;                
                
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 6) 
                    {
                        
                        fromCity[i] = parts[1];
                        toCity[i] = parts[2].trim();
                        i++;

                    }    
                }
            }
            
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(busfrm, "Error reading buses.txt");
                return;
            }
            
        busfrm.setBounds(320, 100, 400, 550);
        busfrm.setVisible(true);
        busfrm.setTitle("Bus Reservation System");
        busfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        busfrm.setLayout(null);
        busfrm.getContentPane().setBackground(col);

        head.setText("Search Bus");
        head.setBounds(120, 30, 200, 35);
        head.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        head.setForeground(Color.white);
        busfrm.add(head);

        from = new JComboBox<>(fromCity);
        from.setBounds(50, 80, 275, 35);
        busfrm.add(from);

        to = new JComboBox<>(toCity);
        to.setBounds(50, 130, 275, 35);
        busfrm.add(to);

        JLabel dayLabel = new JLabel("Day:");
        dayLabel.setBounds(50, 180, 100, 30);
        dayLabel.setForeground(Color.white);
        busfrm.add(dayLabel);

        day = new JComboBox<>(days);
        day.setBounds(120, 180, 205, 35);
        busfrm.add(day);

        book.setText("Search Bus");
        book.setBounds(135, 330, 100, 40);
        book.setBackground(Color.white);
        book.addActionListener(new eventhandling());
        busfrm.add(book);
        
        back.setText("Back");
        back.setBounds(135, 380, 100, 40);
        back.setBackground(Color.RED);
        back.addActionListener(new eventhandling());
        busfrm.add(back);
                   
    }
    
    public class eventhandling implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {   
        String var=e.getActionCommand();
        
        if(var.compareTo("Search Bus")==0)
        {
            try{
            FileWriter SelectedBus=new FileWriter(fromCity[from.getSelectedIndex()]+" to "+toCity[to.getSelectedIndex()]+" - "+days[day.getSelectedIndex()]+".txt",true);
            SelectedBus.close();
            }
            catch(Exception ex){
             System.out.println("A eror is found in Writing File");
            }
        busfrm.dispose();
        newseats b=new newseats();
        b.carry(fromCity[from.getSelectedIndex()],toCity[to.getSelectedIndex()],days[day.getSelectedIndex()]);    
        }
        
        else if(var.compareTo("Back")==0)
        {
            busfrm.dispose();
        }
        
        }

    }

    
public class newseats {
    
 Color col=new Color(0,173,239);   
    
 JFrame seatfrm =new JFrame();
 
 ImageIcon a=new ImageIcon(this.getClass().getResource("avail.png"));
 ImageIcon m=new ImageIcon(this.getClass().getResource("male.png"));
 ImageIcon s=new ImageIcon(this.getClass().getResource("steering.png"));
 
 JLabel avail=new JLabel(a);
 JLabel male=new JLabel(m);
 JLabel steering=new JLabel(s);
 
 JButton[] btn=new JButton[37];
 
 String from,to,day;

 public void carry(String a,String b,String d)
 {
   from=a;
   to=b;
   day=d;
 } 
 
 
 public newseats()
 {
            seatfrm.addWindowListener(new windows());
            seatfrm.setBounds(500,30,400,850);
            seatfrm.setVisible(true);
            seatfrm.setTitle("Bus Reservation System");
            seatfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            seatfrm.getContentPane().setBackground(Color.white);
            seatfrm.setLayout(null); 
            
            avail.setText("Available");
            avail.setBounds(5, 40,135,60);
            avail.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
            seatfrm.add(avail);
            
            male.setText("Reserved");
            male.setBounds(0, 85,150,60);
            male.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
            seatfrm.add(male);

            steering.setBounds(240, 30,s.getIconWidth(),s.getIconHeight());
            seatfrm.add(steering);

            
            for(int i=0;i<=36;i++)
            {
                btn[i]=new JButton();
                seatfrm.add(btn[i]);
                btn[i].setBackground(Color.white);
                btn[i].setText(String.valueOf(i));
            }
                btn[0].setBounds(30,190, 47, 46);
                btn[0].setText("C");
                btn[0].setForeground(Color.WHITE);
                btn[0].setBackground(Color.red);
                btn[1].setBounds(90,190, 47, 46);
                btn[2].setBounds(240,190, 47, 46);    
                btn[3].setBounds(300,190, 47, 46);
                
                btn[4].setBounds(30,250, 47, 46);    
                btn[5].setBounds(90,250, 47, 46);
                btn[6].setBounds(240,250, 47, 46);    
                btn[7].setBounds(300,250, 47, 46);
                
                btn[8].setBounds(30,310, 47, 46);    
                btn[9].setBounds(90,310, 47, 46);
                btn[10].setBounds(240,310, 47, 46);    
                btn[11].setBounds(300,310, 47, 46);
                
                btn[12].setBounds(30,370, 47, 46);    
                btn[13].setBounds(90,370, 47, 46);
                btn[14].setBounds(240,370, 47, 46);    
                btn[15].setBounds(300,370, 47, 46);
                
                btn[16].setBounds(30,430, 47, 46);    
                btn[17].setBounds(90,430, 47, 46);
                btn[18].setBounds(240,430, 47, 46);    
                btn[19].setBounds(300,430, 47, 46);
                
                btn[20].setBounds(30,490, 47, 46);    
                btn[21].setBounds(90,490, 47, 46);
                btn[22].setBounds(240,490, 47, 46);    
                btn[23].setBounds(300,490, 47, 46);
                
                btn[24].setBounds(30,550, 47, 46);    
                btn[25].setBounds(90,550, 47, 46);
                btn[26].setBounds(240,550, 47, 46);    
                btn[27].setBounds(300,550, 47, 46);
                
                btn[28].setBounds(30,610, 47, 46);    
                btn[29].setBounds(90,610, 47, 46);
                btn[30].setBounds(240,610, 47, 46);    
                btn[31].setBounds(300,610, 47, 46);
                
                btn[32].setBounds(30,670, 47, 46);    
                btn[33].setBounds(90,670, 47, 46);
                btn[34].setBounds(167,670, 47, 46);
                btn[35].setBounds(240,670, 47, 46);    
                btn[36].setBounds(300,670, 47, 46);          
                
                back.setText("Back");
                back.setBounds(135, 750, 100, 40);
                back.setBackground(Color.RED);
                back.addActionListener(new eventhandling());
                seatfrm.add(back);
 }

    public class eventhandling implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {   
        String var=e.getActionCommand();
        if(var.compareTo("Back")==0)
        {
            seatfrm.dispose();
        }
        
        }

    }

 
public class windows implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
    
    String [] tempd;
    String [] seats=new String[36];
    int n=0;
    
         try{
        File f=new File(from+" to "+to+" - "+day+".txt");
        Scanner input=new Scanner(f);
        while(input.hasNext()){
        String signindata=input.nextLine();
        tempd=signindata.split(",");
        seats[n]=tempd[0];
        n++;
        }
        for(int i=0;i<seats.length;i++){
        int temps=Integer.parseInt(seats[i]);
        btn[temps].setBackground(col);
        btn[temps].setForeground(Color.WHITE);
        }
        input.close();
        }

        catch(Exception ex){
            System.out.println("");
        }

        }

        @Override
        public void windowClosing(WindowEvent e) {
            
        }

        @Override
        public void windowClosed(WindowEvent e) {
            
         }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            
         }
    }


}

}