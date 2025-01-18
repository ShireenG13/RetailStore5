package org.shireen;

import service.CustomerService;
import service.ItemService;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        //customerService.getALlCustomers();
        //customerService.save();

        //customerService.getALlCustomers();
        //customerService.updateCustomer();
        customerService.deleteRecord();
        //ItemService itemService = new ItemService();
        //itemService.save();
        //itemService.updateItem();

    }
}
