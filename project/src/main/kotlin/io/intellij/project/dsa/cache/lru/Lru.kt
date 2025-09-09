package io.intellij.project.dsa.cache.lru

/**
 * LRU(Least Recently Used) 最近最少使用缓存
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