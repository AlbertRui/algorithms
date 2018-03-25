package quick.advance.path;

/**
 * 利用树实现并查集
 * 路径压缩，时间复杂度都近乎O(1)
 *
 * @author AlbertRui
 * @date 2018-03-25 19:22
 */
@SuppressWarnings({"javadoc", "unused"})
public class UnionFind {

    //并查元素集
    private int[] parent;
    //并查元素个数
    private int count;
    //rank[i]表示以i为根的集合中所表示的树的层数
    private int[] rank;

    /**
     * 构造函数中对并查集进行初始化
     *
     * @param count
     */
    public UnionFind(int count) {
        this.count = count;
        this.parent = new int[count];
        this.rank = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 并查元素的查找
     * 此处不需要维护rank的原因：
     * 事实上，这正是我们将这个变量叫做rank而不是叫诸如depth或者height的原因。
     * 因为这个rank只是我们做的一个标志当前节点排名的一个数字，
     * 当我们引入了路径压缩以后，维护这个深度的真实值相对困难一些，
     * 而且实践告诉我们，我们其实不需要真正维持这个值是真实的深度值，
     * 我们依然可以以这个rank值作为后续union过程的参考。
     * 因为根据我们的路径压缩的过程，rank高的节点虽然被抬了上来，
     * 但是整体上，我们的并查集从任意一个叶子节点出发向根节点前进，依然是一个rank逐渐增高的过程。
     * 也就是说，这个rank值在经过路径压缩以后，虽然不是真正的深度值，但仍然可以胜任，作为union时的参考。
     *
     * @param p
     * @return
     */
    @SuppressWarnings(value = "ALL")
    public int find(int p) {
        assert (p >= 0 && p < count);
//        while (p != parent[p]) {
//            //此处代码不可以合并，如果合并后，parent[p]是不会被赋值的
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    /**
     * 检查两个并查元素是否连接在一起
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将p和q所对应的根连接在一起
     *
     * @param p
     * @param q
     */
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        /*
          使生成的并查集树的高度小一些
         */
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

}
