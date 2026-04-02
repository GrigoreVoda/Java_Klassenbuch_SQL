package com.grigore.model;

import java.time.LocalDate;

public class Lernfeld {
    private String ID;
    private String titel;
    private LocalDate startDatum;
    private LocalDate endDatum;

    public Lernfeld() {
    }

    public Lernfeld(String ID, String titel, LocalDate startDatum, LocalDate endDatum) {
        this.ID = ID;
        this.titel = titel;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDate startDatum) {
        this.startDatum = startDatum;
    }

    public LocalDate getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(LocalDate endDatum) {
        this.endDatum = endDatum;
    }

    @Override
    public String toString() {
        return this.getID() + " " + this.getTitel() + " " +
                this.startDatum + " " + this.getEndDatum();
    }
}
