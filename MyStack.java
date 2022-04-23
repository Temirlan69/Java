package com.company;

public class MyStack <T extends Comparable<T>>{
    private MyLinkedList<T> stackNode;

    public MyStack(){
        stackNode = new MyLinkedList<T>();
    }

    public boolean empty(){
        return stackNode.size() == 0;
    }

    public int size(){
       return stackNode.size();
    }

    public T peek(){
        return stackNode.get(0);
    }

    public T push(T newItem){
        stackNode.add(newItem, 0);
        return newItem;
    }

    public T pop(){
        if(empty()){
            throw new IndexOutOfBoundsException("stack is empty");
        }
        return stackNode.remove(0);
    }

}
