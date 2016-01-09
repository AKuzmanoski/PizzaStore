package mk.ukim.finki.wp.model;

import javax.persistence.*;

/**
 * Created by User on 11/25/2015.
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private String clientName;
    private String clientAddress;
    @ManyToOne
    private Pizza pizza;

    public Order() {

    }

    public Order(Pizza pizza, String clientName, String clientAddress) {
        this.pizza = pizza;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientName() {
        return clientName;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "Order{" +
                "clientAddress='" + clientAddress + '\'' +
                ", clientName='" + clientName + '\'' +
                ", pizza=" + pizza +
                '}';
    }
}
