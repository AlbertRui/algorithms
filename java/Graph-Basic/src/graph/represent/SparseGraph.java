package graph.represent;

import java.util.ArrayList;

/**
 * 稀疏图-邻接表
 *
 * @author AlbertRui
 * @date 2018-03-25 23:01
 */
public class SparseGraph {

    private int vertexNum;
    private int edgeNum;
    private boolean directed;
    private ArrayList[] graph;

    public SparseGraph(int vertexNum, boolean directed) {
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        this.directed = directed;
        this.graph = new ArrayList[vertexNum];
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        for (int i = 0; i < vertexNum; i++) {
            graph[i] = new ArrayList<Integer>();
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
}
