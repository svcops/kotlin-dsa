package io.intellij.kotlin.dsa.tree.bst

const val DEFAULT_HEIGHT = 1

interface BST<K : Comparable<K>, V> {

    fun isEmpty(): Boolean {
        return this.size() == 0
    }

    fun size(): Int

    fun getRoot(): BSTNode<K, V>?

    fun contains(key: K): Boolean {
        return this.get(key) != null
    }

    fun add(k: K, v: V)

    fun remove(k: K): V?

    fun get(key: K): BSTNode<K, V>? {
        return get(getRoot(), key)
    }

    fun isBst(): Boolean {
        return isBST(node = getRoot())
    }

    fun getMin(): BSTNode<K, V>? {
        return getMin(getRoot())
    }

    fun getMax(): BSTNode<K, V>? {
        return getMax(getRoot())
    }

    fun preorderTraversal(action: (BSTNode<K, V>) -> Unit) {
        preorderTraversal(getRoot(), action)
    }

    fun inorderTraversal(action: (BSTNode<K, V>) -> Unit) {
        inorderTraversal(getRoot(), action)
    }

    fun postorderTraversal(action: (BSTNode<K, V>) -> Unit) {
        postorderTraversal(getRoot(), action)
    }

    fun bfs(action: (BSTNode<K, V>) -> Unit) {
        bfs(getRoot(), action)
    }

}

interface BSTNode<K : Comparable<K>, V> {

    fun getHeight(): Int

    fun setHeight(height: Int): BSTNode<K, V>

    fun getKey(): K

    fun setKey(key: K): BSTNode<K, V>

    fun getValue(): V

    fun setValue(value: V): BSTNode<K, V>

    fun getLeft(): BSTNode<K, V>?

    fun setLeft(left: BSTNode<K, V>?): BSTNode<K, V>

    fun getRight(): BSTNode<K, V>?

    fun setRight(right: BSTNode<K, V>?): BSTNode<K, V>

    fun isLeaf(): Boolean {
        return this.getLeft() == null && this.getRight() == null
    }

}
