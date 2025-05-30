package io.intellij.kotlin.dsa.tree

import io.intellij.kotlin.dsa.tree.bst.BST
import io.intellij.kotlin.dsa.tree.bst.BasicBST
import org.junit.jupiter.api.Assertions
import kotlin.test.Test

/**
 * BstTest
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
class BstTest {

    @Test
    fun `test basic bst`() {
        val basic: BST<Int, Int> = BasicBST()

        for (i in 1..7) {
            basic.add(i, i * 10)
        }

        Assertions.assertEquals(7, basic.size())

        for (i in 1..7) {
            basic.remove(i)
        }

        Assertions.assertEquals(0, basic.size())
    }

}