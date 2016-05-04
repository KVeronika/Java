/**
 * Created by Вероника on 04.05.2016.
 */
public class Customer {
    String nameCustomer;

    Customer(String nameCustomer) throws CustomerException{
        if(nameCustomer.isEmpty()||nameCustomer == null){
            throw new CustomerException("Имя покупателя не может быть пустой строкой");
        }
        this.nameCustomer = nameCustomer;
    }

    public String GetName(){
        return  nameCustomer;
    }
}