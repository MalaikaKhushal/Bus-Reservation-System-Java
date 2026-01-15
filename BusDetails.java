package busreservationsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class BusDetails extends JFrame {
    JTable table;
    DefaultTableModel model;
    JButton backButton;
    Color c=new Color(0,173,239);
    
    public BusDetails() {
        setTitle("BUSS DETAILS");
        setSize(800, 500);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 173, 239));
        setLocationRelativeTo(null);

        JLabel title = new JLabel("BUSS DETAILS");
        title.setBounds(300, 10, 300, 40);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        add(title);

        String[] columnNames = {"Bus No", "FROM", "TO", "TIME", "DAY", "PRICE (PKR)"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setBackground(c);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20, 70, 740, 300);
        add(pane);

        loadBusData();

        backButton = new JButton("BACK");
        backButton.setBounds(330, 390, 120, 30);
        backButton.setBackground(Color.RED);
        add(backButton);
        backButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void loadBusData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("buses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    model.addRow(parts);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to load bus details.");
        }
    }
}
