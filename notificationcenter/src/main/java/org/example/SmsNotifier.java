package org.example;

public class SmsNotifier implements Notifier {
    private String number;
    private static int createdCount = 0;

    public SmsNotifier(String address) {
        this.number = number.trim();
        createdCount++;
    }

    @Override
    public String getRecipientKey() {
        return "sms:" + number.replace(" ", " ");
    }

    @Override
    public String getDescription() {
        return "SMS: " + number;
    }

    @Override
    public void send(String message) {
        System.out.printf("SMS do: %s | Treść: %s%n", number, message);
    }

    public static int getCreatedCount() {
        return createdCount;
    }
}