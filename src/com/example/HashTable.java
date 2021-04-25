package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class HashTable<K, V> {
    private ArrayList<HashNode<K, V>> buckets;
    private int numBuckets;
    private int currentSize;
    private final float loadFactor = 0.75F;

    public HashTable() {
        this.numBuckets = 12;
        this.currentSize = 0;
        this.buckets = new ArrayList<>();

        for (int i = 0; i < this.numBuckets; i++) {
            this.buckets.add(null);
        }
    }

    public int hashCode(K key) {
        return Objects.hash(key);
    }

    private int indexForBucket(int hash) {
        return hash % numBuckets;
    }

    public ArrayList<HashNode<K, V>> getSorted() {
        ArrayList<HashNode<K, V>> sorted = new ArrayList<>();
        HashNode<K, V> hashNode = null;
        for (HashNode<K, V> elem : this.buckets) {
            if (elem != null) {
                hashNode = elem;
                while (hashNode != null) {
                    sorted.add(hashNode);
                    hashNode = hashNode.getNext();
                }
            }
        }
        sorted.sort(Comparator.comparingInt(o -> this.hashCode(o.getKey())));
        return sorted;
    }

    public V getElement(K key) {
        int hashCode = this.hashCode(key);
        int index = indexForBucket(hashCode);
        HashNode<K, V> node = buckets.get(index);
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    public V removeElement(K key) {
        int hashCode = this.hashCode(key);
        int index = indexForBucket(hashCode);
        HashNode<K, V> node = buckets.get(index);
        HashNode<K, V> prev = null;
        while (node != null) {
            if (node.getKey().equals(key)) {
                break;
            }

            prev = node;
            node = node.getNext();
        }

        if (node == null) {
            return null;
        }

        this.currentSize--;

        if (prev != null) {
            prev.setNext(node.getNext());
        } else {
            this.buckets.set(index, node.getNext());
        }

        return node.getValue();
    }

    public void addElement(K key, V value) {
        int hashCode = this.hashCode(key);
        int index = indexForBucket(hashCode);
        HashNode<K, V> node = new HashNode<>(key, value);
        HashNode<K, V> find = this.buckets.get(index);
        if (find == null) {
            this.buckets.set(index, node);
        } else {
            while (find != null) {
                if (hashCode(find.getKey()) == hashCode(node.getKey()) && find.equals(node)) {
                    find.setValue(node.getValue());
                    return;
                }
                if (find.getNext() == null) {
                    find.setNext(node);
                    break;
                }
                find = find.getNext();
            }
        }

        this.currentSize++;

        if ((1.0 * this.currentSize) / this.numBuckets >= this.loadFactor) {
            ArrayList<HashNode<K, V>> temp = this.buckets;
            this.numBuckets *= 2;
            this.buckets = new ArrayList<>();
            this.currentSize = 0;

            for (int i = 0; i < this.numBuckets; i++) {
                this.buckets.add(null);
            }

            for (HashNode<K, V> elem : temp) {
                while (elem != null) {
                    this.addElement(elem.getKey(), elem.getValue());
                    elem = elem.getNext();
                }
            }
        }
    }
}
