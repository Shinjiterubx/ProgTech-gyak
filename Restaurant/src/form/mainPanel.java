package form;

import dbconn.Command;
import dbconn.dbConnect;
import dbconn.deleteById;
import dbconn.insertOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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


    public Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public mainPanel(){
        this.setTitle("Pizza Pizza OrderPanel");
        this.setContentPane(this.mainPanel);
        this.setSize(400,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        mainPanel panel = this;

        JFrame buttonsFieldLayout = new JFrame();
        buttonsFieldLayout.setLayout(new FlowLayout());

        JButton refresh = new JButton("Frissítés");
        refresh.setBackground(Color.GREEN);
        buttonsFieldLayout.add(refresh);

        ResultSet resultSet = SelectAll("orders");




        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.dispose();
                buttonsFieldLayout.dispose();
                buttonsField.setVisible(false);
                mainPanel panel = new mainPanel();

            }
        });

        try{
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString(1));
                String name = resultSet.getString(2);
                String sideDish = resultSet.getString(4);
                String drink = resultSet.getString(5);
                String note = resultSet.getString(6);
                byte hidden = resultSet.getByte(10);
                Date date = resultSet.getDate(9);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
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
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        buttonsFieldLayout.add(buttonsField);
        buttonsFieldLayout.setLocationRelativeTo(null);
        buttonsFieldLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonsFieldLayout.setMinimumSize(new Dimension(400, 500));
        buttonsFieldLayout.setMaximumSize(new Dimension(400, 720));
        buttonsFieldLayout.setPreferredSize(new Dimension(400, 500));
        buttonsFieldLayout.setResizable(false);
        buttonsFieldLayout.setTitle("Pizza Pizza Kosár");
        buttonsFieldLayout.pack();
        buttonsFieldLayout.setVisible(true);


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



        mainBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                sideBox.enableInputMethods(false);
                String selected = String.valueOf(mainBox.getSelectedItem());
                IselectionStrategy selection = null;
                IselectionStrategy side = null;
                if(selected.equals("Hamburger")){
                    selection = new hamburgerSelectionStartegy();
                }
                else if (selected.equals("Hot-dog")) {
                    selection = new hotdogSelectionStrategy();
                }
                else if(selected.equals("Pizza")){
                    selection = new pizzaSelectionStrategy();
                }
                else {
                    selection = new nullSelectionStratagy();
                }

                foodtypeBox.removeAllItems();
                foodtypeBox.setModel(new DefaultComboBoxModel(selection.getSelectionArray()));
                selection = new nullSelectionStratagy();
                sideBox.setModel(new DefaultComboBoxModel(selection.getSelectionArray()));

            }
        });


        foodtypeBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {


                String selected = String.valueOf(foodtypeBox.getSelectedItem());
                IselectionStrategy selection = null;

                if(selected.equals("Duplahúsos")
                        || selected.equals("Sajtburger")
                        || selected.equals("Csípősburger")){
                    selection = new sidehamburgerStrategy();
                }
                else if(selected.equals("Sonkás")
                        || selected.equals("Gombás")
                        || selected.equals("Szalámis")){
                    selection = new sidePizzaStrategy();
                }
                else if(selected.equals("Sajtos")
                        || selected.equals("Ketchupos")
                        || selected.equals("Mustáros")
                        || selected.equals("Majonézes")){
                    selection = new sidehotdogStrategy();
                }

                else {
                    selection = new nullSelectionStratagy();
                }

                sideBox.removeAllItems();
                sideBox.setModel(new DefaultComboBoxModel(selection.getSelectionArray()));
                //selection = new nullSelectionStratagy();
                //sideBox.setModel(new DefaultComboBoxModel(selection.getSelectionArray()));

            }
        });

        //Rendelés leadás
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (parseIntOrNull(priceField.getText()) != null && parseIntOrNull(priceField.getText()) > 0 ){
                    Command command = new insertOrder((String) mainBox.getSelectedItem(), (String) foodtypeBox.getSelectedItem(), (String) sideBox.getSelectedItem(), (String) drinkBox.getSelectedItem(), extraBox.getText(), priceField.getText());
                    System.out.println(command.exec());
                    JOptionPane.showMessageDialog(null, "Sikeres rendelésfelvétel!\nA megjelenítéshez frissítsen!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Az ár mező csak számjegyeket tartalmazhat, nem lehet üres\nnem lehet 0-nál kisebb!", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
