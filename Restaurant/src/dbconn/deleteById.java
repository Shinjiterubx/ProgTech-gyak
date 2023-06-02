package dbconn;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.Connection;
import static dbconn.dbConnect.SelectAll;
import java.sql.DriverManager;
import java.sql.*;

public class deleteById implements Command{
    static Logger logger = Logger.getLogger(deleteById.class);
    dbConnect conn = new dbConnect();

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        if (orderNo > 0){
            this.orderNo = orderNo;
        }else{
            System.out.println("Az order numbernek nagyobbnak kell lennie 0-nál");
        }
    }

    int orderNo;

    String row;
    public deleteById(int orderNo){
        conn.Connect();
        setOrderNo(orderNo);
    }


    @Override
    public String exec() {
        logger.info("Order törlése az adatbázisból");
        conn.deleteOrderByOrderNumber(getOrderNo());
        return null;
    }
}
