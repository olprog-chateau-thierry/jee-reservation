package com.formation.reservation;

import com.formation.reservation.models.ListeReservation;
import com.formation.reservation.models.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/add")
public class FormReservationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("nomSalles", nomSalles);
        request.setAttribute("creneaux", creneaux);
        this.getServletContext().getRequestDispatcher("/WEB-INF/nouvelleReservation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Reservation reservation = new Reservation(
                request.getParameter("nomSalle"),
                request.getParameter("creneau"),
                request.getParameter("nomEmploye")
        );

        request.setAttribute("reservation", reservation);

        if (
                reservation.getNomEmploye().isEmpty() ||
                reservation.getNomSalle() == null ||
                reservation.getNomSalle().isEmpty() ||
                reservation.getCreneau() == null ||
                reservation.getCreneau().isEmpty()
        ) {
            request.setAttribute("error", "Vérifiez les champs. Ils doivent tous être complétés");
            doGet(request, response);
            return;
        }

        if (reservation.getNomSalle().matches("^\\d+$")) {
            int index = Integer.parseInt(reservation.getNomSalle());
            reservation.setNomSalle(nomSalles.get(index));
        } else {
            request.setAttribute("error", "Vérifiez les champs. Ils doivent tous être complétés");
            doGet(request, response);
            return;
        }

        if (reservation.getCreneau().matches("^\\d+$")) {
            int index = Integer.parseInt(reservation.getCreneau());
            reservation.setCreneau(creneaux.get(index));
        } else {
            request.setAttribute("error", "Vérifiez les champs. Ils doivent tous être complétés");
            doGet(request, response);
            return;
        }

        if (!reservation.getNomEmploye().matches("^\\p{L}{2,30}$")) {
            request.setAttribute("error", "Le nom doit comporter entre 2 et 30 caractères");
            doGet(request, response);
            return;
        }

        boolean estPris = ListeReservation.reservations.stream()
                        .anyMatch(r -> r.getNomSalle().equals(reservation.getNomSalle()) && r.getCreneau().equals(reservation.getCreneau()));

        if (estPris) {
            request.setAttribute("error", "La salle est malheureusement déjà occupée à cette heure");
            doGet(request, response);
            return;
        }
        ListeReservation.reservations.add(reservation);

        response.sendRedirect(request.getContextPath());

    }


    private final List<String> nomSalles = List.of(
            "Salle 1",
            "Salle 2",
            "Salle 3",
            "Salle 4",
            "Salle 5",
            "Salle 6",
            "Salle 7",
            "Salle 8"
    );

    private final List<String> creneaux = List.of(
            "8h-9h",
            "9h-10h",
            "10h-11h",
            "11h-12h",
            "12h-13h",
            "13h-14h",
            "15h-16h",
            "16h-17h",
            "17h-18h",
            "18h-19h"

    );
}
