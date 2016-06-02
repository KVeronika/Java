import java.io.Serializable;

/**
 * Created by KuzminaVR on 12.05.2016.
 */
class Dish implements Serializable {
    String name;
    int weight;
    int price;

    Dish(String name, int weight, int price){
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}