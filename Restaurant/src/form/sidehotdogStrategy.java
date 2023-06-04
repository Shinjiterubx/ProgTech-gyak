package form;

import java.util.logging.Logger;

public class sidehotdogStrategy implements IselectionStrategy{

    @Override
    public String[] getSelectionArray() {
        return new String[]{
                "Nem kérek"
                ,"Szárított hagyma"
                ,"Extra Sajt"
        };
    }
}
