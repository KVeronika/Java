import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by KuzminaVR on 12.05.2016.
 */
class Order implements Serializable {
    Customer customer;
    ArrayList<OrderElement> meals;

    Order(Customer customer, ArrayList<OrderElement> meals){
        this.customer = customer;
        this.meals = meals;
    }

    Order(){
        customer = null;
        meals = null;
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
