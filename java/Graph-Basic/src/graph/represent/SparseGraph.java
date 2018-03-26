package graph.represent;

import java.util.ArrayList;

/**
 * 稀疏图-邻接表
 *
 * @author AlbertRui
 * @date 2018-03-25 23:01
 */
@SuppressWarnings({"javadoc", "unused"})
public class SparseGraph {

    private int vertexNum;
    private int edgeNum;
    private boolean directed;
    private ArrayList<Integer>[] graph;

    @SuppressWarnings(value = "unchecked")
    public SparseGraph(int vertexNum, boolean directed) {
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        this.directed = directed;
        this.graph = new ArrayList[vertexNum];
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        for (int i = 0; i < vertexNum; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    /**
     * 返回边的数量
     *
     * @return
     */
    public int getEdgeNum() {
        return edgeNum;
    }

    /**
     * 返回顶点的数量
     *
     * @return
     */
    public int getVertexNum() {
        return vertexNum;
    }

    /**
     * 添加一条边
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        assert (v >= 0 && v < vertexNum);
        assert (w >= 0 && w < vertexNum);
        graph[v].add(w);
        if (v != w && !directed) {
            graph[w].add(v);
        }
        edgeNum++;
    }

    /**
     * 判断v和w之间是否存在一条边
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < vertexNum);
        assert (w >= 0 && w < vertexNum);
        return graph[v].contains(w);
    }

    /**
     * 返回一个图中所有顶点的邻边
     *
     * @param vertexNum
     * @return
     */
    public Iterable<Integer> adj(int vertexNum) {
        return graph[vertexNum];
    }

}
