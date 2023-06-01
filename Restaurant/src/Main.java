import form.loginPanel;
import form.mainPanel;
import form.registerPanel;
import dbconn.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.UIManager.*;


public class Main{
    public static void main(String[] args) {
        dbConnect conn = new dbConnect();
        conn.Connect();
        ResultSet result;

        //Nimbus

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }

        selectPassword command = new selectPassword("asd");
        command.exec();
        System.out.println(command.returnPassword());



        //mainFrame
        //Levizsgáljuk, hogy van-e adatbázis kapcsolat. (xampp fut-e)
        if (conn.isConnectedToDatabase()){
            loginPanel frame = new loginPanel();
        }
        else{
            JOptionPane.showMessageDialog(null, "Nincs adatbázis kapcsolat", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }


//        registerPanel frame2 = new registerPanel();
//        mainPanel frame3 = new mainPanel();
    }

}

