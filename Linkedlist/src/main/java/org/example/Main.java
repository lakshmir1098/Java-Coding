package org.example;

class Main {
    public static void main (String[] args){

        LinkedList li = new LinkedList(4);
        li.append(5);
        li.append(6);
        li.append(7);
        // li.append(8);
        li.prepend(2);
//        li.prepend(3);
//        li.set(4,10);
//        li.removeFirst();
//        li.get(3);
//        li.removeLast();
//        li.insert(0, 9);
//        li.remove(3);
//        li.reverse();
//        li.getHead();
//        li.getTail();
//        li.getLength();
        System.out.println("Current LinkedList : " + li.toStringPrintList());
        li.findMiddleNode();
    }
}



