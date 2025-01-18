package daointerface.impl;

import daointerface.CustomerDao;
import model.Customer;
import utility.ConnectionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends ConnectionDAO implements CustomerDao {

    @Override
    public List<Customer> getAllCustomers() {
        try {
            Connection connection = ConnectionDAO.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from customer");
            List customerList = new ArrayList();

            while (rs.next()) {
                Customer c = new Customer();
                c.setEmail(rs.getString("email"));
                c.setFname(rs.getString("fname"));
                c.setLname(rs.getString("lname"));
                customerList.add(c);
            }
            return customerList;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    @Override
    public void saveCustomer(List<Customer> customersList) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            for (Customer c : customersList) {
                String sqlQuery = "INSERT INTO customer (email, fname, lname) values (?,?,?)";
                PreparedStatement prepStmt = connection.prepareStatement(sqlQuery);
                prepStmt.setString(1, c.getEmail());
                prepStmt.setString(2, c.getFname());
                prepStmt.setString(3, c.getLname());
                int affectedRows = prepStmt.executeUpdate();
                System.out.println(affectedRows + " row(s) affected .");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean deleteCustomer(int id) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM customer WHERE id = ?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }

    public boolean updateCustomer(Customer customer, int id) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE customer SET email=?, fname=?,lname=? WHERE id=?");
            ps.setString(1, customer.getEmail());
            ps.setString(2, customer.getFname());
            ps.setString(3, customer.getLname());
            ps.setInt(4, id);
            int i=ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        }
        return false;

    }

}

