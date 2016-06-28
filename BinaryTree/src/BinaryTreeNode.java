/**
 * Created by lishaoxun on 2016/6/28.
 */
public class BinaryTreeNode<T> {

    T element;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode(T t){
        this(t,null,null);
    }
    BinaryTreeNode(T element,BinaryTreeNode<T> left,BinaryTreeNode<T> right){
        this.element=element;
        this.left=left;
        this.right=right;
    }
}
