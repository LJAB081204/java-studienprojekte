/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lewis
 * @param <K> ist der key
 * @param <V> ist der value
 */
public class PM2Map <K,V> implements java.util.Map<K,V> {
    
    MapPaar<K,V>[] paare;
    int count = 0;
    
    public PM2Map(){
        paare = new MapPaar[0];
    }
    
    /**
     * 
     * @return groeße der map
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * 
     * @return ob map leer ist oder nicht
     */
    @Override
    public boolean isEmpty() {
       return (size() == 0);
    }

    /**
     * 
     * @param key nach welchem key geguckt werden soll
     * @return true, wenn key in map ist
     */
    @Override
    public boolean containsKey(Object key) {
        if (isEmpty()){
            return false;
        }
        for(int i = 0;i < size(); i++){
            if(paare[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param value nach welchem value gesucht werden soll
     * @return true wenn value in map ist
     */
    @Override
    public boolean containsValue(Object value) {
        if (isEmpty()){
            return false;
        }
       for(int i = 0;i < size(); i++){
            if(paare[i].getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param key nach welchem key gesuhct werden soll
     * @return value zum passenden key
     */
    @Override
    public V get(Object key) {
        if (isEmpty()){
            return null;
        }
        for(int i = 0; i<size(); i++){
            if(paare[i].getKey().equals(key)){
                return paare[i].getValue();
            }
        }
        return null;
    }

    /**
     * 
     * @param key übergebener key
     * @param value übergebener value
     * @return wenn key bereits existiert, werd neuer vaöue rein gepackt und alter value returned
     */
    @Override
    public V put(K key, V value) {
        if(isEmpty()){
           paare = new MapPaar[1];
           paare[0] = new MapPaar(key,value);
           count++;
           return null;
       }
        
        for(int i = 0;i < size(); i++){
            if(paare[i].getKey().equals(key)){
                V old = paare[i].getValue();
                paare[i].setValue(value);
                return old;
            }
        }
        
       // Lewis: Array ist voll -> Kapazität verdoppeln, damit nicht bei jedem put() kopiert werden muss
       if(paare[paare.length-1] != null){
         MapPaar<K,V>[]  paarNeu = new MapPaar[size()*2];
         System.arraycopy(paare, 0, paarNeu, 0, size());
         paarNeu[size()] = new MapPaar(key,value);
         paare = paarNeu;
       }
       else{
           paare[size()] = new MapPaar(key,value);
       }
       count++;
       return null;
    }

    /**
     * 
     * @param key der zu entfernende key
     * @return den value vom zuzm entfernenden key
     */
    @Override
    public V remove(Object key) {
        
       if(!containsKey(key)){
           return null;
       }
       if(paare[size()-1].getKey().equals(key)){
           V val = paare[size()-1].getValue();
           paare[size()-1] = null;
           count--;
           return val;
       }
       for(int i = 0; i<size();i++){
           if(paare[i].getKey().equals(key)){
               V val = paare[i].getValue();
               MapPaar<K,V>[] kop = new MapPaar[size()-i]; 
               System.arraycopy(paare,i,kop,0,kop.length);
               System.arraycopy(kop,0,paare,i,kop.length);
               count--;
               return val;
           }
       }
      
       return null;
    }

    /**
     * 
     * @param m die map die hinzugefügt werden soll
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<?> keys = m.keySet();
        for(var key : keys){
            V val = m.get(key);
            put((K)key, val);
        }
    }

    /**
     * löscht map
     */
    @Override
    public void clear() {
        paare = new MapPaar[0];
    }

    /**
     * 
     * @return returned alle keys der map in einem set
     */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for(int i = 0; i<size(); i++){
            K key = paare[i].getKey();
            keys.add(key);
        }
        return keys;
    }

    /**
     * 
     * @return alle values der map als collection 
     */
    @Override
    public Collection<V> values() {
       Collection<V> vals = new ArrayList<>();
       for(int i = 0; i<size(); i++){
           vals.add(paare[i].getValue());
       }
       return vals;
    }

    /**
     * 
     * @return array als set zurück
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet(Arrays.asList(Arrays.copyOf(paare, count)));
    }
    
}
