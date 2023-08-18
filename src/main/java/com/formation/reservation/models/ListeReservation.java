package com.formation.reservation.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListeReservation {

    public static List<Reservation> reservations = new ArrayList<>(Arrays.asList(
            new Reservation("Salle 1", "10h-11h", "sam"),
            new Reservation("Salle 2", "11h-12h", "dylan"),
            new Reservation("Salle 3", "16h-17h", "jose"),
            new Reservation("Salle 4", "08h-09h", "sophie"),
            new Reservation("Salle 5", "12h-13h", "zohra")
    ));
}
