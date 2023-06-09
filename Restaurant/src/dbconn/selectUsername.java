package dbconn;

import java.sql.ResultSet;
import static dbconn.dbConnect.SelectAll;
import dbconn.*;
import static dbconn.dbConnect.*;

public class selectUsername implements Command{

    dbConnect conn = new dbConnect();
    ResultSet result;
    private String Username;
    private String row;


    public selectUsername(String username){

        conn.Connect();
        this.Username = username;
    }

    @Override
    public String exec() {
        //A Függvény visszatér a kiválasztott felhasználó felhasználónevével amennyiben létezik az adatbázisban,
        //ez azért van, hogy a loginban össze lehessen hasonlítani a beírt felhasználónévvel.
        //A függvény a keresett Usernamet az adatbázisban.

        ResultSet result;
        result = SelectAll("user");


        try{
            while (result.next() ){
                row = result.getString(2);
                if (row.equals(Username)){
                    break;
                }
                else{
                    row = null;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

        return row;
    }
}
