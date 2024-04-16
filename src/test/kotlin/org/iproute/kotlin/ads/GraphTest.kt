package org.iproute.kotlin.ads

import org.junit.jupiter.api.Test

/**
 * GraphTest
 *
 * @author zhuzhenjie
 */
class GraphTest {

    @Test
    fun `test show direct graph`() {
        val graph: Graph = SparseGraph(true)

        graph.connect("A", "B", 1.0)
        graph.connect("B", "C", 1.0)
        graph.connect("A", "C", 3.0)

        graph.show()
    }

    @Test
    fun `test show undirected graph`() {
        val graph: Graph = SparseGraph(false)

        graph.connect("A", "B", 1.0)
        graph.connect("B", "C", 1.0)
        graph.connect("A", "C", 3.0)

        graph.show()

    }
}