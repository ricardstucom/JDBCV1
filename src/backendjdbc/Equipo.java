/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendjdbc;

import java.time.LocalDate;

/**
 *
 * @author 46989075y
 */
public class Equipo {
    private String name;
    private String city;
    private LocalDate creation;

    public Equipo() {
    }

    public Equipo(String nombre, String localidad, LocalDate fechaC) {
        this.name = nombre;
        this.city = localidad;
        this.creation = fechaC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + name + ", localidad=" + city + ", fechaC=" + creation + '}';
    }
    
    
}
