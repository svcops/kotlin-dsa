package io.intellij.dsa.skiplist

/**
 * SkipList 跳表是对有序链表的改进
 *
 * @author tech@intellij.io
 */
interface SkipList<K : Comparable<K>, V> {

    /**
     * 是否为空
     */
    fun isEmpty(): Boolean = size() == 0

    /**
     * 跳表的大小
     */
    fun size(): Int

    /**
     * 跳表的层数
     */
    fun level(): Int

    /**
     * 查询元素
     */
    fun get(key: K): V?

    /**
     * 插入元素
     */
    fun insert(key: K, value: V)

    /**
     * 删除元素
     */
    fun remove(key: K): V?

    /**
     * 打印跳表
     */
    fun print()
}

/**
 * 默认最高层数
 */
const val DEFAULT_MAX_LEVEL = 16

/**
 * 默认产生层数的概率
 */
const val DEFAULT_P = 0.5

/**
 * 创建跳表
 */
fun <K : Comparable<K>, V> buildSkipList(maxLevel: Int = DEFAULT_MAX_LEVEL, p: Double = DEFAULT_P): SkipList<K, V> {
    return SkipListImpl(maxLevel, p)
}
