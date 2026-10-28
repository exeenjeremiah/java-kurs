package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShipmentManager {

    private Map<String, Shipment> shipments;

    public ShipmentManager() {
        shipments = new LinkedHashMap<>();
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
}
