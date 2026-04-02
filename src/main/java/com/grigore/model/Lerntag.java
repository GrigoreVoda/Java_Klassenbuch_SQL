package com.grigore.model;

import java.time.LocalDate;

public class Lerntag {
    private int lenrtagId;
    private LocalDate datum;
    private String lernfeldId;
    private Integer dozentId;

    public Lerntag(int lenrtagId, LocalDate datum, String lernfeldId, Integer dozentId) {
        this.lenrtagId = lenrtagId;
        this.datum = datum;
        this.lernfeldId = lernfeldId;
        this.dozentId = dozentId;
    }

    public Lerntag() {
    }

    public int getLenrtagId() {
        return lenrtagId;
    }

    public void setLenrtagId(int lenrtagId) {
        this.lenrtagId = lenrtagId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getLernfeldId() {
        return lernfeldId;
    }

    public void setLernfeldId(String lernfeldId) {
        this.lernfeldId = lernfeldId;
    }

    public Integer getDozentId() {
        return dozentId;
    }

    public void setDozentId(Integer dozentId) {
        this.dozentId = dozentId;
    }

    @Override
    public String toString() {
        return "Lerntag{" +
                "lenrtagId=" + lenrtagId +
                ", datum=" + datum +
                ", lernfeldId='" + lernfeldId + '\'' +
                ", dozentId=" + dozentId +
                '}';
    }
}
