package io.intellij.kotlin.dsa.tree.bst

internal fun <K : Comparable<K>, V> isBST(node: BSTNode<K, V>?): Boolean {
    return isBSTHelper(node, null, null)
}

private fun <K : Comparable<K>, V> isBSTHelper(node: BSTNode<K, V>?, minVal: K?, maxVal: K?): Boolean {
    if (node == null) return true
    val key = node.getKey()

    // 检查当前节点是否违反边界条件
    if ((minVal != null && key <= minVal) || (maxVal != null && key >= maxVal)) {
        return false
    }

    // 递归检查左右子树，更新边界
    return isBSTHelper(node.getLeft(), minVal, key) &&
            isBSTHelper(node.getRight(), key, maxVal)
}

internal fun <K : Comparable<K>, V> get(node: BSTNode<K, V>?, k: K): BSTNode<K, V>? {
    return if (node == null) {
        null
    } else {
        when {
            k < node.getKey() -> get(node.getLeft(), k)
            k > node.getKey() -> get(node.getRight(), k)
            else -> node // Found the node
        }
    }
}

internal fun <K : Comparable<K>, V> getMin(node: BSTNode<K, V>?): BSTNode<K, V>? {
    return node?.getLeft()?.let { getMin(it) } ?: node
}

internal fun <K : Comparable<K>, V> getMax(node: BSTNode<K, V>?): BSTNode<K, V>? {
    return node?.getLeft()?.let { getMax(it) } ?: node
}

internal fun <K : Comparable<K>, V> preorderTraversal(node: BSTNode<K, V>?, action: (BSTNode<K, V>) -> Unit) {
    if (node == null) {
        return
    }
    action.apply { node }
    preorderTraversal(node.getLeft(), action)
    preorderTraversal(node.getRight(), action)
}

internal fun <K : Comparable<K>, V> inorderTraversal(node: BSTNode<K, V>?, action: (BSTNode<K, V>) -> Unit) {
    if (node == null) {
        return
    }
    inorderTraversal(node.getLeft(), action)
    action.apply { node }
    inorderTraversal(node.getRight(), action)
}

internal fun <K : Comparable<K>, V> postorderTraversal(node: BSTNode<K, V>?, action: (BSTNode<K, V>) -> Unit) {
    if (node == null) {
        return
    }
    postorderTraversal(node.getLeft(), action)
    postorderTraversal(node.getRight(), action)
    action.apply { node }
}

internal fun <K : Comparable<K>, V> bfs(node: BSTNode<K, V>?, action: (BSTNode<K, V>) -> Unit) {
    if (node == null) {
        return
    }
    val queue = ArrayDeque<BSTNode<K, V>>()

    queue.add(node)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        action(current)

        current.getLeft()?.let { queue.add(it) }
        current.getRight()?.let { queue.add(it) }
    }
}