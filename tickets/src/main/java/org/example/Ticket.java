package org.example;

public class Ticket {
    private final String eventName;
    private final int price;
    private int availableSeats;

    public Ticket(String eventName, int price, int availableSeats) {
        this.eventName = eventName;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public String getEventName() {
        return eventName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int calculateCost(int quantity) {
        return price * quantity;
    }

    public boolean buy(int quantity) {
        if (quantity <= 0 || quantity > availableSeats) {
            return false;
        }
        availableSeats -= quantity;
        return true;
    }
}