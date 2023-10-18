import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");

    JLabel messageLabel = new JLabel("");

    JTextField adminField = new JTextField();
    JLabel adminLabel = new JLabel("adminID:");

    JButton adminButton = new JButton("Admin Login");
    JButton userButton = new JButton("User Login");

    HashMap<String,String> logininfo = new HashMap<String, String>();
    LoginPage(HashMap<String, String> loginInfoOriginal){

        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(145, 100, 200, 25);
        userPasswordField.setBounds(145, 150, 200, 25);

        loginButton.setBounds(145, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(245, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        adminLabel.setBounds(50, 50, 75, 25);
        adminField.setBounds(145, 50, 200, 25);

        adminButton.setBounds(180, 230, 130, 25);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);

        frame.add(adminButton);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        //frame.add(adminLabel);
        //frame.add(adminField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        HashMap<String, String> userIDs = new HashMap<String, String>();
        HashMap<String, String> adminIDs = new HashMap<String, String>();

        IDandPasswords userids = new IDandPasswords();
        userIDs = userids.getUserInfo();

        IDandPasswords adminids = new IDandPasswords();
        adminIDs = adminids.getAdminInfo();

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (userIDs.containsKey(userID)) {

                if (userIDs.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful!");
                    WelcomePage welcomepage = new WelcomePage(userID);
                    //frame.dispose();

                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password!");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found!");
            }
        }

        // admin page
        if (e.getSource() == adminButton) {
            AdminLoginPage adminloginpage = new AdminLoginPage(adminIDs, userIDs);
            frame.dispose();
        }
    }
}
