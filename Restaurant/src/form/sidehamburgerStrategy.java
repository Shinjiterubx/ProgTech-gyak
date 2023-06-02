package form;

public class sidehamburgerStrategy implements IselectionStrategy{
    @Override
    public String[] getSelectionArray() {
        return new String[] {"Nem kérek","Extra sajt"};
    }
}
