package com.grigore;

import com.grigore.model.Dozent;
import com.grigore.model.Lernfeld;
import com.grigore.model.Lerntag;
import com.grigore.model.Unterrichtseinheit;
import com.grigore.repositiry.DozentRepository;
import com.grigore.repositiry.LernfeldRepository;
import com.grigore.repositiry.LerntagRepository;
import com.grigore.repositiry.UnterrichtseinheitRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        LernfeldRepository lernfeldRepository = new LernfeldRepository();
        DozentRepository dozentRepository = new DozentRepository();
        UnterrichtseinheitRepository unterrichtseinheitRepository = new UnterrichtseinheitRepository();
        LerntagRepository lerntagRepository = new LerntagRepository();
        List<Dozent> dozentList = new ArrayList<>();
        List<Lernfeld> lernfeldList = new ArrayList<>();
        List<Unterrichtseinheit> unterrichtseinheitList = new ArrayList<>();
        Dozent doz = new Dozent();
        Lernfeld lernfeld = new Lernfeld();
        Lerntag lerntag = new Lerntag();
        try{
            lerntag = lerntagRepository.lerntagByDate(LocalDate.of(2026,3,9));
          //  unterrichtseinheitList = unterrichtseinheitRepository.findUnterrchtseinheitenByLerntagId(3);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
      //  System.out.println(lerntag);
       // unterrichtseinheitList.forEach(System.out::println);
        tagAsudruceken(LocalDate.of(2025,10,13));


    }
    public static void tagAsudruceken(LocalDate date) throws SQLException {
        LernfeldRepository lernfeldRepository = new LernfeldRepository();
        DozentRepository dozentRepository = new DozentRepository();
        UnterrichtseinheitRepository unterrichtseinheitRepository = new UnterrichtseinheitRepository();
        LerntagRepository lerntagRepository = new LerntagRepository();

      Lerntag lerntag = lerntagRepository.lerntagByDate(date);

      List<Unterrichtseinheit> unterrichtseinheitList = new ArrayList<>();
      unterrichtseinheitList = unterrichtseinheitRepository.findUnterrchtseinheitenByLerntagId(lerntag.getLenrtagId());
      Dozent dozent = dozentRepository.findDozentById(lerntag.getDozentId());
      Lernfeld lernfeld = lernfeldRepository.lernfeldById(lerntag.getLernfeldId());
        System.out.println   ("============================================================");
        System.out.println("Tag: " + lerntag.getDatum().toString());
        System.out.println("Dozent: " + dozent.getVorname() + " " + dozent.getNachname());
        System.out.println("Lernfeld: " + lernfeld.getID() + " von: " +
                lernfeld.getStartDatum() + " bis " + lernfeld.getEndDatum());
        System.out.println("Unterichteinheten: ");
        for (Unterrichtseinheit e : unterrichtseinheitList){
            System.out.println(e.getStunde() + " | " + e.getInhalt() );
            System.out.println("----------------------------------------------------------");
        }
    }
}