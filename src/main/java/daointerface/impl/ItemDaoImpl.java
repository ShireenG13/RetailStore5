package daointerface.impl;

import daointerface.ItemDao;
import model.Item;
import utility.ConnectionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl extends ConnectionDAO implements ItemDao {

    @Override
    public List<Item> getAllItems() {

        try{
            Connection con = ConnectionDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from item");

            List itemList = new ArrayList();

            while(rs.next()){
                Item item = new Item();
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                itemList.add(item);
            }
            return itemList;

        }catch(SQLException e){
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    @Override
    public void saveItem(List<Item> itemsList) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            for(Item item : itemsList){
                String sqlQuery = "INSERT INTO item(name, price) VALUES(?,?)";
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setString(1, item.getName());
                ps.setDouble(2, item.getPrice());
                int affectedRows = ps.executeUpdate();
                System.out.println(affectedRows + " row(s) affected.");

            }
        }catch(SQLException e){
            e.printStackTrace();

        }

    }

    @Override
    public boolean deleteItem(int id) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM item WHERE id = ?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        }catch(SQLException e){
            System.err.format("SQL State : %s\n%s", e.getSQLState(), e.getMessage());
        }

        return false;
    }

    @Override
    public boolean updateItem(Item item, int id) {

        try{
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE item SET name=?, price=? WHERE id=?");
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, id);
            int i = ps.executeUpdate();
            if(i ==1){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }
}


