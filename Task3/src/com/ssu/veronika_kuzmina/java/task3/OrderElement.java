/**
 * Created by Вероника on 04.05.2016.
 */
public class OrderElement {
    Dish item;
    int count;

    OrderElement(Dish dish, int count) throws OrderElementException{
        if(count <= 0){
            throw new OrderElementException("Количество любого блюда в заказе должно быть больше 0");
        }
        item = dish;
        this.count = count;
    }

    public int GetPrice(){ return item.price*count; }

    public String GetDishAndCount(){
        return item.getName() + " в количестве " + Integer.toString(count);
    }
}

