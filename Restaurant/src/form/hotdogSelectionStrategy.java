package form;

public class hotdogSelectionStrategy implements IselectionStrategy{
    @Override
    public String[] getSelectionArray() {
        return new String[]{
                "Sajtos"
                ,"Ketchupos",
                "Mustáros",
                "Majonézes"};
    }
}
