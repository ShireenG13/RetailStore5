package service;


import daointerface.ItemDao;
import daointerface.impl.ItemDaoImpl;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemService {
    private final ItemDao itemDao;
    public ItemService(){
        this.itemDao = new ItemDaoImpl();
    }
    public void getALlItems(){
        List<Item> items = itemDao.getAllItems();
        System.out.println("All Items");
        for(Item item : items){
            System.out.println("Item Name: " + item.getName() + "Item Price: " + item.getPrice()) ;
        }

    }
    public void save(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> itemList = new ArrayList<>();
        System.out.println("Enter the number of Items to add: ");
        int noOfItems = Integer.parseInt (scanner.nextLine());

        for (int i= 0; i< noOfItems; i++){
            Item item = new Item();
            System.out.println("Enter Item Name : "+  (i+1) + ":");
            item.setName(scanner.nextLine());
            System.out.println("Enter Item Price : "+  (i+1) + ":");
            item.setPrice(scanner.nextDouble());
            itemList.add(item);
        }
        itemDao.saveItem(itemList);
        System.out.println("Items saved successfully");

    }

    public void updateItem(){
        Scanner scanner = new Scanner(System.in);
        Item updateItem = new Item();

        System.out.println("Enter the Item Id to Update " );
        int itemId =Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the name of Item to update : " );
        updateItem.setName(scanner.nextLine());
        System.out.println("Enter the price of Item to update : " );
        updateItem.setPrice(scanner.nextDouble());
        itemDao.updateItem(updateItem, itemId);
        System.out.println("Item updated successfully.");

    }

    public void deleteItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the Item to delete: " );
        int itemId =Integer.parseInt(scanner.nextLine());
        itemDao.deleteItem(itemId);
        System.out.println("Item deleted successfully.");
    }

}
