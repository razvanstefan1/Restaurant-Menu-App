package bll;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    int orderID;
    String clientID;
    String dateFormat;

    public Order(int orderID, String clientID, String orderDate) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.dateFormat=orderDate;
    }
    public Order(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && clientID.equals(order.clientID) && dateFormat.equals(order.dateFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, clientID, dateFormat);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID='" + clientID + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                '}' + "\n\n";
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
