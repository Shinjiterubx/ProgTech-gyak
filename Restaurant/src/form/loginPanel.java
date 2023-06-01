package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import dbconn.*;

import static dbconn.dbConnect.*;

public class loginPanel extends JFrame {

    private JPanel loginPanelMain;
    private JLabel titleLabel;
    private JButton toRegisterButton;
    private JLabel usernameLabel;
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton loginButton;

    public loginPanel(){
        this.setTitle("Pizza Pizza Login");
        this.setContentPane(this.loginPanelMain);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(400,300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        loginPanel panel = this;

        //Adatbázis kapcsolat
        dbConnect conn = new dbConnect();
        conn.Connect();
        ResultSet result;



        toRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.dispose();
                registerPanel register = new registerPanel();
            }
        });

        //Login form


        //Login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameInput.getText();
                String password = new String(passwordInput.getPassword());
                //Felhasználónév és jelszó levizsgálása,
                // egyezik-e az adatbázisban szereplővel, üresek-




                if (!username.isEmpty()){
                    selectUsername command = new selectUsername(username);
                    command.exec();

                    if (username.equals(command.returnUsername())) {
                        if (!password.isEmpty()) {
                            if (password.equals(SelectPassword(password))) {
                                panel.dispose();
                                mainPanel main = new mainPanel();
                                System.out.println("Login succesfull!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Rossz felhasználónév vagy jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Üres jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Rossz felhasználónév vagy jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Üres felhasználónév vagy jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        passwordInput.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
              if (e.getKeyCode() == KeyEvent.VK_ENTER){
                  String username = usernameInput.getText();
                  String password = new String(passwordInput.getPassword());

                  //Felhasználónév és jelszó levizsgálása,
                  // egyezik-e az adatbázisban szereplővel, üresek-

                  if (!username.isEmpty() && !password.isEmpty()) {
                      if (username.equals(SelectUsername(username)) && password.equals(SelectPassword(password))) {
                          panel.dispose();
                          mainPanel main = new mainPanel();
                          System.out.println("Login succesfull!");
                      } else {
                          JOptionPane.showMessageDialog(null, "Rossz felhasználónév vagy jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                      }
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "Üres felhasználónév vagy jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                  }


              }
            }
        });
    }
}

