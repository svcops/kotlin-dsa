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
        require(!graph.isEmpty()) {
            "Graph is empty"
        }
        return this
    }

    fun checkDirected(expectedDirected: Boolean): GraphCompute {
        require(graph.isDirected() == expectedDirected) {
            "Graph is not ${if (expectedDirected) "directed" else "undirected"}"
        }
        return this
    }

    fun checkWeighted(expectedWeighted: Boolean): GraphCompute {
        require(graph.isWeighted() == expectedWeighted) {
            "Graph is not ${if (expectedWeighted) "weighted" else "unweighted"}"
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
