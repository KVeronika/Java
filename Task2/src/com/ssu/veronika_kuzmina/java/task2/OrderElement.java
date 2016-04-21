package task2;

/**
 * Created by KuzminaVR on 24.03.2016.
 */
public class OrderElement {
    Dish item;
    int count;

    OrderElement(Dish dish, int count){
        item = dish;
        this.count = count;
    }

    public int GetPrice(){ return item.price*count; }

    public String GetDishAndCount(){
        return item.getName() + " в количестве " + Integer.toString(count);
    }
}
