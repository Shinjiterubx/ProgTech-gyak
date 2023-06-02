package form;

public class mealSelectionStrategy implements IselectionStrategy{
    @Override
    public String[] getSelectionArray() {
        return new String[] {
                "Hamburger"
                ,"Hot-dog"
                ,"Pizza"
                ,"Gyros"};
    }
}
