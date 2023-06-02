package dbconn;

import org.apache.log4j.Logger;

import java.sql.ResultSet;

import static dbconn.dbConnect.SelectAll;

public class selectOrder implements Command {
    static Logger logger = Logger.getLogger(selectOrder.class);
    dbConnect conn = new dbConnect();

    public int getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(int orderNo) {
        if(orderNo > 0){
            OrderNo = orderNo;
        }else{
            System.out.println("Az order numbernek nagyobbnak kell lennie 0-nál");
        }
    }

    private int OrderNo;

    String row;

    public selectOrder(int orderNo){
        logger.info("SQL lekérdezés adatbázis kapcsolat");
        conn.Connect();
        logger.info("Lekérdezés meghívása");
        setOrderNo(orderNo);
    }
    @Override
    public String exec() {
        //A Függvény visszatér a kiválasztott id alapján, az adott rendelés összes adatával
        // (kivéve a létrehozási dátumot, id-t, hidden-e)


        ResultSet result;
        result = SelectAll("orders");

        try{
            while (result.next() ){
                row = result.getString(1);
                if (Integer.parseInt(row) == getOrderNo()){
                    row = result.getString(3) + " " + result.getString(4) + " " +
                    result.getString(4) + " " + result.getString(5) + " " +
                    result.getString(6) + " " + result.getString(7);
                    logger.info("Sikeres lekérdezés a orders-ből");
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
