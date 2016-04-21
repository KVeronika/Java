package task2;

/**
 * Created by KuzminaVR on 24.03.2016.
 */
public class Customer {
    String nameCustomer;

    Customer(String nameCustomer){
        this.nameCustomer = nameCustomer;
    }

    public String GetName(){
        return  nameCustomer;
    }
}