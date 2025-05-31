package io.intellij.dsa.graph

import java.util.*

/**
 * Vertex
 *
 * @author tech@intellij.io
 * @since 2025-05-29
 */
data class Vertex(val name: String, val id: Int)

data class Edge(val from: Vertex, val to: Vertex, var weight: Double?)

// 维护 id 和 name 的索引
class VertexIndex {
    // 顶点的表
    private var vertexes: MutableList<Vertex> = mutableListOf()
    private var namedVertexes: TreeMap<String, Vertex> = TreeMap()

    fun isEmpty(): Boolean = vertexes.isEmpty()

    fun size(): Int = vertexes.size

    fun getVertex(id: Int): Vertex? {
        return if (vertexes.isEmpty() || id < 0 || id >= vertexes.size) {
            null
        } else {
            vertexes[id]
        }
    }

    fun getVertexes(): List<Vertex> = vertexes

    fun getVertex(name: String): Vertex? {
        return namedVertexes[name]?.let { return it }
    }

    fun createVertex(name: String): Vertex {
        return namedVertexes[name] ?: run {
            val vertex = Vertex(name, vertexes.size)
            vertexes.add(vertex)
            namedVertexes.put(name, vertex)
            vertex
        }
    }

}
