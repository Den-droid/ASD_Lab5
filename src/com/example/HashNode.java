package com.example;

public class HashNode<V>{
    private String key;
    private V value;
    private HashNode<V> next;

    public HashNode(String key, V value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V value) {
        this.value = value;
        return this.value;
    }

    public HashNode<V> getNext(){
        return this.next;
    }

    public void setNext(HashNode<V> node){
        this.next = node;
    }
}
