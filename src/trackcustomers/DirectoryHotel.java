package trackcustomers;

import java.util.ArrayList;

public class DirectoryHotel {

    private ArrayList<Customer> Directory;

    Customer e = new Customer();

    public DirectoryHotel() {
        Directory = new ArrayList<Customer>();
    }

    public void AddCustomer(Customer e) {
        Directory.add(e);
    }

    public ArrayList<Customer> getAllCustomer(){
        return Directory;
    }

    public Customer SearchCustomerByName(String byName) {

        for (int i = 0; i < Directory.size(); i++) {
            if (Directory.get(i).getName().equalsIgnoreCase(byName)) {
                return Directory.get(i);
            }
        }
        return null;

    }

    public Customer SearchCustomerByNumber(int byNumber) {

        for (int i = 0; i < Directory.size(); i++) {
            if (Directory.get(i).getCustomerNumber() == byNumber) {
                return Directory.get(i);
            }
        }
        return null;

    }

}
