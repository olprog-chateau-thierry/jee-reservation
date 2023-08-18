package com.formation.reservation;

import com.formation.reservation.models.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet("/sign-out")
public class InscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur user = new Utilisateur(
          req.getParameter("nom"),
          req.getParameter("email"),
          req.getParameter("pwd"),
          null
        );

        String mdpVerif = req.getParameter("pwdVerif");

        if (!mdpVerif.equals(user.getMotDePasse()) || (mdpVerif.length() < 4 && user.getMotDePasse().length() < 4)) {
            req.setAttribute("error", "Les mots de passe ne sont pas identiques ou pas assez long. (min 4 caractères)");
            doGet(req, resp);
            return;
        }

        if (!user.getNom().matches("^\\p{L}{2,50}$")) {
            req.setAttribute("error", "Le nom doit contenir entre 2 et 50 caractères");
            doGet(req, resp);
            return;
        }

        final String emailRegex = "^([^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff]+|\\x22([^\\x0d\\x22\\x5c\\x80-\\xff]|\\x5c[\\x00-\\x7f])*\\x22)(\\x2e([^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff]+|\\x22([^\\x0d\\x22\\x5c\\x80-\\xff]|\\x5c[\\x00-\\x7f])*\\x22))*\\x40([^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff]+|\\x5b([^\\x0d\\x5b-\\x5d\\x80-\\xff]|\\x5c[\\x00-\\x7f])*\\x5d)(\\x2e([^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff]+|\\x5b([^\\x0d\\x5b-\\x5d\\x80-\\xff]|\\x5c[\\x00-\\x7f])*\\x5d))*$";
        if (!user.getEmail().matches(emailRegex)) {
            req.setAttribute("error", "L'email n'est pas correctement formatée");
            doGet(req, resp);
            return;
        }

        req.removeAttribute("error");

        String hashed = BCrypt.hashpw(user.getMotDePasse(), BCrypt.gensalt());
        user.setMotDePasse(hashed);

        req.getSession().setAttribute("userSession", user.getEmail());
        System.out.println(user);
        resp.sendRedirect(req.getContextPath());
    }
}
