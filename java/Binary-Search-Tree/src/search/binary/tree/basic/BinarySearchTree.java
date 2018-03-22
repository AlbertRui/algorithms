package search.binary.tree.basic;

/**
 * 二叉查找树
 *
 * @author AlbertRui
 * @date 2018-03-22 20:41
 */
@SuppressWarnings({"javadoc","unused"})
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    /**
     * 定义内部私有类作为节点
     */
    private class Node {
        private Node left;
        private Node right;
        private Value value;
        private Key key;

        /**
         * 初始化二叉查找树的节点
         *
         * @param key
         * @param value
         */
        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;//根节点
    private int count;//树中结点个数

    /**
     * 初始化一颗空的二叉查找树
     */
    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    /**
     * 返回二叉查找树中的节点的个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断二叉查找树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向二叉查找树中插入节点
     *
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * 向以node为根节点的二叉树中插入新的节点
     * 返回插入节点后的二叉搜索树的根
     *
     * @param node
     * @param key
     * @param value
     */
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count ++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }
}
