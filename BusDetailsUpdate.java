package busreservationsystem;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class BusDetailsUpdate extends JFrame implements ActionListener {
    JTextField busNoField, fromField, toField, timeField, dayField, priceField;
    JButton updateButton, addButton;

    public BusDetailsUpdate() {
        setTitle("Bus Schedule - Admin Panel");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(0, 173, 239));
        setLocationRelativeTo(null);

        JLabel lbl1 = new JLabel("Bus No:");
        lbl1.setBounds(30, 30, 100, 25);
        add(lbl1);

        JLabel lbl2 = new JLabel("From:");
        lbl2.setBounds(30, 65, 100, 25);
        add(lbl2);

        JLabel lbl3 = new JLabel("To:");
        lbl3.setBounds(30, 100, 100, 25);
        add(lbl3);

        JLabel lbl4 = new JLabel("Time:");
        lbl4.setBounds(30, 135, 100, 25);
        add(lbl4);

        JLabel lbl5 = new JLabel("Day:");
        lbl5.setBounds(30, 170, 100, 25);
        add(lbl5);

        JLabel lbl6 = new JLabel("Price (PKR):");
        lbl6.setBounds(30, 205, 100, 25);
        add(lbl6);

        busNoField = new JTextField();
        fromField = new JTextField();
        toField = new JTextField();
        timeField = new JTextField();
        dayField = new JTextField();
        priceField = new JTextField();

        busNoField.setBounds(150, 30, 280, 25);
        fromField.setBounds(150, 65, 280, 25);
        toField.setBounds(150, 100, 280, 25);
        timeField.setBounds(150, 135, 280, 25);
        dayField.setBounds(150, 170, 280, 25);
        priceField.setBounds(150, 205, 280, 25);

        add(busNoField);
        add(fromField);
        add(toField);
        add(timeField);
        add(dayField);
        add(priceField);

        updateButton = new JButton("Update");
        updateButton.setBounds(90, 260, 120, 30);
        updateButton.addActionListener(this);
        add(updateButton);

        addButton = new JButton("Add New");
        addButton.setBounds(250, 260, 120, 30);
        addButton.addActionListener(this);
        add(addButton);
        
        dispose();
        
        

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String busNo = busNoField.getText().trim();
        String from = fromField.getText().trim();
        String to = toField.getText().trim();
        String time = timeField.getText().trim();
        String day = dayField.getText().trim();
        String price = priceField.getText().trim();

        if (busNo.isEmpty() || from.isEmpty() || to.isEmpty() || time.isEmpty() || day.isEmpty() || price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!");
            return;
        }

        File file = new File("buses.txt");
        File temp = new File("temp_buses.txt");
        boolean updated = false;

        if (e.getSource() == updateButton) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 6 && parts[0].equalsIgnoreCase(busNo)) {
                        writer.write(busNo + "," + from + "," + to + "," + time + "," + day + "," + price);
                        updated = true;
                    } else {
                        writer.write(line);
                    }
                    writer.newLine();
                }
                reader.close();
                writer.close();

                if (updated) {
                    file.delete();
                    temp.renameTo(file);
                    dispose();
                    JOptionPane.showMessageDialog(this, "Bus details updated!");
                    
                    
                } 
                
                else 
                {
                    temp.delete();
                    JOptionPane.showMessageDialog(this, "Bus not found!");
                }
                
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error updating file!");
                
            }

        } else if (e.getSource() == addButton) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(busNo + "," + from + "," + to + "," + time + "," + day + "," + price);
                writer.newLine();
                dispose();
                JOptionPane.showMessageDialog(this, "New Bus added successfully!\nBus No:        " + busNo + "\nRoute:         \t" + from + "  --->  " + to + "\nTime:         \t" + time + "\nDay:    \t      " + day + "\nTicket Price:  \t" + price);
                
                
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file.");
            }
        }
    }
}
