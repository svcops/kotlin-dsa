package io.intellij.dsa.tree.twothree

/**
 * TTTree
 *
 * @author tech@intellij.io
 * @since 2025-06-03
 */
interface TTTree<K : Comparable<K>, V> {

    fun isEmpty(): Boolean = size() == 0

    fun size(): Int

    fun contains(key: K): Boolean

    fun get(key: K): V?

    fun add(key: K, value: V)

    fun remove(key: K): V?

    fun clear()

}
