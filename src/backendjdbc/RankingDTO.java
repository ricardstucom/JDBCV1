/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendjdbc;

/**
 *
 * @author 46989075Y
 */
public class RankingDTO {
    private String name;
    private int nbaskets;

    public RankingDTO(String name, int nbaskets) {
        this.name = name;
        this.nbaskets = nbaskets;
    }

    public RankingDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbaskets() {
        return nbaskets;
    }

    public void setNbaskets(int nbaskets) {
        this.nbaskets = nbaskets;
    }
    
    
    
}
