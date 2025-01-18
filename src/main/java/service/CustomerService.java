package service;

import daointerface.CustomerDao;
import daointerface.impl.CustomerDaoImpl;
import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final CustomerDao customerDao;
    public CustomerService(){
        this.customerDao = new CustomerDaoImpl();
    }
    public void getALlCustomers(){
        List<Customer> customers = customerDao.getAllCustomers();
        System.out.println("All Customers");
        for(Customer customer : customers){
            System.out.println("Email: " + customer.getEmail() + "First Name: " + customer.getFname()+ "Last Name: " + customer.getLname());
        }

    }
    public void save(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customerList = new ArrayList<>();
        System.out.println("Enter the number of Customers to add: ");
        int noOfCustomers = Integer.parseInt (scanner.nextLine());

        for (int i= 0; i< noOfCustomers; i++){
            Customer customer = new Customer();
            System.out.println("Enter email for Customer : "+  (i+1) + ":");
            customer.setEmail(scanner.nextLine());
            System.out.println("Enter first name for Customer : "+  (i+1) + ":");
            customer.setFname(scanner.nextLine());
            System.out.println("Enter last name for Customer : "+  (i+1) + ":");
            customer.setLname(scanner.nextLine());
            customerList.add(customer);
        }
        customerDao.saveCustomer(customerList);
        System.out.println("Customers saved successfully");

    }

    public void updateCustomer(){
        Scanner scanner = new Scanner(System.in);
        Customer updateCustomer = new Customer();

        System.out.println("Enter the id of the customer to update: " );
        int cId =Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the email of the customer to update: " );
        updateCustomer.setEmail(scanner.nextLine());
        System.out.println("Enter the first name of the customer to update: " );
        updateCustomer.setFname(scanner.nextLine());
        System.out.println("Enter the last name of the customer to update: " );
        updateCustomer.setLname(scanner.nextLine());
        customerDao.updateCustomer(updateCustomer, cId);
        System.out.println("Customer updated successfully.");

    }

    public void deleteRecord(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the customer to delete: " );
        int cId =Integer.parseInt(scanner.nextLine());
        customerDao.deleteCustomer(cId);
        System.out.println("Customer deleted successfully.");
    }

}


