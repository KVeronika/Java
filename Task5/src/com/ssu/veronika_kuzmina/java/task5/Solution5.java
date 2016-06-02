import com.sun.deploy.util.SessionState;
import com.sun.deploy.util.SystemUtils;

import java.io.*;
import java.util.*;


/**
 * Created by KuzminaVR on 12.05.2016.
 */
public class Solution5  {
    public static void main(String[] args) throws IOException {
        Solution5 app = new Solution5();
        app.startApplication();
    }

    public void startApplication() throws IOException{
        int totalPrice = 0;
        boolean flag = true;
        ArrayList<Dish> orderElements = readFromFile("G:/УНИВЕР/Технологии разработки/Task5/input.txt");
        ArrayList<Order> orders = new ArrayList<Order>();

        while(flag) {
            orders = deserializeOrder("G:/УНИВЕР/Технологии разработки/Task5/order.serial");
            if(orders.isEmpty()){
                System.out.println("Заказов нет, вы можете их добавить следуя инструкциям");
            }
            else{
                System.out.println("Сейчас хранятся заказы:");
            }
            for (Order item:orders) {
                System.out.println(item.customer.nameCustomer);
                for (OrderElement item1: item.meals) {
                    System.out.println(item1.GetDishAndCount());
                }
            }
            System.out.println("Введие команду:");
            System.out.println("0 - для добавления заказа");
            System.out.println("1 - для удаления заказа");
            System.out.println("2 - для выхода из режима считывания заказов");
            System.out.println("Для добавления блюд воспользуйтесь кодами:");
            int i = 0;
            for (Dish item:orderElements)
            {
                System.out.println("Для заказа блюда блюда "  + item.name + " введите код " + Integer.toString(i));
                i++;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int comm = Integer.parseInt(st.nextToken());
            Customer client = new Customer(" ");
            ArrayList<OrderElement> meals = new ArrayList<OrderElement>();
            meals.add(new OrderElement(new Dish(" ", 0, 0), 0));
            Order temp = new Order(client, meals);
            if(comm == 0){
                meals.clear();
                System.out.println("Введите заказ в формате: Фамилия Имя коды блюд и их количество(через пробел)");
                BufferedReader inBuf1 = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st1 = new StringTokenizer(in.readLine());
                client = new Customer(st1.nextToken() + " " + st1.nextToken());
                while(st1.hasMoreTokens()){
                    int codeDish = Integer.parseInt(st1.nextToken());
                    int count = Integer.parseInt(st1.nextToken());
                    meals.add(new OrderElement(orderElements.get(codeDish), count));
                }
                temp = new Order(client, meals);
                orders.add(temp);
                serealizeOrder("G:/УНИВЕР/Технологии разработки/Task5/order.serial", orders);
                System.out.println("Для продолжения ввода команд нажмите enter");
                System.in.read();
            }
            if(comm == 1){
                System.out.println("Введите имя заказчика");
                BufferedReader inBuf1 = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st1 = new StringTokenizer(in.readLine());
                String name=st1.nextToken() + " " + st1.nextToken();
                Order tenp = new Order();
                for (Order item: orders) {
                    if(item.customer.nameCustomer.equals(name)){
                        temp = item;

                    }
                }
                orders.remove(temp);
                serealizeOrder("G:/УНИВЕР/Технологии разработки/Task5/order.serial", orders);
                System.out.println("Для продолжения нажмите enter");
                System.in.read();
            }
            if(comm == 2){
                serealizeOrder("G:/УНИВЕР/Технологии разработки/Task5/order.serial", orders);
                System.out.println("Для продолжения ввода команд нажмите enter");
                System.in.read();
                flag = false;
            }
        }

        ArrayList<String> outputText = new ArrayList<String>();
        outputText.add("Отчет в столовую:");
        for (Order order:orders) {
            for (OrderElement item : order.meals) {
                outputText.add(item.GetDishAndCount() + " стоимостью " + item.GetPrice());
            }
            totalPrice = order.getTotalPrice();
            outputText.add("Полная стоимость заказа: " + totalPrice);
        }

        outputText.add("Раздать блюда:");
        for (Order order:orders) {
            outputText.add(order.getNameCustomer());
            for (OrderElement item : order.meals) {
                outputText.add(item.GetDishAndCount());
            }
            totalPrice = order.getTotalPrice();
            outputText.add("Стоимость обеда: " + totalPrice);
        }


        File output = new File("G:/УНИВЕР/Технологии разработки/Task5/output.txt");
        writeToFile(output, outputText);
    }

    public ArrayList<Dish> readFromFile(String file){
        ArrayList<Dish> meals = new ArrayList<Dish>();
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            for (String item:lines) {
                String[] text = item.split("#");
                Dish temp = new Dish(text[0], Integer.parseInt(text[1]), Integer.parseInt(text[2]));
                meals.add(temp);
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return meals;
    }

    public static void writeToFile(File file, ArrayList<String> text){
        try(FileWriter writer = new FileWriter(file, false))
        {
            for (String item: text) {
                writer.write(item);
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void serealizeOrder(String path, ArrayList<Order> orders){
        try(FileOutputStream fos = new FileOutputStream(path))
        {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(orders);
            oos.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Order> deserializeOrder(String path){
        ArrayList<OrderElement> meals = new ArrayList<OrderElement>();
        ArrayList<Order> orders = new ArrayList<Order>();
        try(FileInputStream fis = new FileInputStream(path)) {
            ObjectInputStream oin = new ObjectInputStream(fis);
            orders = (ArrayList<Order>) oin.readObject();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        return orders;
    }
}
