package quick.find;

/**
 * 并查集
 *
 * @author AlbertRui
 * @date 2018-03-25 17:51
 */
@SuppressWarnings({"javadoc", "unused"})
public class UnionFind {

    //并查集数组
    private int[] id;
    //数组元素个数
    private int count;

    public UnionFind(int count) {
        this.count = count;
        this.id = new int[count];
        //冰茶元素初始化
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    public int find(int p) {
        assert (p >= 0 && p < count);
        return id[p];
    }

    /**
     * 查看元素p和q是否所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和q所属集合
     *
     * @param p
     * @param q
     */
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

}
