package task2;

import java.util.ArrayList;

/**
 * Created by KuzminaVR on 10.03.2016.
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 app = new Solution2();
        app.startApplication();
    }

    public void startApplication() {
        ArrayList<OrderElement> meals = new ArrayList<OrderElement>();
        int totalPrice = 0;

        Customer client = new Customer("Пупкин Александр");
        //заказ
        OrderElement temp = new OrderElement(new Dish("Суп куриный с грибами", 250, 34), 4);
        meals.add(temp);
        temp = new OrderElement(new Dish("Рулет с изюмом", 75, 15), 2);
        meals.add(temp);
        temp = new OrderElement(new Dish("Пирог с яблоками", 60, 13), 2);
        meals.add(temp);

        Order order = new Order(client, meals);
        totalPrice = order.getTotalPrice();

        System.out.println("Отчет в столовую:");

        for (OrderElement item : meals) {
            System.out.println(item.GetDishAndCount() + " стоимостью " + item.GetPrice());
        }
        System.out.println("Полная стоимость заказа: " + totalPrice);

        System.out.println("Раздать блюда:");

        System.out.println(order.getNameCustomer());
        for (OrderElement item : meals) {
            System.out.println(item.GetDishAndCount());
        }
        System.out.println("Стоимость обеда: " + totalPrice);
    }
}
