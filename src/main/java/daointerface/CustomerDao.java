package daointerface;

import model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomers();

    void saveCustomer(List<Customer> customersList);

    boolean deleteCustomer(int id);

    boolean updateCustomer(Customer customer, int id);

}
