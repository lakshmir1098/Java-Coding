package org.example;

public class LinkedList {

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    //constructor
    public LinkedList(int value) {
        Node newn = new Node(value);
        head = newn;
        tail = newn;
        length = 1;
    }

    public void getHead() {
        System.out.println("Head : " + head.value );
    }

    public void getTail() {
        System.out.println("Tail : " + tail.value);

    }

    public void getLength() {
        System.out.println("Length : " + length);
    }


    public String toStringPrintList() {
        if (length == 0 ){
            return "NULL";
        }

        else {
            Node current = head;
            StringBuilder sb = new StringBuilder("(");
            while (current != null) {
                sb.append(current.value);
                if (current.next != null) {
                    sb.append(", ");
                }
                current = current.next;

            }
            sb.append(")");
            return sb.toString();
        }
    }


    private void append(int value, boolean silent) {
        Node newn = new Node(value);

        if (length == 0) {
            head = newn;
            tail = newn;
            length = 1;
        } else {
            tail.next = newn;
            tail = newn;
            length++;
        }

        if (!silent) {
            String appendList = toStringPrintList();
            System.out.printf("The appended Linked list is %s%n", appendList);
        }
    }



    private void prepend(int value, boolean silent) {
        Node newn = new Node(value);

        if (length == 0) {
            head = newn;
            tail = newn;
            length = 1;
        } else {
            newn.next = head;
            head = newn;
            length++;
        }

        if (!silent) {
            String prependedList = toStringPrintList();
            System.out.printf("The prepended Linked list is %s%n", prependedList);
        }
    }

    // Overloaded method for external usage
    public void append(int value) {
        append(value, false);
    }

    public void prepend(int value) {
        prepend(value, false);
    }

    private void removeFirst(boolean silent){
        if (length == 0 ){
            System.out.println("No Node");
        }

        String beforeRemoval = toStringPrintList();

        Node temp = head;
        head =  head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail =  null;
        }


        System.out.printf("Removed 1st node { %d } from Linked list %s%n" , temp.value , beforeRemoval);
    }

    private void removeLast(boolean silent) {
        if (length == 0 ){
            System.out.println("No Node");
        }

        String beforeRemoval = toStringPrintList();
        Node pre = head;
        Node temp = head;
        if ( length == 1) {
            head  = null;
            tail = null;
            length = 0;
        }
        else {
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
            length--;
        }

        int removedEl =  temp.value;

        System.out.printf("Removed last node { %d } from Linked list %s%n" , removedEl , beforeRemoval);
    }


    public void removeFirst() {
        removeFirst( false);
    }

    public void removeLast() {
        removeLast(false);
    }


    private Node get (int index, boolean silent){
        Node temp = head;

        if(index < 0 || index >= length){
            System.out.println("Index Out of Bound");
            return null;
        }
        else{
            for( int i = 0; i < index;  i++){
                temp = temp.next;
            }
        }

        if(!silent) {
            System.out.printf("The Node at index %d is { %d } %n", index, temp.value);
        }
        return temp;
    }


    public void get(int value) {
        get(value, false);
    }



    public void set(int index, int value){
    /**
     * you can do this
        if(index < 0 || index >= length){
            System.out.println("Index Out of Bound");
            return;
        }
        if (length == 0 ){
            System.out.println("No Node");
        }

        Node temp = head;
        for ( int i = 0 ; i < index ; i++){
            temp =  temp.next;
        }
        temp.value = value;

     OR
     */

        Node temp = get(index, true);
        if ( temp != null){
            temp.value = value;
            System.out.printf("The Node at index %d is set to { %d } %n", index, value);
        }

    }

    public void insert(int index, int value){
        if(index < 0 || index > length){
            System.out.println("Index Out of Bound");
            return;
        }
        if (index == 0) {
            prepend(value, true);
            System.out.printf("The Node { %d } at index %d is inserted %n",  value, index);
            return;
        }
        if (index == length) {
            append(value, true);
            System.out.printf("The Node { %d } at index %d is inserted %n",  value, index);
            return;
        }


        Node newn = new Node(value);
        Node temp = get(index - 1, true);
        newn.next = temp.next;
        temp.next = newn;
        length++;
        System.out.printf("The Node { %d } at index %d is inserted %n",  value, index);
    }

    public void remove( int index) {
        if(index < 0 || index >= length){
            System.out.println("Index Out of Bound");
            return;
        }
        if (index == 0) {
           removeFirst(true);
            System.out.printf("The Node at index %d is removed %n",  index);
            return;
        }
        if (index == length-1) {
            removeLast(true);
            System.out.printf("The Node at index %d is removed %n",  index);
        }
    /*
     * you can do this
        Node pre = head;
        Node temp = head;
        for(int i = 0 ; i < index ; i++){
            pre = temp;
            temp = temp.next;
        }
        pre.next = temp.next;
        temp.next = null;

    OR
    */
        Node pre = get(index-1,true);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;

        String list = toStringPrintList();
        System.out.printf("The LinkedList after removing node at index %d is %s%n",  index, list);

    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail =  temp;
        Node after;
        Node before = null;

        for ( int i = 0 ; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        String list = toStringPrintList();
        System.out.printf("The reversed LinkedList  is %s%n", list);
    }

    // Exercise Find Middle Node without using length
    public Node findMiddleNode(){
        Node slow = head;
        Node fast = head;


        while( fast != null && fast.next != null){
            slow = slow.next;
            fast =  fast.next.next;
        }

        System.out.printf( "The middle Node of the linked list is { %d } ", slow.value);
        return slow;
    }

    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                System.out.println("Has loop");
                return true;
            }
        }
        System.out.println("Has no loop");
        return false;
    }

    public Node findKthFromEnd(int k){
        Node slow = head;
        Node fast = head;

        for ( int i = 0 ; i < k; i++){
            if( fast == null){
                return null;
            }
            fast = fast.next;
        }

        while( fast !=null ){
            slow =  slow.next;
            fast = fast.next;
        }


        System.out.printf("The Kth node from the end of LinkedList  is %s%n", slow.value);
        return slow;
    }

    public void removeDuplicates(){
        Node current = head;


        while (current != null ){
            Node runner = current;
            while ( runner.next != null){
                if (current.value == runner.next.value){
                    runner.next = runner.next.next;
                    length -= 1;
                }

                else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        String list = toStringPrintList();
        System.out.printf("After duplicated removed the LinkedList  is %s%n", list);
    }

    public int binaryToDecimal(){
        Node current = head;
        int num = 0;

        while ( current != null){
            num = num * 2 + current.value;
            current = current.next;
        }

        System.out.printf(" Decimal value of the linked list is %d%n", num);
        return num;
    }

    public void partitionList(int x){
        if( head == null){
            return;
        }

        Node d1 = new Node(0);
        Node d2 = new Node(0);
        Node current = head;
        Node p1 = d1;
        Node p2 = d2;

        while(current != null){
            if( current.value < x){
                p1.next = current;
                p1 = current;
            }
            else{
                p2.next = current;
                p2 = current;
            }
            current = current.next;
        }

        p2.next=null;
        p1.next = d2.next;
        head =  d1.next ;

        String list = toStringPrintList();
        System.out.printf("The LinkedList  after partitioned based on value x is %s%n", list);

    }

}
