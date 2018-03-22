package search.binary.tree.basic;

/**
 * 二叉查找树
 *
 * @author AlbertRui
 * @date 2018-03-22 20:41
 */
@SuppressWarnings({"javadoc", "unused"})
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    /**
     * 定义内部私有类作为节点
     */
    private class Node {
        private Node left;
        private Node right;
        private Value value;
        private Key key;
        //以该节点为根的子树的节点个数（包括该结点）
        private int count;

        /**
         * 初始化二叉查找树的节点
         *
         * @param key
         * @param value
         */
        Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    private Node root;//根节点

    /**
     * 返回二叉查找树中的节点的个数
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.count;
        }
    }

    /**
     * 判断二叉查找树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return root.count == 0;
    }

}
