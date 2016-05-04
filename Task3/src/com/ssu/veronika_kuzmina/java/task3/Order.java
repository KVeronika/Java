import java.util.ArrayList;

/**
 * Created by Вероника on 04.05.2016.
 */
class Order { //класс отвечает за отдельный заказ
    Customer customer;
    ArrayList<OrderElement> meals;

    Order(Customer customer, ArrayList<OrderElement> meals){
        this.customer = customer;
        this.meals = meals;
    }

    public String getNameCustomer(){
        return customer.nameCustomer;
    }
    public int getTotalPrice(){
        int totalPrice=0;
        for(OrderElement item:meals) {
            totalPrice+=item.GetPrice();
        }
        return totalPrice;
    }
}
