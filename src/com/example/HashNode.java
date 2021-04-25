package com.example;

import java.util.Objects;

public class HashNode<K, V>{
    private K key;
    private V value;
    private HashNode<K, V> next;

    public HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V value) {
        this.value = value;
        return this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashNode<?, ?> hashNode = (HashNode<?, ?>) o;
        return getKey().equals(hashNode.getKey());
    }

    public HashNode<K, V> getNext(){
        return this.next;
    }

    public void setNext(HashNode<K, V> node){
        this.next = node;
    }
}
