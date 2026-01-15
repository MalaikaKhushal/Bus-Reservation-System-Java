package busreservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class cancel extends JFrame {
    JFrame cancelfrm=new JFrame();
    JLabel head=new JLabel();
    JButton ret=new JButton();
    JButton back=new JButton();
    
    Color c=new Color(0,173,239);
    
    JTable table;
    DefaultTableModel tmod;
    JScrollPane sc;
    FileWriter fr;
    
 String from,to,day;
 
    public void carry(String a,String b, String d)
 {
   from=a;
   to=b;
   day=d;
 } 

    public cancel(){
            cancelfrm.setTitle("Bus Reservation System");
            cancelfrm.addWindowListener(new windows());
            cancelfrm.setBounds(180,60,950,700);
            cancelfrm.setVisible(true);
            cancelfrm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            cancelfrm.getContentPane().setBackground(Color.white);
            cancelfrm.setLayout(null);
            cancelfrm.getContentPane().setBackground(c);
            
            head.setText("PASSENGER DETAIL");
            head.setBounds(350,30,230,50);
            head.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
            head.setForeground(Color.white);
            cancelfrm.add(head);
            
            
            ret.setText("CANCEL TICKET");
            ret.setBounds(375, 520, 150, 40);
            ret.setBackground(Color.white);
            ret.addActionListener(new eventhandling0());
            cancelfrm.add(ret);
            
            back.setText("BACK");
            back.setBounds(375, 580, 150, 40);
            back.setBackground(Color.RED);
            back.addActionListener(new eventhandling0());
            cancelfrm.add(back);
        
            String [][] data={};
            String [] cols={"Seat #","Name","Contact #","Cnic #","Day","Time","Ticket Price"};
        
            tmod=new DefaultTableModel(data,cols);
            table=new JTable(tmod);
            
           
        
            sc=new JScrollPane(table);
            sc.setBounds(5,135,925,300);
            table.setGridColor(Color.WHITE);
            table.setBackground(c);
        
            table.getTableHeader().setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
            table.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
            cancelfrm.add(sc);
        
        

        
        
    }
    
    
    public class eventhandling0 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        String var=e.getActionCommand();
        
            if(var.compareTo("CANCEL TICKET")==0)
            {
                if(table.getSelectedRow()==-1)
                {
                    JOptionPane.showMessageDialog(table, "Invalid Selection");
                }
                
                
                else
                {
                    tmod.removeRow(table.getSelectedRow());
                    cancelfrm.dispose();
                   
                }
            }
            
            else if(var.compareTo("BACK")==0)
            {
                cancelfrm.dispose();
            }

       }
    }
    
 public class windows implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
        
        try{
            File f=new File(from+" to "+to+" - "+day +".txt");
            Scanner input=new Scanner(f);
            while(input.hasNext()){
            String d=input.nextLine();
            String [] data=d.split(",");
            tmod.addRow(data);
            }
            input.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }    
        }

        @Override
        public void windowClosing(WindowEvent e) {
        }
        

        @Override
        public void windowClosed(WindowEvent e) {         
        try
        {
            FileWriter fr=new FileWriter(from+" to "+to+" - "+day +".txt");
            for(int i=0; i<tmod.getRowCount(); i++)
            {
                fr.write(tmod.getValueAt(i, 0)+","+tmod.getValueAt(i, 1)+","+tmod.getValueAt(i, 2)+","+tmod.getValueAt(i, 3)+","+tmod.getValueAt(i, 4)+","+tmod.getValueAt(i, 5)+","+tmod.getValueAt(i, 6)+"\n");
            }
           fr.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
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