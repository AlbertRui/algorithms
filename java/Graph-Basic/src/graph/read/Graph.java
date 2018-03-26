package graph.read;

/**
 * @author AlbertRui
 * @date 2018-03-26 19:04
 */
public interface Graph {

    /**
     * 获取边的个数
     *
     * @return
     */
    int getEdgeNum();

    /**
     * 获取顶点个数
     *
     * @return
     */
    int getVertexNum();

    /**
     * 添加一条边
     *
     * @param v
     * @param w
     */
    void addEdge(int v, int w);

    /**
     * 是否存在一条边
     *
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(int v, int w);

    /**
     * 将图的数据打印到控制台
     */
    void show();

    /**
     * 返回邻接矩阵的迭代
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);

}
