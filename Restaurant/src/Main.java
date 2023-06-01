import com.mysql.cj.log.Log;
import form.loginPanel;
import form.mainPanel;
import form.registerPanel;
import dbconn.*;
import org.apache.log4j.Logger;

import java.util.logging.Level;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.UIManager.*;

<<<<<<< Updated upstream

public class Main{
=======
public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
>>>>>>> Stashed changes
    public static void main(String[] args) {

        logger.info("The main is running");

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

