package com.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>();
        long addTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            table.addElement(String.valueOf(i), "denis" + i);
        }
        addTime = System.currentTimeMillis() - addTime;

        long searchTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            table.getElement(String.valueOf(i));
        }
        searchTime = System.currentTimeMillis() - searchTime;

        long sortTime = System.currentTimeMillis();
        ArrayList<HashNode<String>> sorted = table.getSorted();
        sortTime = System.currentTimeMillis() - sortTime;

        long removeTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            table.removeElement(String.valueOf(i));
        }
        removeTime = System.currentTimeMillis() - removeTime;

        System.out.println("Add time 100000 elements: " + addTime + " ms");
        System.out.println("Search time 100000 elements: " + searchTime + " ms");
        System.out.println("Sort time 100000 elements: " + sortTime + " ms");
        System.out.println("Remove time 100000 elements: " + removeTime + " ms");

        // To show that sorting is really working
//        for (int i = 0; i < 10; i++) {
//            table.addElement(String.valueOf(i * 7), "denis" + i * 7);
//        }
//        table.addElement(String.valueOf(20), "denis20");
//        for (int i = 10; i < 15; i++) {
//            table.addElement(String.valueOf(i * 7), "denis" + i * 7);
//        }
//        ArrayList<HashNode<String>> sorted2 = table.getSorted();
//        for (HashNode<String> elem : sorted2) {
//            System.out.println(elem.getKey() + " -> " + elem.getValue() + "(" +
//                    table.hashCode(elem.getKey()) + ")");
//        }
    }
}
