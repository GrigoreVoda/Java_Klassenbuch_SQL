package com.grigore.model;

public class Dozent {
    private int dozentId;
    private String vorname;
    private String nachname;

    public Dozent(int dozentId, String vorname, String nachname) {
        this.dozentId = dozentId;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Dozent() {
    }

    public int getDozentId() {
        return dozentId;
    }

    public void setDozentId(int dozentId) {
        this.dozentId = dozentId;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return "Dozent{" +
                "dozentId=" + dozentId +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }
}

