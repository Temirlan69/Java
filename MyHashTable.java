package com.company;


public class MyHashTable<K,V> {
        private static class HashNode<K,V> {
          private  K key;
           private V value;
           private HashNode<K,V> next;

          public  HashNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private HashNode<K,V>[] chainArray;
        private int M = 11;
        private int size;
        private float loadFactor = 0.75F;

        public MyHashTable() {
            chainArray = new HashNode[M];
        }

        public MyHashTable(int M) {
            M = (int)(M * loadFactor);
            chainArray = new HashNode[M];
        }

        public void put(K key, V value){
            HashNode<K,V> newNode = new HashNode<>(key, value);
            int index = hash(key);


            if (chainArray[index] == null) {
                chainArray[index] = newNode;
            } else {
                newNode.next = chainArray[index];
                chainArray[index] = newNode;
            }

            size++;
        }

        public V get(K key) {
            int index = hash(key);

            HashNode<K,V> it = chainArray[index];
            while (it != null) {
                if (it.key.equals(key))
                    return it.value;
                it = it.next;
            }
            return null;
        }

        private int hash(K key){
            return (key.hashCode() & 0x7FFFFFFF) % M;
        }

        public V remove(K key){
            int index = getIndex(key);
        int hash = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;
        while(head != null){
            if (head.key.equals(key) && hash == head.hashCode()) break;
            prev = head;
            head = head.next;
        }
        if (head == null) return null;

        size--;

            if (prev != null) prev.next = head.next;
            else chainArray[index] = head.next;


            return head.value;}

        private int getIndex(K key){
        int hash = hash(key);
        int index = hash % M;
        if (index < 0) index *= -1;
        return index;
        }

        public boolean contains(V value){for (int i = 0; i < M; i ++){
            if (chainArray[i] != null){
                HashNode<K, V> head = chainArray[i];
                while(head != null){
                    if(head.value.equals(value)){
                        return true;
                    }
                    head = head.next;
                }
            }
        }
            return false;}

        public K getKey(V value){return null;}
    }

