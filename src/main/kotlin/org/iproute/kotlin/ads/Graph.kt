package org.iproute.kotlin.ads

/**
 * 定义边 Edge
 *
 * @property from
 * @property to
 * @property weight
 * @constructor Create Edge
 */
data class Edge(val from: String, val to: String, val weight: Double) {

    override fun hashCode(): Int {
        return "$from.$to".hashCode()
    }

    /**
     * Equals from 和 to 一样，定义为一条相同的边，忽略权重
     *
     * @param other
     * @return
     */
    override fun equals(other: Any?): Boolean {
        return if (other !is Edge) {
            false
        } else {
            other.from == from && other.to == to
        }
    }
}


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
     * 邻边迭代器, 图算法的核心
     *
     * @param v 顶点
     * @return List<Edge>
     */
    fun adj(v: String): Set<Edge>

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


/**
 * 稀疏图, 邻接矩阵实现
 *
 * @property direct 是否有向
 * @constructor Create empty Sparse graph
 */
open class SparseGraph(private val direct: Boolean) : Graph {

    private val graph = mutableMapOf<String, MutableSet<Edge>>()
    private val vertices = mutableSetOf<String>()
    private val edges = mutableSetOf<Edge>()

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
        if (from == to) {
            println("自环边 from == to, 不添加")
            return
        }

        this.vertices.add(from)
        this.vertices.add(to)

        // cover
        val ft = Edge(from, to, weight)
        this.graph.getOrPut(from) { mutableSetOf() }
            .also {
                it.add(ft)
                edges.add(ft)
            }

        if (!direct) {
            // 无向图的处理
            val tf = Edge(to, from, weight)
            this.graph.getOrPut(to) { mutableSetOf() }
                .also {
                    it.add(tf)
                    edges.add(tf)
                }
        }

    }


    override fun adj(v: String): Set<Edge> {
        return graph[v] ?: emptySet()
    }

    override fun hasEdge(from: String, to: String): Boolean {
        val fromEdges = graph[from] ?: return false
        return fromEdges.any { it.to == to }
    }

    override fun getWeight(from: String, to: String): Double? {
        if (!edges.contains(Edge(from, to, 0.0))) {
            return null
        }
        return edges.find { it.from == from && it.to == to }?.weight
    }

    override fun show() {
        this.graph.forEach { (from, edges) ->
            print("$from : ")
            edges.forEach {
                print("${it.to}(${it.weight}) ")
            }
            println()
        }
    }

}

