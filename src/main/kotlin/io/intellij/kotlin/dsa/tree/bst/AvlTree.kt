package io.intellij.kotlin.dsa.tree.bst

/**
 * AvlTree
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
class AvlTree<K : Comparable<K>, V> : BST<K, V> {
    private var root: BSTNode<K, V>? = null
    private var count = 0

    override fun size(): Int = this.count

    override fun getRoot(): BSTNode<K, V>? = this.root

    override fun add(k: K, v: V) {
        TODO("Not yet implemented")
    }

    override fun remove(k: K): V? {
        TODO("Not yet implemented")
    }

}
