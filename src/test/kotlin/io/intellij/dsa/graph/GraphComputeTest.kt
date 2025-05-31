package io.intellij.dsa.graph

import io.intellij.dsa.graph.compute.Traverse
import org.junit.jupiter.api.Test

/**
 * GraphComputeTest
 *
 * @author tech@intellij.io
 * @since 2025-05-31
 */
class GraphComputeTest {

    private val traverseGraphText = """
        A B 1
        B C 2
        C D 1
        A E 1
        E F 1
        F G 1
        """.trimIndent()

    @Test
    fun `test graph traverse dfs`() {
        Traverse(
            buildGraph(traverseGraphText, directed = false, weighted = true),
            { println("Vertex: ${it.name}") },
            { println("Edge: ${it.from.name} -> ${it.to.name}, weight: ${it.weight}") }
        ).dfs()
    }

    @Test
    fun `test graph traverse bfs`() {
        Traverse(
            buildGraph(traverseGraphText, directed = false, weighted = true),
            { println("Vertex: ${it.name}") },
            { println("Edge: ${it.from.name} -> ${it.to.name}, weight: ${it.weight}") }
        ).bfs()
    }

}