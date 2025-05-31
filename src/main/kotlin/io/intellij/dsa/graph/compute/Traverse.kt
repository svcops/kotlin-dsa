package io.intellij.dsa.graph.compute

import io.intellij.dsa.graph.Edge
import io.intellij.dsa.graph.Graph
import io.intellij.dsa.graph.GraphCompute
import io.intellij.dsa.graph.Vertex

/**
 * Traverse
 *
 * @author tech@intellij.io
 * @since 2025-05-31
 */
class Traverse(graph: Graph, vertexConsumer: (Vertex) -> Unit, edgeConsumer: (Edge) -> Unit) : GraphCompute(graph) {

    init {
        checkGraph()
    }

    fun dfs() {
    }

    fun bfs() {
    }

}