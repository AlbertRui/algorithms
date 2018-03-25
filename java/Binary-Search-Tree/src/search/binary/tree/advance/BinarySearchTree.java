package search.binary.tree.advance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 查找最小值和最大值对应的key
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

    /**
     * 寻找最小键值
     *
     * @return
     */
    public Key minimum() {
        assert size() != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    /**
     * 寻找最大键值
     *
     * @return
     */
    public Key maximum() {
        assert size() != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    /**
     * 删除二分搜索树中最小值所对应的节点
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 删除二分搜索树中最大值所对应的节点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 删除键值为key的节点
     * hibbard deletion
     *
     * @param key
     */
    public void remove(Key key) {
        root = remove(root, key);
    }

    /**
     * 向下取整
     *
     * @return
     */
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    /**
     * 返回给定键值的排名
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    /**
     * 返回给定排名的键值
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        Node node = select(root, k);
        if (node != null) {
            return node.key;
        }
        return null;
    }

    /*===========================================private method=======================================*/

    /**
     * 在以root为根的二分搜索树中
     * 返回给定排名k对应的键值的节点
     *
     * @param node
     * @param k
     * @return
     */
    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        }
        int temp = size(node.left) + 1;//排名从1开始
        if (temp > k) {
            return select(node.left, k);
        } else if (temp < k) {
            return select(node.right, k - temp - 1);
        } else {
            return node;
        }
    }

    /**
     * 在以node为根节点的二分搜索树中，返回给定键值的排名（名次从1开始）
     *
     * @param node
     * @param key
     * @return
     */
    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        } else if (cmp > 0) {
            return 1 + size(node.left) + rank(node.right, key);
        } else {
            return 1 + size(node.left);
            /**
             * 返回以node为根节点的树中小于node.key的键的数量
             * return size(node.left);
             */
        }
    }

    /**
     * 在一node为根的二分搜索树中，返回键值key向上取整后的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp > 0) {
            return ceiling(node.right, key);
        }
        Node temp = ceiling(node.left, key);
        if (temp != null) {
            return temp;
        } else {
            return node;
        }
    }

    /**
     * 在以node为根的二分搜索树中，返回键值key向下取整后的键值所对应的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left, key);
        }
        Node temp = floor(node.right, key);
        if (temp != null) {
            return temp;
        } else {
            return node;
        }
    }

    /**
     * 删除以node为根的二分搜索树中键值为key的节点
     * 返回删除节点后的新的二分搜索树的根
     *
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            Node temp = node;
            node = minimum(temp.right);
            node.right = removeMin(temp.right);
            node.left = temp.left;
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 删除以node为根节点的二分搜索树中的最大键值的节点
     * 返回删除后的二分搜索树的根节点
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = removeMax(node.right);
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 删除以node为根的二分搜索树的最小键值的节点
     * 返回删除后的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 在以node为根节点的二叉搜索树中寻找最大键值
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 在以node为根的二叉搜索树中，返回最小键值所对应的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

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

