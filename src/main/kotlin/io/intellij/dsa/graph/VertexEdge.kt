package io.intellij.dsa.graph

/**
 * Vertex
 *
 * @author tech@intellij.io
 * @since 2025-05-29
 */
data class Vertex(val name: String, val id: Int)

data class Edge(val from: Vertex, val to: Vertex, var weight: Double = DEFAULT_UNWEIGHTED_VALUE)

open class VertexIndex {
}
