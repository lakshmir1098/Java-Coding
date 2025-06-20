package org.example;

public class BinarySearchTree {

    Node root;

    static class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean recursiveContains(int value){
        return recursiveContains(root, value);
    }

    private boolean recursiveContains( Node current , int value){
        if( current == null )  return false;
        if(current.value == value ) return true;
        if(value < current.value){
            return recursiveContains(current.left, value);
        }
        else {
            return recursiveContains(current.right, value);
        }
    }

    public  void recursiveTnsert ( int value){
        if ( root == null)  root = new Node(value);
        recursiveInsert(root, value);
    }

    private  Node recursiveInsert ( Node current, int value){
        if (current == null) return new Node(value);

         if (value < current.value){
             current.left =  recursiveInsert(current.left, value);
         } else if (value > current.value) {
             current.right =  recursiveInsert(current.right, value);
         }

        return current;
    }

    public void recursiveDelete(int value){
        deleteNode(root, value);
    }

    private Node recursiveDelete ( Node current, int value){
        if (current == null) return null;

        if (value < current.value){
            current.left =  recursiveDelete(current.left, value);
        } else if (value > current.value) {
            current.right =  recursiveDelete(current.right, value);
        }else{
            // leaf node to be removed
            if(current.left == null  && current.right == null){
                return null;
            }
            // if the removing node has right child alone
            else if (current.left == null){
                current= current.right;
            }
            // if the removing node has only left node
            else if (current.right == null) {
                current = current.left;
            }
            else{
                int minChild = minValue(current.right);
                current.value = minChild;
                current.right =  recursiveDelete(current.right, minChild);
            }
        }

        return  current;
    }

    private Node deleteNode(Node currentNode, int value){
        if ( currentNode == null) return null;
        if( value < currentNode.value) currentNode.left = deleteNode(currentNode.left, value);
        else if( value > currentNode.value) currentNode.right = deleteNode( currentNode.right, value);
        else{
            if(currentNode.left == null && currentNode.right == null) return null;
            else if ( currentNode.left == null) currentNode = currentNode.right;
            else if(currentNode.right == null) currentNode = currentNode.left;
            else{
                int minChild = minValue(currentNode.right);
                currentNode.value = minChild;
                currentNode.right = deleteNode(currentNode.right, value);
            }
        }
        return currentNode;
    }

// helper class to remove element that has both left and right child
// in that case we take minimum value on the right
    public int minValue(Node curent){
        while (curent.left != null){
            curent = curent.left;
        }
        return curent.value;
    }

}

