package form;

public class pizzaSelectionStrategy implements IselectionStrategy{
    @Override
    public String[] getSelectionArray() {
        return new String[] {
                "Sonkás"
                ,"Gombás"
                ,"Szalámis"};
    }
}
