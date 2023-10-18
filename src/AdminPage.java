import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AdminPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel usertext = new JLabel();

    HashMap<String, String> userInfo = new HashMap<String, String>();
    AdminPage(HashMap<String, String> userinfo) {
        userInfo = userinfo;

        for (int i=0; i<=userInfo.size(); i++) {
            usertext.setText(userInfo.get(0));
        }

        usertext.setBounds(50, 100, 50, 50);
        usertext.setFont(new Font(null, Font.PLAIN, 25));
        frame.add(usertext);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);





    }




    @Override
    public void actionPerformed(ActionEvent e) {

        return;


    }
}

