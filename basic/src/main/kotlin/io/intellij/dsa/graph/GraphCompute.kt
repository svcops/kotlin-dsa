package io.intellij.dsa.graph

/**
 * GraphCompute
 *
 * @author tech@intellij.io
 * @since 2025-05-31
 */
abstract class GraphCompute {
    protected val graph: Graph

    constructor(graph: Graph) {
        this.graph = graph
    }

    fun checkEmpty(): GraphCompute {
        if (graph.isEmpty()) {
            throw IllegalArgumentException("Graph is empty")
        }
        return this
    }

    fun checkDirected(expectedDirected: Boolean): GraphCompute {
        if (graph.isDirected() != expectedDirected) {
            throw IllegalArgumentException("Graph is not ${if (expectedDirected) "directed" else "undirected"}")
        }
        return this
    }

    fun checkWeighted(expectedWeighted: Boolean): GraphCompute {
        if (graph.isWeighted() != expectedWeighted) {
            throw IllegalArgumentException("Graph is not ${if (expectedWeighted) "weighted" else "unweighted"}")
        }
        return this
    }

    fun checkVertex(name: String, required: Boolean): Vertex {
        return graph.vertexIndex().getVertex(name) ?: if (required) {
            throw IllegalArgumentException("Vertex '$name' not found")
        } else {
            throw NoSuchElementException("Vertex '$name' not found")
        }
    }

}