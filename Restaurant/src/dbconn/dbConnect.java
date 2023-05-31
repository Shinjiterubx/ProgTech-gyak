package dbconn;
import form.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class dbConnect {
    static Connection localcon;


    public static boolean isConnectedToDatabase(){
        try {
            Connection temp = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");

        }catch (Exception e){
            return false;
        }
        return true;
    }
    public static void Connect(){
        try{
            localcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
        } catch (Exception e){
            localcon = null;
        }
    }


    public static ResultSet SelectAll(String Element){

        try{
            //Elementben megadott táblából keres az adatbázisból ami egy ResultSet-ben tér vissza, ezt még fel kell dolgozni.
            return localcon.createStatement().executeQuery("select * from " + Element);
        } catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    //Feldolgozás példa:

    //        try{
    //            while (result.next()){
    //                String row = result.getString(1) +' '+ result.getString(2) +' '+ result.getString(3);
    //                System.out.println(row);
    //            }
    //        } catch (Exception e){
    //            System.out.println(e);
    //        }

    public static String SelectUsername(String Username){
        //A Függvény visszatér a kiválasztott felhasználó felhasználónevével amennyiben létezik az adatbázisban,
        //ez azért van, hogy a loginban össze lehessen hasonlítani a beírt felhasználónévvel.
        //A függvény a keresett Usernamet az adatbázisban.
        ResultSet result;
        result = SelectAll("user");
        String row;

        try{
            while (result.next() ){
                row = result.getString(2);
                    if (row.equals(Username)){
                        return row;
                    }
                }
        } catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    public static String SelectPassword(String Password){
        //Lényegében az előző függvény, csak password-el
        //A Függvény visszatér a kiválasztott felhasználó jelszavával amennyiben létezik az adatbázisban,
        //ez azért van, hogy a loginban össze lehessen hasonlítani a beírt jelszóval.
        //A függvény paraméterében meg kell adni a keresett jelszót az adatbázisban.
        ResultSet result;
        result = SelectAll("user");
        String row;

        try{
            while (result.next() ){
                row = result.getString(3);
                if (row.equals(Password)){
                    return row;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
}
