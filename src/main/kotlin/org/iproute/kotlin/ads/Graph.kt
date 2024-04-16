package org.iproute.kotlin.ads

/**
 * 定义边 Edge
 *
 * @property from
 * @property to
 * @property weight
 * @constructor Create Edge
 */
data class Edge(val from: String, val to: String, val weight: Double)


/**
 * 定义图
 *
 * @constructor 图
 */
interface Graph {

    /**
     * 是否是有向图
     *
     * @return true | false
     */
    fun isDirect(): Boolean

    /**
     * 获取边的个数
     *
     * @return Int
     */
    fun edgesNum(): Int

    /**
     * 获取顶点的个数
     *
     * @return Int
     */
    fun verticiesNum(): Int

    /**
     * 获取所有的边
     *
     * @return List<Edge>
     */
    fun getEdges(): List<Edge>

    /**
     * 获取所有的顶点
     *
     * @return List<String>
     */
    fun getVertices(): List<String>

    /**
     * 连接 from 和 to
     *
     * @param from
     * @param to
     * @param weight
     */
    fun connect(from: String, to: String, weight: Double)

    /**
     * 根据顶点迭代顶点周围的边
     *
     * @param v 顶点
     * @return List<Edge>
     */
    fun adj(v: String): List<Edge>

    /**
     * 从某个点到另外的一个点是否有边
     *
     * @param from
     * @param to
     * @return
     */
    fun hasEdge(from: String, to: String): Boolean

    /**
     * 获取边的权重
     *
     * @param from
     * @param to
     * @return
     */
    fun getWeight(from: String, to: String): Double?

    /**
     * 打印图
     *
     */
    fun show()
}


open class SparseGraph(private val direct: Boolean) : Graph {
    private val graph: Map<String, Set<Edge>> = HashMap()
    private val vertices: Set<String> = HashSet()
    private val edges: Set<Edge> = HashSet()

    override fun isDirect(): Boolean {
        return this.direct
    }

    override fun edgesNum(): Int {
        val vertexEdgeAccumulator: (Map.Entry<String, Set<Edge>>) -> Int = { (_, edges) -> edges.size }
        return graph.entries.sumOf(vertexEdgeAccumulator)
    }

    override fun verticiesNum(): Int {
        return this.vertices.size
    }

    override fun getEdges(): List<Edge> {
        return this.edges.toList()
    }

    override fun getVertices(): List<String> {
        return this.vertices.toList()
    }

    override fun connect(from: String, to: String, weight: Double) {
        TODO("Not yet implemented")
    }

    override fun adj(v: String): List<Edge> {
        TODO("Not yet implemented")
    }

    override fun hasEdge(from: String, to: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getWeight(from: String, to: String): Double? {
        TODO("Not yet implemented")
    }

    override fun show() {
        TODO("Not yet implemented")
    }

}

