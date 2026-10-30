package org.example;

public class EmailNotifier implements Notifier {

    private String address;
    private static int createdCount = 0;

    public EmailNotifier(String address) {
        this.address = address;
        createdCount++;
    }

    @Override
    public String getRecipientKey() {
        return "email:" + address.toLowerCase();
    }

    @Override
    public String getDescription() {
        return "E-mail: " + address;
    }

    @Override
    public void send(String message) {
        System.out.printf("E-mail do: %s | Treść: %s%n", address, message);
    }

    public static int getCreatedCount() {
        return createdCount;
    }
}