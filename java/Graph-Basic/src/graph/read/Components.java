package graph.read;

/**
 * 求无权图的联通分量
 *
 * @author AlbertRui
 * @date 2018-03-26 20:29
 */
public class Components {

    private Graph G;            // 图的引用
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int ccount;         // 记录联通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记

    /**
     * 图的深度优先遍历
     *
     * @param v
     */
    void dfs(int v) {

        visited[v] = true;
        id[v] = ccount;

        for (int i : G.adj(v)) {
            if (!visited[i])
                dfs(i);
        }
    }

    /**
     * 构造函数, 求出无权图的联通分量
     *
     * @param graph
     */
    public Components(Graph graph) {

        // 算法初始化
        G = graph;
        visited = new boolean[G.getVertexNum()];
        id = new int[G.getVertexNum()];
        ccount = 0;
        for (int i = 0; i < G.getVertexNum(); i++) {
            visited[i] = false;
            id[i] = -1;
        }

        // 求图的联通分量
        for (int i = 0; i < G.getVertexNum(); i++)
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
    }

    /**
     * 返回图的联通分量个数
     */
    int count() {
        return ccount;
    }

    /**
     * 查询点v和点w是否联通
     */
    boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.getVertexNum();
        assert w >= 0 && w < G.getVertexNum();
        return id[v] == id[w];
    }
}

