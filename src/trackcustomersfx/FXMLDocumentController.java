package trackcustomersfx;

import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import trackcustomers.Customer;
import trackcustomers.DirectoryHotel;

public class FXMLDocumentController implements Initializable {

    private DirectoryHotel DH;
    //private Customer C = new Customer();

    @FXML
    TextField Name;
    @FXML
    TextField CustomerNumber;
    @FXML
    TextField Address;
    @FXML
    TextField PhoneNumber;
    @FXML
    TextField inName;
    @FXML
    TextField inNumber;
    @FXML
    TextArea OutputPane;

    @FXML
    private void CustomerInput(ActionEvent event) {

        //Adding new information
        String CName = Name.getText();
        int CNumber = Integer.parseInt(CustomerNumber.getText());
        String CAddress = Address.getText();
        int CPhoneNumber = Integer.parseInt(PhoneNumber.getText());

        Customer newC = new Customer();
        newC.DataInput(CNumber, CName, CAddress, CPhoneNumber);
        DH.AddCustomer(newC);

        

        PrintWriter output = null;

        try {
            output = new PrintWriter(new File("Customerinfo.txt"));
            ArrayList<Customer> all = DH.getAllCustomer();
            for (Customer c : all) {
                output.println(c.getCustomerInfo());
            }

            output.close();
        } catch (Exception ex) {
            System.out.println("Error! Cannot write data to text file...");
        }
    }

    @FXML
    private void CustomerOutput(ActionEvent event) {
        String CNameSearch = inName.getText();
        String numberText = inNumber.getText();
        int CNumberSearch = 0;
        if (numberText.length() > 0) {
            CNumberSearch = Integer.parseInt(inNumber.getText());
        }
        Customer result = DH.SearchCustomerByName(CNameSearch);
        if (!(result == null)) {
            OutputPane.setText(result.getCustomerInfo());
        } else {
            result = DH.SearchCustomerByNumber(CNumberSearch);
            if (!(result == null)) 
                OutputPane.setText(result.getCustomerInfo());
            else {
            OutputPane.setText("No results found");
            }
        }
            

    }

    @FXML
    private void ClearOutput(ActionEvent event) {
        OutputPane.setText("");
        Name.setText("");
        CustomerNumber.setText("");
        Address.setText("");
        PhoneNumber.setText("");
        inName.setText("");
        inNumber.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DH = new DirectoryHotel();
        //Storing old information
        Scanner input = null;
        try {
            input = new Scanner(new File("Customerinfo.txt"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        while (input.hasNext()) {

            String PName = input.nextLine();
            int PNumber = input.nextInt();
            input.nextLine();
            
            String PAddress = input.nextLine();
            int PPhoneNumber = input.nextInt();
            input.nextLine();
            Customer newC = new Customer();
            newC.DataInput(PNumber, PName, PAddress, PPhoneNumber);
            DH.AddCustomer(newC);
        }
    }

}
