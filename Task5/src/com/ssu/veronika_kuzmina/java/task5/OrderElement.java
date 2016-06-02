import java.io.Serializable;

/**
 * Created by KuzminaVR on 12.05.2016.
 */
public class OrderElement implements Serializable {
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
