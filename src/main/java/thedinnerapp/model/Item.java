package thedinnerapp.model;


public class Item {
    private int id;
    private String itemName;
    private String description;
    private String ingredients;
    double price;

    Item() {

    }

    Item(int id, String itemName, String description, String ingredients, double price){
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getId() { return id; }

    public String getItemName() { return itemName; }

    public String getDescription() { return description; }

    public String getIngredients() { return ingredients; }

    public double getPrice() { return price; }


    public void setId(int id) { this.id = id; }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public void setDescription(String description) { this.description = description; }

    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", price=" + price +
                '}';
    }
}

