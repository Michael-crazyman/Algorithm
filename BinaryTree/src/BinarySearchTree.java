
/**
 * Created by lishaoxun on 2016/6/28.
 */
public class BinarySearchTree <T extends Comparable<? super T>> {

    public  BinaryTreeNode<T> inserts(T element, BinaryTreeNode<T> root) {
        if (root == null)
            return new BinaryTreeNode<T>(element, null, null);
        int compareResult = element.compareTo(root.element);
        if (compareResult > 0)
            root.right = inserts(element, root.right);
        else if (compareResult < 0)
            root.left = inserts(element, root.left);
        return root;
    }

    public  boolean contains(T element, BinaryTreeNode<T> root) {
        if (root == null||element==null)
            return false;
        int compareResult = element.compareTo(root.element);
        if (compareResult > 0)
            return contains(element, root.right);
        else if (compareResult < 0)
            return contains(element, root.left);
        else
            return true;
    }

    public  BinaryTreeNode<T> findMax(BinaryTreeNode<T> root) {
        if (root == null)
            return null;
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    public  BinaryTreeNode<T> findMin(BinaryTreeNode<T> root) {
        if (root != null) {
            while (root.left != null)
                root = root.left;
        }
        return root;
    }

    public void printNode(BinaryTreeNode<T> root) {
        if (root != null) {
            System.out.println("The node is " + root.element);
            printNode(root.left);
            printNode(root.right);
        }
    }
    public BinaryTreeNode<T> remove(T element,BinaryTreeNode<T> root){
        if(root==null)
            return root;
        BinarySearchTree<T> bst = new BinarySearchTree<T>();
        int compareResult = element.compareTo(root.element);
        if(compareResult<0)
            root.left=remove(element,root.left);
        else if(compareResult>0)
            root.right=remove(element,root.right);
        else if(root.left!=null&&root.right!=null){
            root.element=bst.findMin(root.right).element;
            root.right=remove(root.element,root.right);
        }
        else
            root=(root.left!=null)?root.left:root.right;
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        BinaryTreeNode<Integer> root = bst.inserts(10, null);
        for (int i = 0; i < 20; i++) {
            if (i == 10)
                i++;
            else
                root = bst.inserts(i, root);
        }
        bst.remove(19, root);
        bst.printNode(root);
    }
}
