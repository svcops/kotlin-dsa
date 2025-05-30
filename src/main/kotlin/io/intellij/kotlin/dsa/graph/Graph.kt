package io.intellij.kotlin.dsa.graph

const val DEFAULT_UNWEIGHTED_VALUE = 1.0

/**
 * Graph
 *
 * @author tech@intellij.io
 * @since 2025-05-29
 */
interface Graph {

    /**
     * Checks if the graph is empty.
     *
     * @return true if the graph has no vertices, false otherwise.
     */
    fun isEmpty(): Boolean {
        return getVertexNum() == 0
    }

    /**
     * Checks if the graph is directed.
     *
     * @return true if the graph is directed, false if it is undirected.
     */
    fun isDirect(): Boolean

    /**
     * Checks if the graph is weighted.
     *
     * @return true if the graph has weighted edges, false if all edges are unweighted.
     */
    fun isWeighted(): Boolean

    /**
     * Gets the number of vertices in the graph.
     *
     * @return the number of vertices.
     */
    fun getVertexNum(): Int

    /**
     * Gets the number of edges in the graph.
     *
     * @return the number of edges.
     */
    fun getEdgeNum(): Int

    /**
     * Retrieves the list of all vertices present in the graph.
     *
     * @return a list containing all vertices of the graph.
     */
    fun getVertexes(): List<Vertex>

    /**
     * Retrieves the list of all edges present in the graph.
     *
     * @return a list containing all edges of the graph.
     */
    fun getEdges(): List<Edge>

    fun getEdge(from: String, to: String): Edge?

    fun getEdge(from: Int, to: Int): Edge?

    fun connect(from: String, to: String, weight: Double = DEFAULT_UNWEIGHTED_VALUE)

    fun adjacentEdges(vertexName: String): List<Edge>

    fun adjacentEdges(vertexId: Int): List<Edge>

    fun showGraph()

    fun vertexIndex(): VertexIndex
}

open class GraphUtils {
    companion object {
    }
}
