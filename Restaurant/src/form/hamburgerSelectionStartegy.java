package form;

public class hamburgerSelectionStartegy implements IselectionStrategy {

    @Override
    public String[] getSelectionArray() {
        return new String[] {
                "Sajtburger"
                ,"Duplahúsos"
                ,"Csípősburger"};
    }
}
