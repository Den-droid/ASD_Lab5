package com.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<>();
        long addTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            table.addElement(i, "denis" + i);
        }
        addTime = System.currentTimeMillis() - addTime;

        long searchTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            table.getElement(i);
        }
        searchTime = System.currentTimeMillis() - searchTime;

        long removeTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            table.removeElement(i);
        }
        removeTime = System.currentTimeMillis() - removeTime;

        System.out.println("Add time 1000000 elements: " + addTime + " ms");
        System.out.println("Search time 1000000 elements: " + searchTime + " ms");
        System.out.println("Remove time 1000000 elements: " + removeTime + " ms");

        for (int i = 0; i < 10; i++) {
            table.addElement(i, "denis" + i);
        }
        table.addElement(20, "denis20");
        for (int i = 10; i < 15; i++) {
            table.addElement(i, "denis" + i);
        }
        ArrayList<HashNode<Integer, String>> sorted = table.getSorted();
        for(HashNode<Integer, String> elem : sorted){
            System.out.println(elem.getKey() + " -> " + elem.getValue() + "(" + elem.hashCode() + ")");
        }
    }
}
