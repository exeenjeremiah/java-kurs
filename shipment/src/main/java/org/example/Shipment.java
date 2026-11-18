package org.example;

public abstract class Shipment {
    private final String id;
    private final String recipient;
    private boolean sent;

    public Shipment(String id, String recipient) {
        this.id = id.trim().toUpperCase();
        this.recipient = recipient;
        this.sent = false;
    }

    public String getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public boolean isSent() {
        return sent;
    }

    public boolean markSent() {
        if (sent) {
            return false;
        }
        sent = true;
        return true;
    }

    public abstract int calculateCost();

    public abstract String getDescription();
}