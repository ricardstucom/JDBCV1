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
public class TogetherDTO {
     private String position;
    private Double mediaCanas;
    private int minCana;
    private int maxCana;
    private Double mediaAsists;
    private int minasists;
    private int maxAsists;
    private Double mediaRebounds;
    private int minRebounds;
    private int maxRebounds;

    public TogetherDTO(String position, Double mediaCanas, int minCana, int maxCana, Double mediaAsists, int minasists, int maxAsists, Double mediaRebounds, int minRebounds, int maxRebounds) {
        this.position = position;
        this.mediaCanas = mediaCanas;
        this.minCana = minCana;
        this.maxCana = maxCana;
        this.mediaAsists = mediaAsists;
        this.minasists = minasists;
        this.maxAsists = maxAsists;
        this.mediaRebounds = mediaRebounds;
        this.minRebounds = minRebounds;
        this.maxRebounds = maxRebounds;
    }

    public TogetherDTO() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getMediaCanas() {
        return mediaCanas;
    }

    public void setMediaCanas(Double mediaCanas) {
        this.mediaCanas = mediaCanas;
    }

    public int getMinCana() {
        return minCana;
    }

    public void setMinCana(int minCana) {
        this.minCana = minCana;
    }

    public int getMaxCana() {
        return maxCana;
    }

    public void setMaxCana(int maxCana) {
        this.maxCana = maxCana;
    }

    public Double getMediaAsists() {
        return mediaAsists;
    }

    public void setMediaAsists(Double mediaAsists) {
        this.mediaAsists = mediaAsists;
    }

    public int getMinasists() {
        return minasists;
    }

    public void setMinasists(int minasists) {
        this.minasists = minasists;
    }

    public int getMaxAsists() {
        return maxAsists;
    }

    public void setMaxAsists(int maxAsists) {
        this.maxAsists = maxAsists;
    }

    public Double getMediaRebounds() {
        return mediaRebounds;
    }

    public void setMediaRebounds(Double mediaRebounds) {
        this.mediaRebounds = mediaRebounds;
    }

    public int getMinRebounds() {
        return minRebounds;
    }

    public void setMinRebounds(int minRebounds) {
        this.minRebounds = minRebounds;
    }

    public int getMaxRebounds() {
        return maxRebounds;
    }

    public void setMaxRebounds(int maxRebounds) {
        this.maxRebounds = maxRebounds;
    }

    
}
