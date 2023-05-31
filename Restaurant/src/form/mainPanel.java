package form;

import dbconn.dbConnect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mainPanel extends JFrame{
    private JComboBox mainBox;
    private JComboBox foodtypeBox;
    private JComboBox sideBox;
    private JComboBox drinkBox;
    private JButton orderButton;
    private JButton exitButton;
    private JTextField extraBox;
    private JPanel mainPanel;
    private JLabel orderTitle;
    private JLabel cartTitle;
    private JTextField priceField;
    private JLabel priceTitle;
    private JButton orderItemButton;
    private JButton orderItemReadyButton;

    public mainPanel(){
        this.setTitle("Pizza Pizza OrderPanel");
        this.setContentPane(this.mainPanel);
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        mainPanel panel = this;

        //Adatbázis kapcsolat
        dbConnect conn = new dbConnect();
        conn.Connect();
        ResultSet result;

        //Kijelenetkezés gomb
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.dispose();
            }
        });
    }
}
