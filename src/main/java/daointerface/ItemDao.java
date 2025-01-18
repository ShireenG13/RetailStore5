package daointerface;


import model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> getAllItems();

    void saveItem(List<Item> itemsList);

    boolean deleteItem(int id);

    boolean updateItem(Item item, int id);

}
