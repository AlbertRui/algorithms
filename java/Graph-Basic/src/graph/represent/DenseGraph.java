package graph.represent;

/**
 * 稠密图-邻接矩阵
 *
 * @author AlbertRui
 * @date 2018-03-25 22:26
 */
@SuppressWarnings({"unused", "javadoc"})
public class DenseGraph {
    private int vertexNum;//图的点数
    private int edgeNum;//图的边数
    private boolean directed;//是否为有向图
    private boolean[][] graph;//图的具体数据（两点之间是否相连）

    public DenseGraph(int vertexNum, boolean directed) {
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        graph = new boolean[vertexNum][vertexNum];
    }

    /**
     * 获取图中边的数量
     *
     * @return
     */
    public int getEdgeNum() {
        return edgeNum;
    }

    /**
     * 获取图中定点的数量
     *
     * @return
     */
    public int getVertexNum() {
        return vertexNum;
    }

    public void addEdge(int v, int w) {
        assert (v >= 0 && v < vertexNum);
        assert (w >= 0 && w < vertexNum);
        if (!hasEdge(v, w)) {
            graph[v][w] = true;
            if (!directed) {
                graph[w][v] = true;
            }
            edgeNum++;
        }
    }

    public boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < vertexNum);
        assert (w >= 0 && w < vertexNum);
        return graph[v][w];
    }

}
