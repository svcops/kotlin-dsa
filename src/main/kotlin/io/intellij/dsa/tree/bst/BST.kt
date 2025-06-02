package io.intellij.dsa.tree.bst

interface BST<K : Comparable<K>, V> {

    /**
     * Checks if the binary search tree (BST) is empty.
     *
     * @return true if the BST contains no elements, false otherwise
     */
    fun isEmpty(): Boolean {
        return this.size() == 0
    }

    /**
     * Returns the number of elements currently stored in the binary search tree (BST).
     *
     * @return the total count of elements in the tree
     */
    fun size(): Int

    /**
     * Retrieves the root node of the binary search tree (BST).
     *
     * @return the root node of the BST, or null if the tree is empty
     */
    fun getRoot(): BSTNode<K, V>?

    /**
     * Determines whether the binary search tree (BST) contains a specific key.
     *
     * @param key the key to search for in the binary search tree
     * @return true if the key exists in the tree, false otherwise
     */
    fun contains(key: K): Boolean {
        return this.get(key) != null
    }

    /**
     * Adds a key-value pair to the binary search tree (BST). If the key already exists,
     * updates the value associated with the key.
     *
     * @param k the key to insert or update in the BST
     * @param v the value to associate with the specified key
     */
    fun add(k: K, v: V)

    /**
     * Removes a key-value pair from the binary search tree (BST) if the specified key exists.
     *
     * @param k the key to remove from the BST
     * @return the value associated with the removed key, or null if the key is not found in the BST
     */
    fun remove(k: K): V?

    /**
     * Retrieves the node associated with the specified key in the binary search tree (BST).
     *
     * @param key the key to search for in the binary search tree
     * @return the node corresponding to the given key, or null if the key is not found
     */
    fun get(key: K): BSTNode<K, V>? {
        return get(getRoot(), key)
    }

    /**
     * Determines whether the binary search tree (BST) satisfies the properties of a valid BST.
     *
     * @return true if the tree is a valid binary search tree, false otherwise
     */
    fun isBst(): Boolean {
        return isBST(node = getRoot())
    }

    /**
     * Retrieves the minimum node in the binary search tree (BST).
     *
     * @return the node containing the smallest key in the tree, or null if the tree is empty
     */
    fun getMin(): BSTNode<K, V>? {
        return getMin(getRoot())
    }

    /**
     * Retrieves the maximum node in the binary search tree (BST).
     *
     * @return the node containing the largest key in the tree, or null if the tree is empty
     */
    fun getMax(): BSTNode<K, V>? {
        return getMax(getRoot())
    }

    fun preorder(action: (BSTNode<K, V>) -> Unit) {
        getRoot()?.preorder(action)
    }

    fun inorder(action: (BSTNode<K, V>) -> Unit) {
        getRoot()?.inorder(action)
    }

    fun postorder(action: (BSTNode<K, V>) -> Unit) {
        getRoot()?.postorder(action)
    }

    fun bfs(action: (BSTNode<K, V>) -> Unit) {
        getRoot()?.bfs(action)
    }

    fun <K : Comparable<K>, V> BSTNode<K, V>.preorder(action: (BSTNode<K, V>) -> Unit) {
        action.apply { this }

        getLeft()?.preorder(action)
        getRight()?.preorder(action)
    }

    fun <K : Comparable<K>, V> BSTNode<K, V>.inorder(action: (BSTNode<K, V>) -> Unit) {
        getLeft()?.inorder(action)
        action.apply { this }
        getRight()?.inorder(action)
    }

    fun <K : Comparable<K>, V> BSTNode<K, V>.postorder(action: (BSTNode<K, V>) -> Unit) {
        getLeft()?.postorder(action)
        getRight()?.postorder(action)
        action.apply { this }
    }


    fun <K : Comparable<K>, V> BSTNode<K, V>.bfs(action: (BSTNode<K, V>) -> Unit) {
        val queue = ArrayDeque<BSTNode<K, V>>()
        queue.add(this)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            action(current)

            current.getLeft()?.let { queue.addLast(it) }
            current.getRight()?.let { queue.addLast(it) }
        }
    }

}
