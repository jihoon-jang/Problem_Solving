package com.example.lib;

public class BinarySearchTree {
    public static void main(String[] args) {
        Bst tree = new Bst();
        tree.addNode(7);
        tree.addNode(3);
        tree.addNode(6);
        tree.addNode(10);
        tree.addNode(15);
        tree.addNode(1);
        tree.addNode(6);

        tree.inorderTraversal();
    }
}

class Bst {
    Node root;

    Bst() {
        root = null;
    }

    void removeNode(int data) {
        if (root == null)
            System.out.println("Tree is empty.");
        else {
            Node node = root;
            Node parent = node;
            int dir = 1;

            while (true) {
                if (node.data == data) {
                    if(node.left == null && node.right == null) {
                        if (node == root)
                            root = null;
                        else {
                            if (dir == 1)
                                parent.right = null;
                            else
                                parent.left = null;
                        }
                    }
                    else if((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
                        if(node == root) {
                            if(node.right == null)
                                root = root.left;
                            else
                                root = root.right;
                        }
                        if(dir == 1) {
                            if(node.left != null)
                                parent.right = node.left;
                            else
                                parent.right = node.right;
                        }
                        else {
                            if(node.left != null)
                                parent.right = node.left;
                            else
                                parent.right = node.right;
                        }
                    }
                    else {
                        Node targetP = node;
                        Node target = node.right;
                        boolean first = true;

                        while(target.left != null) {
                            targetP = target;
                            target = target.left;
                            first = false;
                        }

                        if(!first)
                            targetP.left = target.right;
                        else
                            targetP.right = target.right;

                        if(node == root) {
                            target.left = root.left;
                            target.right = root.right;
                            root = target;
                        }
                        else {
                            if (dir == 1) {
                                parent.right = target;
                                target.left = node.left;
                                target.right = node.right;
                            }
                            else {
                                parent.left = target;
                                target.left = node.left;
                                target.right = node.right;
                            }
                        }
                    }
                    return;
                }
                else if (node.data < data) {
                    if (node.right == null) {
                        System.out.println("There is no " + data);
                        return;
                    }
                    else {
                        parent = node;
                        dir = 1;
                        node = node.right;
                    }
                }
                else {
                    if (node.left == null) {
                        System.out.println("There is no " + data);
                        return;
                    }
                    else {
                        parent = node;
                        dir = -1;
                        node = node.left;
                    }
                }
            }
        }
    }

    void inorderTraversal() {
        System.out.print("inorder : ");
        inorderTraversal(root);
        System.out.println();
    }

    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    void preorderTraversal() {
        System.out.print("preorder : ");
        preorderTraversal(root);
        System.out.println();
    }

    void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    void postorderTraversal() {
        System.out.print("postorder : ");
        postorderTraversal(root);
        System.out.println();
    }

    void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    void searchNode(int data) {
        if (root == null)
            System.out.println("Tree is empty.");
        else {
            Node node = root;
            while (true) {
                if (node.data == data) {
                    System.out.println(data + " exists.");
                    break;
                }
                else if (node.data < data) {
                    if (node.right == null) {
                        System.out.println("There is no " + data);
                        break;
                    }
                    else
                        node = node.right;
                }
                else {
                    if (node.left == null) {
                        System.out.println("There is no " + data);
                        break;
                    }
                    else
                        node = node.left;
                }
            }
        }
    }

    void addNode(int data) {
        Node newNode = new Node(data);
        if (root == null)
            root = newNode;
        else {
            Node node = root;
            while (true) {
                if (node.data == newNode.data)
                    break;
                else if (node.data > newNode.data) {
                    if (node.left == null) {
                        node.left = newNode;
                        break;
                    } else
                        node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = newNode;
                        break;
                    } else
                        node = node.right;
                }
            }
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}