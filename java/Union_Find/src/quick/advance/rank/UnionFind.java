package quick.advance.rank;

/**
 * 利用树实现并查集
 * 基于rank对并查集进行优化（树的高度）
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
     *
     * @param p
     * @return
     */
    @SuppressWarnings(value = "ALL")
    public int find(int p) {
        assert (p >= 0 && p < count);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
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
