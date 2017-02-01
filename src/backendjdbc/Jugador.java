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
public class Jugador {
    private String name;
    private LocalDate birth;
    private int nbaskets;
    private int nassists;
    private int nrebounds;
    private String position;
    private String team;

    public Jugador() {
    }

    public Jugador(String name, LocalDate birth, int nbaskets, int nassists, int nrebounds, String position, String team) {
        this.name = name;
        this.birth = birth;
        this.nbaskets = nbaskets;
        this.nassists = nassists;
        this.nrebounds = nrebounds;
        this.position = position;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public int getNbaskets() {
        return nbaskets;
    }

    public void setNbaskets(int nbaskets) {
        this.nbaskets = nbaskets;
    }

    public int getNassists() {
        return nassists;
    }

    public void setNassists(int nassists) {
        this.nassists = nassists;
    }

    public int getNrebounds() {
        return nrebounds;
    }

    public void setNrebounds(int nrebounds) {
        this.nrebounds = nrebounds;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Jugador{" + "name=" + name + ", birth=" + birth + ", nbaskets=" + nbaskets + ", nassists=" + nassists + ", nrebounds=" + nrebounds + ", position=" + position + ", team=" + team + '}';
    }

    void setTeam(Equipo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
}
