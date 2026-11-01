/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum2;

import com.google.common.base.Preconditions;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.time.Period;
import java.util.Random;

/**
 *
 * @author lewis
 */
public class Person implements Comparable<Person> {

    String vorname;
    String nachname;
    LocalDate gebDat;
    int kinder;

    public Person(String vorname, String nachname, LocalDate gebDat, int kinder) {
        this.vorname = vorname;
        Preconditions.checkNotNull(nachname, "Kein Nachname uebergeben");
        Preconditions.checkArgument(nachname.length() >= 3, "Nachname zu kurz");
        this.nachname = nachname;

        this.gebDat = gebDat;

        Preconditions.checkArgument(Period.between(gebDat, LocalDate.now()).getYears() < 16, kinder = 0);
        Preconditions.checkArgument(kinder >= 0, "keine negative Eingabe erlaubt");
        this.kinder = kinder;

    }

    public Person(String vorname, String nachname, int kinder) {
        this.vorname = vorname;
        Preconditions.checkNotNull(nachname, "Kein Nachname uebergeben");
        Preconditions.checkArgument(nachname.length() >= 3, "Nachname zu kurz");
        this.nachname = nachname;

        this.gebDat = randGeb();
        Preconditions.checkArgument(kinder >= 0, "keine negative Eingabe erlaubt");

        if (Period.between(gebDat, LocalDate.now()).getYears() < 16) {
            this.kinder = 0;
        } else {

            this.kinder = kinder;
        }

    }

    // Lewis: Zufälliges, gültiges Geburtsdatum; Tage pro Monat werden getrennt behandelt (Schaltjahr bleibt vereinfacht außen vor)
    public static LocalDate randGeb() {
        Random rng = new Random();

        int year = rng.nextInt(1950, 2004 + 1);
        int month = rng.nextInt(1, 12 + 1);
        int day;

        switch (month) {
            case 2:
                day = rng.nextInt(1, 28 + 1);
                break;

            case 1, 3, 5, 7, 8, 10, 12:
                day = rng.nextInt(1, 31 + 1);
                break;

            case 4, 6, 9, 11:
                day = rng.nextInt(1, 30 + 1);
                break;

            default:
                throw new IllegalArgumentException("Kein richtiger Monat übergeben");

        }

        LocalDate gebDat = LocalDate.of(year, month, day);
        return gebDat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.kinder != other.kinder) {
            return false;
        }
        if (!Objects.equals(this.vorname, other.vorname)) {
            return false;
        }
        if (!Objects.equals(this.nachname, other.nachname)) {
            return false;
        }
        return Objects.equals(this.gebDat, other.gebDat);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.vorname);
        hash = 19 * hash + Objects.hashCode(this.nachname);
        hash = 19 * hash + Objects.hashCode(this.gebDat);
        hash = 19 * hash + this.kinder;
        return hash;
    }

    @Override
    public int compareTo(Person o) {
        if (this.hashCode() == o.hashCode()) {
            return 0;
        } else if (this.hashCode() < o.hashCode()) {
            return -1;
        } else {
            return 1;
        }
    }

//    @Override
//    public String toString() {
//        
//        String gebDatStr = this.gebDat.toString();
//        
//        String pers = 
//        return gebDatStr;
//    }

    @Override
    public String toString() {
        return "Person{" + "vorname=" + vorname + ", nachname=" + nachname + ", gebDat=" + gebDat + ", kinder=" + kinder + '}';
    }
    
    

    /**
     *
     * @param nachname der übergeben Nachname wenn dieser null ist, hätte die
     * Person kenen Nachnamen(darf nicht sein) außerdem darf der Nachname nicht
     * kürzer als 3 Zeichen sein
     */
    public void setNachname(String nachname) {
        Preconditions.checkArgument(nachname == null, "Kein Nachname übergeben");
        Preconditions.checkArgument(nachname.length() < 3, "Nachname zu kurz");
        this.nachname = nachname;
    }

    /**
     *
     * @param kinder anzahl der Kinder, die die Person hat wenn Person jünger
     * als 16 ist, kann sie keine Kinder haben, wenn die Zahl der übergebenen
     * Kinder negativ ist, maccht es keinen Sinn
     */
    public void setKinder(int kinder) {
        Preconditions.checkArgument(Period.between(gebDat, LocalDate.now()).getYears() < 16, "Person ist nicht alt genug für Kinder");
        Preconditions.checkArgument(kinder < 0, "keine negative Eingabe erlaubt");
        this.kinder = kinder;
    }

    public LocalDate getGebDat() {
        return gebDat;
    }

    public String getNachname() {
        return nachname;
    }

    public int getKinder() {
        return kinder;
    }
}
