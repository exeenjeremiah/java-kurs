package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ShipmentManager {

    private final Map<String, Shipment> shipments;
    private final List<String> history;

    public ShipmentManager() {
        shipments = new LinkedHashMap<>();
        history = new ArrayList<>();

    }

    private void addShipment(Shipment shipment) {
        String id = shipment.getId();

        if (id.isEmpty() || shipment.getRecipient().isEmpty()) {
            System.out.println("ID i odbiorca nie mogą być puste.");
            return;
        }

        if (shipments.containsKey(id)) {
            System.out.println("Przesyłka o takim ID już istnieje.");
            return;
        }

        shipments.put(id, shipment);
        System.out.printf("Dodano przesyłkę %s%n", id);
    }

    public void addLetter(String id, String recipient, boolean registered) {
        Letter letter = new Letter(id, recipient, registered);
        addShipment(letter);
    }

    public void addParcel(String id, String recipient, int weighGrams) {

        if (weighGrams <= 0) {
            System.out.println("Masa musi być większa od zera.");
            return;
        }

        Parcel parcel = new Parcel(id, recipient, weighGrams);
        addShipment(parcel);
    }

    public Shipment findById(String id) {
        id = id.trim().toUpperCase();
        return shipments.get(id);
    }

    public void showAllShipments() {
        if (shipments.isEmpty()) {
            System.out.println("Rejestr jest pusty.");
            return;
        }

        for (Shipment shipment : shipments.values()) {
            String status = "Nienadana";

            if (shipment.isSent()) {
                status = "Nadana";
            }

            System.out.printf("ID: %s | %s Koszt: %.2f zł Status: %s%n",
                    shipment.getId(),
                    shipment.getDescription(),
                    shipment.calculateCost() / 100.0,
                    status);
        }
    }

    public void showById(String id) {
        Shipment shipment = findById(id);

        if (shipment == null) {
            System.out.println("Nie znaleziono przesyłki.");
            return;
        }

        String status = "Nienadana";

        if (shipment.isSent()) {
            status = "Nadana";
        }

        System.out.printf("ID: %s | %s Koszt: %.2f zł Status: %s%n",
                shipment.getId(),
                shipment.getDescription(),
                shipment.calculateCost() / 100.0,
                status);
    }

    public int calculateUnsentCost() {
        int total = 0;

        for (Shipment shipment : shipments.values()) {
            if (!shipment.isSent()) {
                total += shipment.calculateCost();
            }
        }
        return total;
    }

    public void sendShipment(String id) {
        Shipment shipment = findById(id);

        if (shipment == null) {
            System.out.println("Nie znaleziono przesyłki");
            return;
        }

        if (!shipment.markSent()) {
            System.out.println("Przesyłka została już nadana.");
            return;
        }

        history.add("Nadano" + shipment.getId() + " do " + shipment.getRecipient());

        System.out.printf("Nadano przesyłkę %s%n", shipment.getId());
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Historia jest pusta");
            return;
        }

        for (String entry : history) {
            System.out.println(entry);
        }
    }

    public void showRecipients() {
        Set<String> recipients = new HashSet<>();

        for (Shipment shipment : shipments.values()) {
            String recipient = shipment.getRecipient().trim().toLowerCase();
            recipients.add(recipient);
        }

        if (recipients.isEmpty()) {
            System.out.println("Brak odbiorców.");
            return;
        }

        for (String recipient : recipients) {
            System.out.println(recipient);
        }
    }

    public void removeShipment(String id) {
        Shipment shipment = findById(id);

        if (shipment == null) {
            System.out.println("Nie znaleziono przesyłki.");
            return;
        }

        if (shipment.isSent()) {
            System.out.println("Nie można usunąć nadanej przesyłki.");
            return;
        }

        shipments.remove(shipment.getId());

        System.out.printf("Usunięto przesyłkę %s%n", shipment.getId());
    }
}