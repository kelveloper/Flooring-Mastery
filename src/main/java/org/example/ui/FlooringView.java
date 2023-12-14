package org.example.ui;

import org.example.dto.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class FlooringView {
    private UserIO io;
    public FlooringView(UserIO io) { // constructor
        this.io = io;
    }
    public int printMenuAndGetSelection() {
        io.print("<<Flooring Program>>");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Export All Data");
        io.print("6. Quit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Order getNewOrderInfo() {
        LocalDate orderDate = LocalDate.parse(io.readString("Please enter order date: ")); // where would we retrieve Order# ?
        //int orderNumber = io.readInt("Please enter Order Number: ");
        String customerName = io.readString("Please enter customer name: ");
        String state = io.readString("Please enter state: ");
        String productType = io.readString("Please enter product type: ");
        BigDecimal area = io.readBigDecimal("Please enter area: ");
        Order currentOrder = new Order(orderDate); // or orderNumber?
        currentOrder.setCustomerName(customerName);
        currentOrder.setState(state);
        currentOrder.setProduct(productType);
        currentOrder.setArea(area);
        return currentOrder;
    }

    public void displayCreateOrderBanner() {
        io.print("=== Create Order ===");
    }
    public void displayOrder(Order order) {
        if (order != null) {
            io.print("Order date: " + order.getDate());
            io.print("Order number: " + order.getOrderNumber());
            io.print("Customer Name: " + order.getCustomerName());
            io.print("State: " + order.getState());
            io.print("Product type: " + order.getProduct());
            io.print("Area: " + order.getArea());
            io.print("Tax: " + order.getTax());
            io.print("Total: " + order.getTotal());
            io.print("");
        } else {
            io.print("No such order.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayRemoveOrderBanner() {
        io.print("=== Remove Order ===");
    }
    public void displayRemoveResult(Order orderRecord) {
        if(orderRecord != null){
            io.print("Order successfully removed.");
        }else{
            io.print("No such order.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayExitBanner() {
        io.print("Thank you! Hope to see you again!");
    }
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displayRemoveSuccessBanner() { //check if it works
        io.print("Student successfully removed.");
    }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
