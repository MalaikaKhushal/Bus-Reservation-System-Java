package busreservationsystem;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;



public class cancelbus extends JFrame{
    
    JFrame busfrm =new JFrame();
    JButton book=new JButton();
    JButton back=new JButton();
    JLabel head=new JLabel();


    JLabel priceLabel = new JLabel("Price: ");
    JLabel timeLabel = new JLabel("Time: ");
    Color col = new Color(0, 173, 239);

    JComboBox<String> from;
    JComboBox<String> to;
    JComboBox<String> day;
    
    
            
    String[] fromCity = new String[1000];
    String[] toCity = new String[1000];
    String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    
            public cancelbus(){
            
        

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
            FileWriter SelectedBus=new FileWriter(fromCity[from.getSelectedIndex()]+" to "+toCity[to.getSelectedIndex()]+ " - "+ days[day.getSelectedIndex()] + ".txt",true);
            SelectedBus.close();
            }
            catch(Exception ex){
             System.out.println("A eror is found in Writing File");
            }
            
        busfrm.dispose();
        cancel c=new cancel();
        c.carry(fromCity[from.getSelectedIndex()],toCity[to.getSelectedIndex()],days[day.getSelectedIndex()]);    
        }
        
        else if(var.compareTo("Back")==0)
        {
            busfrm.dispose();
        }
        
        }

    }
    
}