package io.intellij.dsa.graph.compute

import io.intellij.dsa.graph.Graph
import io.intellij.dsa.graph.GraphCompute
import io.intellij.dsa.graph.Vertex
import io.intellij.dsa.uf.IndexedUnionFind
import io.intellij.dsa.uf.UnionFind

/**
 * Components 无向图连通分量
 *
 * @author tech@intellij.io
 * @since 2025-05-31
 */
class Components(graph: Graph) : GraphCompute(graph) {

    init {
        checkEmpty().checkDirected(false)
    }

    fun compute(): Result {
        val result = Result(graph)
        val visited = BooleanArray(graph.getVertexIndex().size())
        var count: Int

        graph.getVertexes().apply {
            count = 0
        }.forEach { vertex ->
            if (!visited[vertex.id]) {
                this.dfs(vertex, visited, result)
                count++
                result.setComponentCount(count)
            }
        }
        return result
    }

    private fun dfs(vertex: Vertex, visited: BooleanArray, result: Result) {
        visited[vertex.id] = true

        this.graph.adjacentEdges(vertex.id).forEach { edge ->
            val toV = edge.to
            if (visited[toV.id]) return@forEach

            // Union-Find 合并操作
            result.uf.union(vertex, toV)

            // 继续深度优先遍历
            this.dfs(toV, visited, result)
        }
    }

    class Result(private val graph: Graph) {

        private var componentCount: Int = 0
        val uf: UnionFind<Vertex> = IndexedUnionFind(Vertex::id)

        fun setComponentCount(count: Int) {
            this.componentCount = count
        }

        fun getComponentCount(): Int = this.componentCount

        fun hasPath(src: String, dest: String): Boolean {
            val srcV = graph.getVertexIndex().getVertex(src)
            val destV = graph.getVertexIndex().getVertex(dest)
            if (srcV == null || destV == null) return false
            return uf.isConnected(srcV, destV)
        }

    }

}