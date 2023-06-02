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

public class Main {
    static Logger logger = Logger.getLogger(Main.class);

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
        //TESZTELŐ RÉSZ

        System.out.println("#################### TESZT RÉSZ KEZDETE ####################");

        Command command = new selectOrder(1);
        System.out.println(command.exec());

//        command = new deleteById(1);
//        System.out.println(command.exec());

        System.out.println("#################### TESZT RÉSZ VÉGE ####################");
        //

        //mainFrame
        if (conn.isConnectedToDatabase()){
            //Levizsgáljuk, hogy van-e adatbázis kapcsolat. (xampp fut-e)
            loginPanel frame = new loginPanel();
            logger.info("DB connection is up, opening loginpanel");
        }
        else{
            JOptionPane.showMessageDialog(null, "Nincs adatbázis kapcsolat", "Pizza Pizza InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            logger.info("DB connection is down, opening error message");
        }


//        registerPanel frame2 = new registerPanel();
//        mainPanel frame3 = new mainPanel();
    }

}

