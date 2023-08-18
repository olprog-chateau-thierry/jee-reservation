package com.formation.reservation;

import java.io.*;

import com.formation.reservation.models.ListeReservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("")
public class VueReservationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("reservations", ListeReservation.reservations);

        this.getServletContext().getRequestDispatcher("/WEB-INF/vueReservations.jsp").forward(request, response);
    }

}
