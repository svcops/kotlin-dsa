package io.intellij.dsa.tree

import io.intellij.dsa.tree.twothree.TTTreeImpl
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

    @Test
    fun `test two tree tree add`() {
        TTTreeImpl<Int, String>().apply {
            this.add(1, "one")
            this.printTree()

            this.add(2, "two")
            this.printTree()

            this.add(3, "three")
            this.printTree()

            this.add(4, "four")
            this.printTree()

            this.add(5, "five")
            this.printTree()

            this.add(6, "six")
            this.printTree()

            this.add(7, "seven")
            this.printTree()

            this.add(8, "eight")
            this.printTree()

            this.add(9, "nine")
            this.printTree()
        }
    }

}