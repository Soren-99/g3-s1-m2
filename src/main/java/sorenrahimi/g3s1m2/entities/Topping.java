package sorenrahimi.g3s1m2.entities;


public class Topping extends MenuItem{

    private String name;
    public Topping(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
