package graph.read;

import java.util.Vector;

/**
 * 稀疏图 - 邻接表
 *
 * @author AlbertRui
 * @date 2018-03-26 19:31
 */
@SuppressWarnings({"javadoc", "unused", "unchecked"})
public class SparseGraph implements Graph {

    private int vertexNum;  // 节点数
    private int edgeNum;  // 边数
    private boolean directed;   // 是否为有向图
    private Vector<Integer>[] graph; // 图的具体数据

    /**
     * 构造函数
     *
     * @param vertexNum
     * @param directed
     */
    public SparseGraph(int vertexNum, boolean directed) {
        assert vertexNum >= 0;
        this.vertexNum = vertexNum;
        this.edgeNum = 0;    // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        graph = new Vector[vertexNum];
        for (int i = 0; i < vertexNum; i++)
            graph[i] = new Vector<>();
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
     *
     * @param v
     * @param w
     */
    @Override
    public void addEdge(int v, int w) {

        assert v >= 0 && v < vertexNum;
        assert w >= 0 && w < vertexNum;

        graph[v].add(w);
        if (v != w && !directed)
            graph[w].add(v);

        edgeNum++;
    }

    /**
     * 验证图中是否有从v到w的边
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v < vertexNum;
        assert w >= 0 && w < vertexNum;

        for (int i = 0; i < graph[v].size(); i++)
            if (graph[v].elementAt(i) == w)
                return true;
        return false;
    }

    /**
     * 显示图的信息
     */
    public void show() {

        for (int i = 0; i < vertexNum; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < graph[i].size(); j++)
                System.out.print(graph[i].elementAt(j) + "\t");
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
        return graph[v];
    }

}