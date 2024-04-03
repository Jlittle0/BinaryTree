import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // Calls helper method
        return binarySearch(val, root);
    }

    public boolean binarySearch(int val, BSTNode root) {
        /*
        Finds whether the value is in the binaryTree by using recursion to iterate
        through the entirety of the tree and traversing by moving left if the value is less than
        the current node's value, right if it's greater, or returning true if it's equal. This
        function returns false in the case that either the left or right node needed to find the
        value doesn't exist and is null therefore showing that the value isn't in the tree.
         */
        if (root == null) {
            return false;
        }
        if (val > root.getVal()) {
            return binarySearch(val, root.getRight());
        }
        else if (val < root.getVal()) {
            return binarySearch(val, root.getLeft());
        }
        return true;
    }


    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        inorder(root, list);
        return list;
    }

    public void inorder(BSTNode n, ArrayList<BSTNode> list) {
        if (n == null) {
            return;
        }
        inorder(n.getLeft(), list);
        list.add(n);
        inorder(n.getRight(), list);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        preorder(root, list);
        return list;
    }

    public void preorder(BSTNode n, ArrayList<BSTNode> list) {
        if (n == null) {
            return;
        }
        list.add(n);
        preorder(n.getLeft(), list);
        preorder(n.getRight(), list);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        postorder(root, list);
        return list;
    }

    public void postorder(BSTNode n, ArrayList<BSTNode> list) {
        if (n == null) {
            return;
        }
        postorder(n.getLeft(), list);
        postorder(n.getRight(), list);
        list.add(n);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
