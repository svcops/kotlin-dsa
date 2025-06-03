package io.intellij.dsa.tree.twothree

/**
 * TTTreeImpl
 *
 * @author tech@intellij.io
 * @since 2025-06-03
 */
class TTTreeImpl<K : Comparable<K>, V> : TTTree<K, V> {
    private var root: TTNode<K, V>? = null
    private var count = 0

    override fun size(): Int = this.count

    override fun contains(key: K): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: K): V? {
        return get(this.root, key)
    }

    private fun get(node: TTNode<K, V>?, key: K): V? {
        if (node == null) return null

        if (node.isTwoNode()) {
            return when {
                key < node.keys[0].key -> get(node.children[0], key)
                key == node.keys[0].key -> node.keys[0].value
                else -> get(node.children[1], key)
            }
        } else if (node.isThreeNode()) {
            return when {
                key < node.keys[0].key -> get(node.children[0], key)
                key == node.keys[0].key -> node.keys[0].value
                key < node.keys[1].key -> get(node.children[1], key)
                key == node.keys[1].key -> node.keys[1].value
                else -> get(node.children[2], key)
            }
        } else {
            throw IllegalStateException("Invalid Node")
        }
    }

    override fun add(key: K, value: V) {
        if (this.root == null) {
            this.root = TTNode<K, V>().apply { add(key, value) }
            this.count++
            return
        }
        findLeaf(this.root!!, key, value)?.apply {
            // 不为空，说明没有替换值，添加新键值对
            this.add(key, value)
            count++
            // 如果当前节点的键值对数量超过2，进行分裂
            if (this.keys.size > 2) {
                splitRebalance(this)
            }
        }

    }

    private fun TTNode<K, V>.add(key: K, value: V) {
        when {
            keys.isEmpty() || key < keys[0].key -> keys.add(0, KVPair(key, value))
            keys.size == 1 || key < keys[1].key -> keys.add(1, KVPair(key, value))
            else -> keys.add(2, KVPair(key, value))
        }
    }

    // 如果在查找叶子节点的过程中发现值相同，替换值返回null
    private fun findLeaf(node: TTNode<K, V>, key: K, value: V): TTNode<K, V>? {
        var current = node
        while (!current.isLeaf()) {
            // compare
            if (current.isTwoNode()) {
                when {
                    key < current.keys[0].key -> current = current.children[0]
                    key == current.keys[0].key -> {
                        current.keys[0] = KVPair(key, value)
                        return null
                    }

                    else -> current = current.children[1]
                }
            } else if (current.isThreeNode()) {
                when {
                    key < current.keys[0].key -> current = current.children[0]
                    key == current.keys[0].key -> {
                        current.keys[0] = KVPair(key, value)
                        return null // 替换值返回null
                    }

                    key < current.keys[1].key -> current = current.children[1]
                    key == current.keys[1].key -> {
                        current.keys[1] = KVPair(key, value)
                        return null // 替换值返回null
                    }

                    else -> current = current.children[2]
                }
            } else {
                throw IllegalStateException("Invalid Node")
            }
        }
        return current
    }

    // 一定是3节点分裂
    private fun splitRebalance(splitNode: TTNode<K, V>) {
        /*
              x  y  z       y
            /   |  \      /   \
          a    b   c    x      z
         */

        val middlePair = splitNode.keys[1]

        // 创建两个新节点
        val leftNode = TTNode<K, V>()
        val rightNode = TTNode<K, V>()

        leftNode.add(splitNode.keys[0].key, splitNode.keys[0].value)
        rightNode.add(splitNode.keys[2].key, splitNode.keys[2].value)

        // 向上递归会遇到叶子节点
        if (!splitNode.isLeaf()) {
            // 子节点重新分配
            // 左子节点包含原节点的前两个子节点
            // 右子节点包含原节点的后两个子节点

            leftNode.children.addAll(listOf(splitNode.children[0], splitNode.children[1]))
            rightNode.children.addAll(listOf(splitNode.children[2], splitNode.children[3]))

            // 设置子节点的父节点
            leftNode.children.forEach { it.parent = leftNode }
            rightNode.children.forEach { it.parent = rightNode }
        }

        val parentNode = splitNode.parent
        if (parentNode == null) {
            this.root = TTNode<K, V>().apply {
                this.add(middlePair.key, middlePair.value)
                this.children.add(leftNode)
                this.children.add(rightNode)
            }
            // parent指向的形成
            leftNode.parent = this.root
            rightNode.parent = this.root
        } else {

            val index = parentNode.children.indexOf(splitNode)
            parentNode.children.removeAt(index)

            // 这里parent可能会形成4节点
            parentNode.children.add(index, rightNode)
            parentNode.children.add(index, leftNode)

            leftNode.parent = parentNode
            rightNode.parent = parentNode

            parentNode.add(middlePair.key, middlePair.value)
            if (parentNode.keys.size > 2) {
                splitRebalance(parentNode)
            }
        }

    }

    override fun remove(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun clear() {
        this.root == null
        this.count = 0
    }

}