package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import dbconn.*;
import org.apache.log4j.Logger;

import static com.mysql.cj.conf.PropertyKey.logger;
import static dbconn.dbConnect.*;

public class loginPanel extends JFrame {
    static Logger logger = Logger.getLogger(loginPanel.class);
    private JPanel loginPanelMain;
    private JLabel titleLabel;
    private JButton toRegisterButton;
    private JLabel usernameLabel;
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton loginButton;

    public loginPanel(){
        logger.info("Loginpanel is running");
        this.setTitle("Pizza Pizza Login");
        this.setContentPane(this.loginPanelMain);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(400,300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        loginPanel panel = this;


        logger.info("Loginpanel is connecting to DB");
        //Adatbázis kapcsolat
        dbConnect conn = new dbConnect();
        conn.Connect();
        ResultSet result;



        toRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logger.info("Register button is pressed");
                panel.dispose();
                registerPanel register = new registerPanel();
                logger.info("Opening registerPanel");
            }
        });

        //Login form


        //Login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logger.info("Login button is pressed");
                String username = usernameInput.getText();
                String password = new String(passwordInput.getPassword());

                //Felhasználónév és jelszó levizsgálása,
                // egyezik-e az adatbázisban szereplővel, üresek-

                logger.info("Checking username and password");
                if (!username.isEmpty()){
                    logger.info("Username is not empty");
//                    selectUsername command = new selectUsername(username);
//                    command.exec();
                    Command command = new selectUsername(username);
                    if (username.equals(conn.SelectUsername(command.exec()))) {
                        logger.info("Username is in database");
                        if (!password.isEmpty()) {
                            logger.info("Password is not empty");
                            command = new selectPassword(password);
                            if (password.equals(command.exec())) {
                                logger.info("Password is in database");
                                logger.info("Matching login credentials");
                                logger.info("Closing loginPanel");
                                panel.dispose();
                                logger.info("Opening mainPanel");
                                mainPanel main = new mainPanel();
                                System.out.println("Login succesfull!");
                            } else {
                                logger.info("Password is not in database");
                                logger.info("Login credentials are not matching");
                                JOptionPane.showMessageDialog(null, "Rossz felhasználónév vagy jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else{
                            logger.info("Password field is empty");
                            JOptionPane.showMessageDialog(null, "Üres jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        logger.info("Username is not in database");
                        JOptionPane.showMessageDialog(null, "Rossz felhasználónév vagy jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    logger.info("Username field is empty");
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
                  logger.info("Key pressed!");

                  //Felhasználónév és jelszó levizsgálása,
                  // egyezik-e az adatbázisban szereplővel, üresek-

                  if (!username.isEmpty() && !password.isEmpty()) {
                      if (username.equals(SelectUsername(username)) && password.equals(SelectPassword(password))) {
                          panel.dispose();
                          mainPanel main = new mainPanel();
                          System.out.println("Login succesfull!");
                      } else {
                          JOptionPane.showMessageDialog(null, "Rossz felhasználónév vagy jelszó!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                          logger.info("Login failed!");
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

