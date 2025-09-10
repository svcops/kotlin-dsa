package io.intellij.dsa.tree.bst

import kotlin.math.max

/**
 * AVLTree
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
class AVLTree<K : Comparable<K>, V> : BST<K, V> {
    private var root: BSTNode<K, V>? = null
    private var count = 0

    override fun size(): Int = this.count

    override fun getRoot(): BSTNode<K, V>? = this.root

    override fun insert(key: K, value: V) {
        root = add(root, key, value)
    }

    private fun add(node: BSTNode<K, V>?, k: K, v: V): BSTNode<K, V> {
        if (node == null) {
            count++
            return BasicBSTNode(k, v)
        }
        when {
            k < node.getKey() -> {
                node.setLeft(add(node.getLeft(), k, v)).updateHeight()
            }

            k > node.getKey() -> {
                node.setRight(add(node.getRight(), k, v)).updateHeight()
            }

            else -> {
                node.setValue(v)
            }
        }
        return node.updateHeight().rebalance(Action.ADD)
    }

    override fun remove(k: K): V? {
        return getNode(k)?.let { node ->
            val rtV = node.getValue()
            root = remove(root, k, rtV)
            rtV
        }
    }

    private fun remove(node: BSTNode<K, V>?, k: K, v: V): BSTNode<K, V>? {
        if (node == null) {
            return null
        }
        when {
            k < node.getKey() -> node.setLeft(remove(node.getLeft(), k, v))

            k > node.getKey() -> node.setRight(remove(node.getRight(), k, v))

            else -> {
                if (node.getLeft() == null && node.getRight() == null) {
                    count--
                    return null
                }

                // 剩余三种情况  左不空+右不空 左不空+右空  左空+右不空
                if (node.getLeft() != null) {
                    // 左不空+右不空 左不空+右空
                    val leftMax = getMax(node.getLeft())!!

                    node.setKey(leftMax.getKey())
                        .setValue(leftMax.getValue())
                    remove(node.getLeft(), leftMax.getKey(), leftMax.getValue())
                } else {
                    // 左空+右不空
                    val rightMin = getMin(node.getRight())!!
                    node.setKey(rightMin.getKey())
                        .setValue(rightMin.getValue())
                    node.setRight(remove(node.getRight(), rightMin.getKey(), rightMin.getValue()))
                }

            }
        }
        return node.updateHeight().rebalance(Action.REMOVE)
    }

    override fun clear() {
        this.root = null
        this.count = 0
    }

}

/**
 * Retrieves the height of the specified binary search tree (BST) node.
 * If the node is null, returns 0.
 *
 * @param node the node for which the height is to be determined; can be null
 * @return the height of the node, or 0 if the node is null
 */
internal fun <K : Comparable<K>, V> getNodeHeight(node: BSTNode<K, V>?): Int {
    return node?.getHeight() ?: 0
}

internal fun <K : Comparable<K>, V> BSTNode<K, V>.updateHeight(): BSTNode<K, V> {
    val max = max(getNodeHeight(this.getLeft()), getNodeHeight(this.getRight()))
    this.setHeight(max + 1)
    return this
}
