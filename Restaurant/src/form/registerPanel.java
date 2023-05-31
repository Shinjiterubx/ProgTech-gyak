package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerPanel extends JFrame{
    private JPanel registerPanelMain;
    private JButton registerButton;
    private JTextField registerUsernameInput;
    private JPasswordField registerPasswordInput;
    private JButton toLoginButton;
    private JLabel registerTitleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public registerPanel(){
        this.setTitle("Pizza Pizza Register");
        this.setContentPane(this.registerPanelMain);
        this.setSize(200,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        registerPanel panel = this;

        toLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.dispose();
                loginPanel login = new loginPanel();
            }
        });
    }
}
