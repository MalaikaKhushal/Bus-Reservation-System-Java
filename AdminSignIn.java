package busreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminSignIn extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;
    Color c=new Color(0,173,239);

    public AdminSignIn() {
        setTitle("Admin Login");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("ADMIN LOGIN");
        title.setBounds(130, 30, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 90, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 90, 180, 30);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 180, 30);
        add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 180, 100, 30);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(c);
        loginBtn.addActionListener(new LoginHandler());
        add(loginBtn);

        setVisible(true);
        
        
    }

    private class LoginHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (user.equals("admin") && pass.equals("admin123")) 
            {
                new BusDetailsUpdate(); 
                dispose();
            } 
            
            else 
            {
                JOptionPane.showMessageDialog(null, "Invalid Admin Credentials");
            }
        }
    }

}
