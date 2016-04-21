package task2;

/**
 * Created by KuzminaVR on 10.03.2016.
 */
class Dish { //класс отвечает за каждую позицию в меню
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
