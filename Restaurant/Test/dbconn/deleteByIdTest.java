package dbconn;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class deleteByIdTest {

    @Test
    void setOrderNo() {

        int validordernumber = 1;
        deleteById on = new deleteById(validordernumber);
        on.setOrderNo(validordernumber);
        assertEquals(validordernumber, on.getOrderNo());

    }

}