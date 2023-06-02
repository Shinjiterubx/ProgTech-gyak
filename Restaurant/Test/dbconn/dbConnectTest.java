package dbconn;

import org.junit.jupiter.api.Test;

import java.sql.DriverManager;

import static dbconn.dbConnect.Connect;
import static dbconn.dbConnect.localcon;
import static org.junit.jupiter.api.Assertions.*;

class dbConnectTest {

    @Test
    void isConnectedToDatabase() {
        dbConnect testDBcon = new dbConnect();

        assertNotNull(testDBcon);

        boolean temp;

        try {

            localcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");

            temp = true;

        } catch (Exception e) {

            temp = false;

        }

        assertNotNull(localcon);

        assertTrue(temp);
    }

    @Test
    void connect() {

        Connect();

        assertNotNull(localcon);
    }
}