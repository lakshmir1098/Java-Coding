package org.example;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.recursiveTnsert(2);
        bst.recursiveTnsert(1);
        bst.recursiveTnsert(3);


        System.out.println("Root: " + bst.root.value);
        System.out.println("Root->Left: " + bst.root.left.value);
        System.out.println("Root->Right: " + bst.root.right.value);

        bst.recursiveDelete(2);

        System.out.println("Root: " + bst.root.value);
        System.out.println("Root->Left: " + bst.root.left.value);
        System.out.println("Root->Right: " + bst.root.right);



        System.out.println("BST Contains 27:" + bst.contains(27));

        System.out.println("BST Contains 17:" + bst.contains(17));

        System.out.println("BST rContains 18:" + bst.recursiveContains(18));
        System.out.println("BST rContains 17:" + bst.recursiveContains(17));

    }
}