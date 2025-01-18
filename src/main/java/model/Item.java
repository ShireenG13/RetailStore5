package model;

public class Item {
    private int id;
    private String name;
    private double price;

    public Item(){
        this.id = 0;
        this.name = "";
        this.price = 0;
    }
    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}


