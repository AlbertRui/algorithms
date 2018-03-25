package quick.union;

/**
 * 利用树实现并查集
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

    public UnionFind(int count) {
        this.count = count;
        this.parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
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
        parent[pRoot] = qRoot;
    }

}
