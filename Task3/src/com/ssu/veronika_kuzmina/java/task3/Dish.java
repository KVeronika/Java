/**
 * Created by KuzminaVR on 10.03.2016.
 */
class Dish { //класс отвечает за каждую позицию в меню
    String name;
    int weight;
    int price;

    Dish(String name, int weight, int price) throws DishException{
        if(name.isEmpty() || name == null){
            throw new DishException("Имя блюда не может быть пустой строкой");
        }
        if(weight <= 0){
            throw new DishException("Вес должен быть больше 0");
        }
        if(price <= 0){
            throw new DishException("Цена должна быть больше 0");
        }
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
