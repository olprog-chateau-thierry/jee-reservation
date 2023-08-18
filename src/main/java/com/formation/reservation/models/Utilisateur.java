package com.formation.reservation.models;

import java.util.Objects;

public class Utilisateur {
    private static Integer idStatic = 0;
    private Integer id = ++idStatic;
    private String nom;
    private String email;
    private String motDePasse;
    private String codeReservation;

    public Utilisateur(String nom, String email, String motDePasse, String codeReservation) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.codeReservation = codeReservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getCodeReservation() {
        return codeReservation;
    }

    public void setCodeReservation(String codeReservation) {
        this.codeReservation = codeReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(id, that.id) && Objects.equals(nom, that.nom) && Objects.equals(email, that.email) && Objects.equals(motDePasse, that.motDePasse) && Objects.equals(codeReservation, that.codeReservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, motDePasse, codeReservation);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", codeReservation='" + codeReservation + '\'' +
                '}';
    }
}
