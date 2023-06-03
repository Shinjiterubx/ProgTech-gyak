package dbconn;

public class insertOrder implements Command{
    dbConnect conn = new dbConnect();

    String mealType;

    String mealName;

    String sideDish;

    String drink;

    String note;

    String Price;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        if (parseIntOrNull(price) == null){
            System.out.println("Az ár nem lehet szöveg!");
        }
        else {
            this.Price = price;
        }
    }


    public Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public insertOrder(String mealType, String mealName, String sideDish, String drink, String note, String price){
        this.mealType = mealType;
        this.mealName = mealName;
        this.sideDish = sideDish;
        this.drink = drink;
        this.note = note;
        setPrice(price);
    }

    @Override
    public String exec() {
        conn.insertIntoOrderTable(mealType, mealName, sideDish, drink, note, getPrice());
        return null;
    }
}
