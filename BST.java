package com.company;


public class BST <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V value;
        private Node left,right;
        public Node (K key,V value){
            this.key = key;
            this.value = value;
        }
    }
    public void put(K key, V value){
        Node newNode = new Node(key,value);
        root = put(root, newNode);
    }
    private Node put(Node current, Node newNode){
        if(current == null) return newNode;
        if(newNode.key.compareTo(current.key) > 0)
        {current.right = put(current.right,newNode);}
        if(newNode.key.compareTo(current.key) < 0)
        {current.left = put(current.left,newNode);}
        return current;
    }

        public V get(K key){
            Node fin = root;
            return get(fin, key);
        }

        private V get(Node current, K key){
            if(current == null) return null;
            if(key.compareTo(current.key)>0){
                return get(current.right, key);
            }
            else if(key.compareTo(current.key)<0){
                return get(current.left, key);
            }
            return current.value;
        }

    public void delete(K key){
        root = delete(root, key);
    }
    private Node delete(Node root, K key){
        if (root == null) return null;

        if (key.compareTo(root.key) < 0){
            root.left = delete(root.left, key);
        }
        else if (key.compareTo(root.key) > 0){
            root.right = delete(root.right, key);
        }
        else{
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    
    private K minValue(Node root) {
        K minva = root.key;
        while (root.left != null) {
            minva = root.left.key;
            root = root.left;
        }
        return minva;
    }


    public Iterable<K> iterator() {
        MyQueue<K> q = new MyQueue<K>();
        inorder(root,q);
        return q;
    }
    private void inorder(Node x,MyQueue<K> q){
        if(x == null) return;
        inorder(x.left,q);
        q.enqueue(x.key);
        inorder(x.right,q);
    }
}



