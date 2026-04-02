package com.grigore.model;

public class Unterrichtseinheit {
    private int einheitId;
    private int lerntagId;
    private int stunde;
    private String inhalt;

    public Unterrichtseinheit(int einheitId, int lerntagId, int stunde, String inhalt) {
        this.einheitId = einheitId;
        this.lerntagId = lerntagId;
        this.stunde = stunde;
        this.inhalt = inhalt;
    }

    public Unterrichtseinheit() {
    }

    public int getEinheitId() {
        return einheitId;
    }

    public void setEinheitId(int einheitId) {
        this.einheitId = einheitId;
    }

    public int getLerntagId() {
        return lerntagId;
    }

    public void setLerntagId(int lerntagId) {
        this.lerntagId = lerntagId;
    }

    public int getStunde() {
        return stunde;
    }

    public void setStunde(int stunde) {
        this.stunde = stunde;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    @Override
    public String toString() {
        return "Unterrichtseinheit{" +
                "einheitId=" + einheitId +
                ", lerntagId=" + lerntagId +
                ", stunde=" + stunde +
                ", inhalt='" + inhalt + '\'' +
                '}';
    }
}
