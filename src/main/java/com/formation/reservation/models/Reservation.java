package com.formation.reservation.models;

import java.util.Objects;

public class Reservation {

    private static Integer idStatic = 0;

    private Integer id;
    private String nomSalle;
    private String creneau;
    private String nomEmploye;

    public Reservation(String nomSalle, String creneau, String nomEmploye) {
        this.id = ++idStatic;
        this.nomSalle = nomSalle;
        this.creneau = creneau;
        this.nomEmploye = nomEmploye;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getCreneau() {
        return creneau;
    }

    public void setCreneau(String creneau) {
        this.creneau = creneau;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(nomSalle, that.nomSalle) && Objects.equals(creneau, that.creneau) && Objects.equals(nomEmploye, that.nomEmploye);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomSalle, creneau, nomEmploye);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", nomSalle='" + nomSalle + '\'' +
                ", creneau='" + creneau + '\'' +
                ", nomEmploye='" + nomEmploye + '\'' +
                '}';
    }
}
