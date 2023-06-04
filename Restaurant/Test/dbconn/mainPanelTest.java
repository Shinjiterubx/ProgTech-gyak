package dbconn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mainPanelTest {

    @Test
    void parseIntOrNull() {

        mainPanelTest obj = new mainPanelTest();

        String value = "234";

        Integer result = Integer.parseInt(value);

        assertNotNull(result);

        assertEquals(234, result.intValue());

    }
}