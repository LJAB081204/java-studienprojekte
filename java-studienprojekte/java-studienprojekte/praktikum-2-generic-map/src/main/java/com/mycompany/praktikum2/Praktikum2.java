/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.praktikum2;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalQueries;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author lewis
 */
public class Praktikum2 {

    /**
     * 
     * @param args 
     * main erstellt 10 personen und packt diese in eine map
     * map wird zu einem Entry set gemacht
     * davon stream erstellt, der die personen nach den gegebenen Kriterien filtert und sortiert
     */
    public static void main(String[] args) {

        PM2Map<String, Person> map = new PM2Map<>();

        Person p1 = new Person("Lewis", "Ashton-Braun", 0);
        Person p2 = new Person("Mika", "Brüggemann", 5);
        Person p3 = new Person("Anna", "Schneider", 3);
        Person p4 = new Person("Lukas", "Müller", 1);
        Person p5 = new Person("Sophie", "Neumann", 6);
        Person p6 = new Person("Tom", "Fischer", 2);
        Person p7 = new Person("Laura", "Wagner", 4);
        Person p8 = new Person("Jan", "Hoffmann", 0);
        Person p9 = new Person("Nina", "Krüger", 5);
        Person p10 = new Person("Ben", "Schulz", 2);

        map.put(p1.getNachname(), p1);
        map.put(p2.getNachname(), p2);
        map.put(p3.getNachname(), p3);
        map.put(p4.getNachname(), p4);
        map.put(p5.getNachname(), p5);
        map.put(p6.getNachname(), p6);
        map.put(p7.getNachname(), p7);
        map.put(p8.getNachname(), p8);
        map.put(p9.getNachname(), p9);
        map.put(p10.getNachname(), p10);
        
       
        Set<Entry<String,Person>> personenSet=  map.entrySet();
        
        personenSet.stream()
        .filter((e) ->  e.getValue().getGebDat().getYear() < 1984 )
     
        .sorted((e1,e2) -> Integer.compare(e2.getValue().getKinder(), e1.getValue().getKinder()))
                
        .forEach((e1) -> System.out.println(e1.getValue().toString()));
        
        
        
        
    }

}
