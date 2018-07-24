package trackcustomers;

import java.util.Scanner;

public class Customer {

    private int CustomerNumber;
    private String Name;
    private String Address;
    private int PhoneNumber;

    public Customer() {
        CustomerNumber = 0;
        Name = "";
        Address = "";
        PhoneNumber = 0;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public int getCustomerNumber() {
        return CustomerNumber;
    }

    public void DataInput(int C, String N, String A, int P){
        CustomerNumber= C;
        Name= N;
        Address= A;
        PhoneNumber=P;
        
    }
    
    public String getCustomerInfo(){
        String Info= Name+ "\n"+ CustomerNumber+"\n"+ Address+ "\n" + PhoneNumber;
        return Info;
    }
}
