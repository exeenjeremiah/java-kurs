package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NotificationCenter {

    private Map<String, Notifier> channels = new HashMap<>();
    private List<String> history = new ArrayList<>();

    private boolean isAliasAvailable(String alias) {

        if (alias.isEmpty()) {
            System.out.println("Alias nie może być pusty.");
            return false;
        }

        if (channels.containsKey(alias)) {
            System.out.println("Alias jest już zajęty.");
            return false;
        }

        return true;
    }

    public void addEmail(String alias, String address) {

        alias = alias.trim().toLowerCase();

        if (address.trim().isEmpty()) {
            System.out.println("Adres e-mail nie może być pusty.");
            return;
        }

        if (!isAliasAvailable(alias)) {
            return;
        }

        channels.put(alias, new EmailNotifier(address));

        System.out.printf("Dodano e-mail: %s%n", alias);
    }

    public void addSms(String alias, String number) {

        alias = alias.trim().toLowerCase();

        if (number.trim().isEmpty()) {
            System.out.println("Numer telefonu nie może być pusty.");
            return;
        }

        if (!isAliasAvailable(alias)) {
            return;
        }

        channels.put(alias, new SmsNotifier(number));

        System.out.printf("Dodano SMS: %s%n", alias);
    }

    public void showChannels() {

        if (channels.isEmpty()) {
            System.out.println("Brak kanałów.");
            return;
        }

        for (String alias : channels.keySet()) {

            Notifier notifier = channels.get(alias);

            System.out.printf("Alias: %s | %s%n",
                    alias, notifier.getDescription());
        }
    }

    public void removeChannel(String alias) {

        alias = alias.trim().toLowerCase();

        if (channels.remove(alias) != null) {
            System.out.printf("Usunięto kanał: %s%n", alias);
        } else {
            System.out.println("Nie znaleziono aliasu.");
        }
    }

    public void sendToOne(String alias, String message) {

        alias = alias.trim().toLowerCase();

        if (message.trim().isEmpty()) {
            System.out.println("Wiadomość nie może być pusta.");
            return;
        }

        Notifier notifier = channels.get(alias);

        if (notifier == null) {
            System.out.println("Nie znaleziono aliasu.");
            return;
        }

        notifier.send(message);

        history.add(notifier.getRecipientKey() + " | " + message);
    }

    public void sendToAll(String message) {

        if (message.trim().isEmpty()) {
            System.out.println("Wiadomość nie może być pusta.");
            return;
        }

        Set<String> sentRecipients = new HashSet<>();

        for (Notifier notifier : channels.values()) {

            String key = notifier.getRecipientKey();

            if (sentRecipients.add(key)) {

                notifier.send(message);

                history.add(key + " | " + message);
            }
        }

        System.out.printf("Liczba wysyłek: %d%n",
                sentRecipients.size());
    }

    public void showHistory() {

        if (history.isEmpty()) {
            System.out.println("Historia jest pusta.");
            return;
        }

        for (String entry : history) {
            System.out.println(entry);
        }
    }

    public void showCounters() {
        System.out.printf("Utworzone e-maile: %d%n", EmailNotifier.getCreatedCount());
        System.out.printf("Utworzone SMS-y: %d%n", SmsNotifier.getCreatedCount());
        System.out.printf("Aktualne kanały: %d%n", channels.size());
    }
}