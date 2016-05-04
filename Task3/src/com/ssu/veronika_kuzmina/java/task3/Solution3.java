import java.util.ArrayList;

/**
 * Created by Вероника on 04.05.2016.
 */
public class Solution3 {
    public static void main(String[] args){
        Solution3 app = new Solution3();
        app.startApplication();
    }
    ArrayList<Customer> clients;
    ArrayList<OrderElement> meals;

    public void startApplication() {
        int totalPrice = 0;
        clients = getCustomers();
        meals = getMeals();
        Order order = new Order(clients.get(0), meals);
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

    public ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            customers.add(new Customer("Пупкин Александр"));
            customers.add(new Customer(""));
        }
        catch (CustomerException ex){
            System.err.println("Ошибка при создании сотрудника: " + ex.getMessage());
        }

        return customers;
    }

    public ArrayList<OrderElement> getMeals(){
        ArrayList<OrderElement> meals = new ArrayList<OrderElement>();
        try {
            //заказ
            OrderElement temp = new OrderElement(new Dish("Суп куриный с грибами", 250, 34), 4);
            meals.add(temp);
            temp = new OrderElement(new Dish("Рулет с изюмом", 75, 15), 2);
            meals.add(temp);
            temp = new OrderElement(new Dish("Пирог с яблоками", 60, 13), 2);
            meals.add(temp);
            temp = new OrderElement(new Dish("", 25, 30), 3);
            meals.add(temp);
            temp = new OrderElement(new Dish("Пирог с капустой", -25, 30), 3);
            meals.add(temp);
            temp = new OrderElement(new Dish("Пирог с капустой", 25, 0), 3);
            meals.add(temp);
            temp = new OrderElement(new Dish("Пирог с капустой", 25, 30), -15);
            meals.add(temp);
        }
        catch (DishException ex){
            System.err.println("Ошибка при добавлении блюда: " + ex.getMessage());
        }
        catch (OrderElementException ex){
            System.err.println("Ошибка при создании элемента заказа: " + ex.getMessage());
        }

        return meals;
    }
}
