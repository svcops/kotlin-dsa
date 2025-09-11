package io.intellij.project.dsa.cache.bloom

/**
 * BloomFilter 布隆过滤器。查找的反方向，可以快速确定某个值一定不存在
 *
 * @author tech@intellij.io
 */
interface BloomFilter {

    fun add(value: String)

    fun contains(value: String): Boolean = mustNotContains(value).not()

    /**
     * 如果返回 false，则表示该值一定不存在
     * 如果返回 true，则表示该值可能存在
     */
    fun mustNotContains(value: String): Boolean

}