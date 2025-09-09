package io.intellij.project.dsa.cache.lru

/**
 * LRU（Least Recently Used，最近最少使用）是一种常见的缓存淘汰策略：当缓存容量满时，优先淘汰“最近最久没有被访问”的数据项。
 *
 * - 核心思想：越“久未使用”的数据越不重要，先被淘汰
 * - 命中时机：每次 get 或 put 更新已有键，都将该键标记为“最近使用”
 * - 淘汰规则：容量满时移除最久未被访问的那一项。
 *
 * @author tech@intellij.io
 */
interface Lru<K, V> {

    fun isEmpty(): Boolean = size() == 0

    /**
     * 缓存的个数
     */
    fun size(): Int

    /**
     * 是否包含
     */
    fun containsKey(key: K): Boolean

    /**
     * 获取缓存
     */
    fun get(key: K): V?

    /**
     * 写入缓存，当缓存满了的时候，必须淘汰最久未用项
     */
    fun put(key: K, value: V)

    /**
     * 删除某个缓存
     */
    fun remove(key: K): V?

    /**
     * 清空缓存
     */
    fun clear()

    /**
     * 打印双向链表
     */
    fun print()
}

/**
 * 构建Lru缓存
 */
fun <K, V> buildLruCache(maxSize: Int): Lru<K, V> {
    return LruImpl(maxSize)
}