package search.binary.tree.remove.minandmax;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树的遍历
 * 广度优先遍历（层序遍历）
 *
 * @author AlbertRui
 * @date 2018-03-22 20:41
 */
@SuppressWarnings("ALL")
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
     * 判断二叉树中是否包含键为key的节点
     *
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    /**
     * 根据键查找元素，返回查找的的元素的值
     * 若果没有找到，则返回null
     *
     * @param key
     * @return
     */
    public Value search(Key key) {
        return search(root, key);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 层序遍历（广度优先遍历）
     */
    public void levelOrder() {
        //使用Queue的实现类LinkedList来实现队列
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();//队首元素出队
            System.out.println(node.key);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /*===========================================private method=======================================*/

    /**
     * 对以node为节点的数进行后序遍历
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行中序遍历
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行前序遍历
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 在以node为根节点的树中查找并返回key所对应的值
     *
     * @param node
     * @param key
     * @return
     */
    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * 查找以node为根的节点是否包含键为key的节点
     *
     * @param node
     * @param key
     * @return
     */
    private boolean contain(Node node, Key key) {
        //递归到底的情况处理
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    /**
     * 向以node为根节点的二叉树中插入新的节点
     * 返回插入节点后的二叉搜索树的根
     *
     * @param node
     * @param key
     * @param value
     */
    @SuppressWarnings("ALL")
    private Node insert(Node node, Key key, Value value) {
        //递归到底的情况处理
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }
}

