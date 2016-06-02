import java.io.Serializable;

/**
 * Created by KuzminaVR on 12.05.2016.
 */
public class Customer implements Serializable {
    String nameCustomer;

    Customer(String nameCustomer){
        this.nameCustomer = nameCustomer;
    }

    public String GetName(){
        return  nameCustomer;
    }
}
