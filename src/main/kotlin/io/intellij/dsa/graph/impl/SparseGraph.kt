package io.intellij.dsa.graph.impl

import io.intellij.dsa.getLogger
import io.intellij.dsa.graph.Edge
import io.intellij.dsa.graph.Graph
import io.intellij.dsa.graph.VertexIndex
import org.apache.commons.lang3.StringUtils
import java.util.*

/**
 * SparseGraph 稀疏图，使用邻接表实现
 *
 * @author tech@intellij.io
 * @since 2025-05-29
 */
class SparseGraph : Graph {

    companion object {
        val log = getLogger(DenseGraph::class.java)
    }

    private val directed: Boolean
    private val weighted: Boolean

    private val vertexIndex = VertexIndex()

    private val adjacencyList: TreeMap<Int, TreeMap<Int, Double>> = TreeMap()
    private var edgesCount: Int = 0

    constructor(directed: Boolean, weighted: Boolean) {
        this.directed = directed
        this.weighted = weighted
    }

    override fun isDirected(): Boolean = this.directed

    override fun isWeighted(): Boolean = this.weighted

    override fun getEdgeNum(): Int = this.edgesCount

    override fun getEdges(): List<Edge> {
        return if (isEmpty()) {
            emptyList()
        } else {
            val edges = mutableListOf<Edge>()
            for ((fromId, neighbors) in adjacencyList) {
                val fromVertex = vertexIndex.getVertex(fromId) ?: continue
                for ((toId, weight) in neighbors) {
                    val toVertex = vertexIndex.getVertex(toId) ?: continue
                    edges.add(Edge(from = fromVertex, to = toVertex, weight = weight))
                }
            }
            edges
        }
    }

    override fun getEdge(from: Int, to: Int): Edge? {
        if (from < 0 || to < 0 || from >= vertexIndex.size() || to >= vertexIndex.size()) {
            return null
        }
        if (from == to) {
            return null
        }
        return adjacencyList[from]?.let {
            it[to]?.let { weight ->
                val fromVertex = vertexIndex.getVertex(from)!!
                val toVertex = vertexIndex.getVertex(to)!!
                Edge(from = fromVertex, to = toVertex, weight = weight)
            }
        }
    }

    override fun connect(from: String, to: String, weight: Double) {
        if (StringUtils.isEmpty(from) || StringUtils.isEmpty(to)) {
            throw IllegalArgumentException("Vertex names cannot be empty")
        }
        if (from == to) {
            return
        }
        this.connect(
            vertexIndex.createVertex(from).id,
            vertexIndex.createVertex(to).id,
            weight,
            this.directed
        )
    }

    private fun connect(from: Int, to: Int, weight: Double, directed: Boolean) {
        val edges = adjacencyList.getOrPut(from) { TreeMap() }
        val isNewEdge = !edges.containsKey(to)

        if (!isNewEdge) {
            log.warn("Edge from $from to $to already exists, updating weight to $weight")
            this.edgesCount--
        }

        edges[to] = weight
        this.edgesCount++
        if (!directed) {
            this.connect(to, from, weight, true)
        }

    }

    override fun adjacentEdges(id: Int): List<Edge> {
        if (id < 0 || id >= vertexIndex.size()) {
            return emptyList()
        }
        val neighbors = adjacencyList[id]
        return if (neighbors == null) {
            emptyList()
        } else {
            vertexIndex.getVertex(id)!!.let { fromVertex ->
                neighbors.mapNotNull { (toId, weight) ->
                    vertexIndex.getVertex(toId)?.let { toVertex ->
                        Edge(from = fromVertex, to = toVertex, weight = weight)
                    }
                }
            }
        }
    }

    override fun showGraph() {
        println("Graph: ${if (directed) "Directed" else "Undirected"}, ${if (weighted) "Weighted" else "Unweighted"}")
        println("Vertices: ${vertexIndex.size()}")
        println("Edges: $edgesCount")

        // 打印邻接表
        println("Adjacency List:")
        val startFmt = "%s(%d) : "
        val toFmt = "%s(%d) -- %.2f -> %s(%d)   "

        for (fromId in 0 until adjacencyList.size) {
            val fromV = vertexIndex.getVertex(fromId)!!
            print(startFmt.format(fromV.name, fromId))

            adjacencyList[fromId]?.forEach { (toId, weight) ->
                val toV = vertexIndex.getVertex(toId) ?: return@forEach
                print(toFmt.format(fromV.name, fromId, weight, toV.name, toId))
            }

            println()
        }
    }

    override fun vertexIndex(): VertexIndex = this.vertexIndex

}