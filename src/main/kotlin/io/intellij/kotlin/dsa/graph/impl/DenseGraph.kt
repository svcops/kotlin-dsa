package io.intellij.kotlin.dsa.graph.impl

import io.intellij.kotlin.dsa.graph.Edge
import io.intellij.kotlin.dsa.graph.Graph
import io.intellij.kotlin.dsa.graph.Vertex
import io.intellij.kotlin.dsa.graph.VertexIndex

/**
 * DenseGraph
 *
 * @author tech@intellij.io
 * @since 2025-05-29
 */
class DenseGraph : Graph {
    override fun isDirect(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isWeighted(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getVertexNum(): Int {
        TODO("Not yet implemented")
    }

    override fun getEdgeNum(): Int {
        TODO("Not yet implemented")
    }

    override fun getVertexes(): List<Vertex> {
        TODO("Not yet implemented")
    }

    override fun getEdges(): List<Edge> {
        TODO("Not yet implemented")
    }

    override fun getEdge(from: String, to: String): Edge? {
        TODO("Not yet implemented")
    }

    override fun getEdge(from: Int, to: Int): Edge? {
        TODO("Not yet implemented")
    }

    override fun connect(from: String, to: String, weight: Double) {
        TODO("Not yet implemented")
    }

    override fun adjacentEdges(vertexName: String): List<Edge> {
        TODO("Not yet implemented")
    }

    override fun adjacentEdges(vertexId: Int): List<Edge> {
        TODO("Not yet implemented")
    }

    override fun showGraph() {
        TODO("Not yet implemented")
    }

    override fun vertexIndex(): VertexIndex {
        TODO("Not yet implemented")
    }

}