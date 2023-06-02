package form;

import dbconn.Command;
import dbconn.dbConnect;
import dbconn.deleteById;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static dbconn.dbConnect.SelectAll;

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
    private JTextField priceField;
    private JLabel priceTitle;
    private JPanel buttonsField;



    public mainPanel(){
        this.setTitle("Pizza Pizza OrderPanel");
        this.setContentPane(this.mainPanel);
        this.setSize(400,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);



        JFrame buttonsFieldLayout = new JFrame();
        buttonsFieldLayout.setLayout(new FlowLayout());

        JButton refresh = new JButton("Frissítés");

        buttonsFieldLayout.add(refresh);

        ResultSet resultSet = SelectAll("orders");


        try{
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString(1));
                String name = resultSet.getString(2);
                String sideDish = resultSet.getString(4);
                String drink = resultSet.getString(5);
                String note = resultSet.getString(6);
                byte hidden = resultSet.getByte(10);
                int price = Integer.parseInt(resultSet.getString(7));
                if (hidden == 0) {
                    JButton button = new JButton("#" + id + " " + name);

                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Handle button click event
                            try {
                                Command command = new deleteById(id);
                                String[] buttons = {"Ok", "Törlés"};
                                int value = JOptionPane.showOptionDialog(null,
                                        "Szám: " + id + "\n" + "Rendelés: " + name + "\n" + "Köret: " + sideDish + "\n"
                                                + "Üdítő: " + drink + "\n" + "Megjegyzés: \n\n" + note + "\n\n"
                                                + "Ár: " + price + ",- Ft",
                                        "Pizza Pizza InfoBox: ", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
                                if (value == JOptionPane.NO_OPTION) {
                                    command.exec();
                                }
                            } catch (Exception sql) {
                                System.out.println(sql);
                            }
                        }
                    });

                    buttonsFieldLayout.add(button);
                    System.out.println("Button hozzáadva");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        buttonsFieldLayout.add(buttonsField);
        buttonsFieldLayout.setLocationRelativeTo(null);
        buttonsFieldLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonsFieldLayout.setMinimumSize(new Dimension(500, 500));
        buttonsFieldLayout.setTitle("Pizza Pizza Kosár");
        buttonsFieldLayout.pack();
        buttonsFieldLayout.setVisible(true);



        //Kijelentkezés gombhoz

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
