package io.intellij.dsa.tree.bst

const val DEFAULT_HEIGHT = 1

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

    /**
     * Performs a preorder traversal of the binary search tree (BST) and applies the specified action
     * to each node in the tree.
     *
     * A preorder traversal processes the current node before recursively processing the left and
     * right child nodes. For each node visited, the provided action is executed.
     *
     * @param action a function that takes a single parameter, the currently visited BST node, and
     *               defines the operation to perform on that node during the traversal
     */
    fun preorderTraversal(action: (BSTNode<K, V>) -> Unit) {
        preorderTraversal(getRoot(), action)
    }

    /**
     * Performs an in-order traversal of the binary search tree (BST) and applies the specified action
     * to each node in the tree.
     *
     * In an in-order traversal, the left subtree is processed first, followed by the current node, and
     * finally the right subtree. For each node visited, the provided action is executed.
     *
     * @param action a function that takes a single parameter, the currently visited BST node, and
     * defines the operation to perform on that node during the traversal
     */
    fun inorderTraversal(action: (BSTNode<K, V>) -> Unit) {
        inorderTraversal(getRoot(), action)
    }

    /**
     * Performs a post-order traversal of the binary search tree (BST) and applies the specified action
     * to each node in the tree.
     *
     * In a post-order traversal, the left subtree is processed first, followed by the right subtree,
     * and finally the current node. For each node visited, the provided action is executed.
     *
     * @param action a function that takes a single parameter, the currently visited BST node, and
     * defines the operation to perform on that node during the traversal
     */
    fun postorderTraversal(action: (BSTNode<K, V>) -> Unit) {
        postorderTraversal(getRoot(), action)
    }

    /**
     * Performs a breadth-first traversal (BFS) on the binary search tree (BST) starting from the root node
     * and applies the specified action to each node encountered during the traversal.
     *
     * @param action a function that takes a single parameter, the currently visited BST node, and defines
     *               the operation to perform on that node during the traversal
     */
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
