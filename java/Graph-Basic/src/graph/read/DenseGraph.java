package graph.read;

import java.util.Vector;

/**
 * 稠密图 - 邻接矩阵
 *
 * @author AlbertRui
 * @date 2018-03-26 19:11
 */
@SuppressWarnings({"javadoc", "unchecked", "unused"})
public class DenseGraph implements Graph {

    private int vertexNum;  // 节点数
    private int edgeNum;  // 边数
    private boolean directed;   // 是否为有向图
    private boolean[][] graph;      // 图的具体数据

    // 构造函数
    public DenseGraph(int vertexNum, boolean directed) {
        assert vertexNum >= 0;
        this.vertexNum = vertexNum;
        this.edgeNum = 0;    // 初始化没有任何边
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        graph = new boolean[vertexNum][vertexNum];
    }

    /**
     * 返回节点个数
     *
     * @return
     */
    @Override
    public int getVertexNum() {
        return vertexNum;
    }

    /**
     * 返回边的个数
     *
     * @return
     */
    @Override
    public int getEdgeNum() {
        return edgeNum;
    }

    /**
     * 向图中添加一个边
     */
    @Override
    public void addEdge(int v, int w) {

        assert v >= 0 && v < vertexNum;
        assert w >= 0 && w < vertexNum;

        if (hasEdge(v, w))
            return;

        graph[v][w] = true;
        if (!directed)
            graph[w][v] = true;

        edgeNum++;
    }

    /**
     * 验证图中是否有从v到w的边
     *
     * @param v
     * @param w
     * @return
     */
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < vertexNum;
        assert w >= 0 && w < vertexNum;
        return graph[v][w];
    }

    /**
     * 显示图的信息
     */
    public void show() {

        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++)
                System.out.print(graph[i][j] + "\t");
            System.out.println();
        }
    }

    /**
     * 返回图中一个顶点的所有邻边
     * 由于java使用引用机制，返回一个Vector不会带来额外开销,
     *
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < vertexNum;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < vertexNum; i++)
            if (graph[v][i])
                adjV.add(i);
        return adjV;
    }

}