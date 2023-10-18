import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AdminLoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JTextField adminField = new JTextField();
    JLabel adminLabel = new JLabel("adminID:");
    JPasswordField adminPasswordField = new JPasswordField();
    JLabel adminPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel();

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton userButton = new JButton("User Login");

    HashMap<String, String> adminIDs = new HashMap<String, String>();
    HashMap<String, String> userInfo = new HashMap<String, String>();
    AdminLoginPage (HashMap<String, String> admininfoOriginal, HashMap<String, String> userinfoOriginal) {
        adminIDs = admininfoOriginal;
        userInfo = userinfoOriginal;

        adminLabel.setBounds(50, 100, 75, 25);
        adminPasswordLabel.setBounds(50, 150, 75, 25);
        adminField.setBounds(145, 100, 200, 25);
        adminPasswordField.setBounds(145, 150, 200, 25);

        loginButton.setBounds(145, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(245, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        userButton.setBounds(180, 230, 130, 25);
        userButton.setFocusable(false);
        userButton.addActionListener(this);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        frame.add(adminField);
        frame.add(adminLabel);
        frame.add(adminPasswordField);
        frame.add(adminPasswordLabel);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(userButton);
        frame.add(messageLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userButton) {
            LoginPage loginPage = new LoginPage(null);
            frame.dispose();
        }

        if (e.getSource() == resetButton) {
            adminField.setText("");
            adminPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {

            String adminID = adminField.getText();
            String password = String.valueOf(adminPasswordField.getPassword());

            if (adminIDs.containsKey(adminID)) {

                if (adminIDs.get(adminID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful!");
                    WelcomePage welcomepage = new WelcomePage(adminID);
                    //AdminPage adminpage = new AdminPage(userInfo);
                    //frame.dispose();
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password!");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Admin not found!");
            }
        }
    }
}
