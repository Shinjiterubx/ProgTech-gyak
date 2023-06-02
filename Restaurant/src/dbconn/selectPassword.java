package dbconn;

import java.sql.ResultSet;

import static dbconn.dbConnect.SelectAll;

public class selectPassword implements Command{

    dbConnect conn = new dbConnect();
    ResultSet result;
    private String Password;

    private String row;

    public selectPassword(String password){
        conn.Connect();
        this.Password = password;
    }

    @Override
    public String exec() {
        //Lényegében az előző függvény, csak password-el
        //A Függvény visszatér a kiválasztott felhasználó jelszavával amennyiben létezik az adatbázisban,
        //ez azért van, hogy a loginban össze lehessen hasonlítani a beírt jelszóval.
        //A függvény paraméterében meg kell adni a keresett jelszót az adatbázisban.

        ResultSet result;
        result = SelectAll("user");

        try{
            while (result.next() ){
                row = result.getString(3);
                if (row.equals(Password)){
                    row = result.getString(3);
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
