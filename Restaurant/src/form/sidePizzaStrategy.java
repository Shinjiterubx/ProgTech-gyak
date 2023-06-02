package form;

public class sidePizzaStrategy implements IselectionStrategy{
    @Override
    public String[] getSelectionArray() {
        return new String[] {
                "Nem kérek"
                ,"Paradicsomos alap"
                ,"Tejfölös alap"};
    }
}
