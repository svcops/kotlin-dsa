package io.intellij.dsa.tree

import io.intellij.dsa.tree.twothree.TwoThreeTree
import kotlin.test.Test

/**
 * TwoThreeTreeTest
 *
 * @author tech@intellij.io
 * @since 2025-06-02
 */
class TwoThreeTest {

    @Test
    fun `test two three tree insert`() {
        TwoThreeTree().apply {
            // 10, 20, 5, 15, 30, 25, 35
            insert(10)
            insert(20)
            insert(5)
            insert(15)
            insert(30)
            insert(25)
            insert(35)
        }.inorder()
    }

}