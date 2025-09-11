package io.intellij.project.dsa.cache

import io.intellij.project.dsa.buildBloomFilter
import kotlin.test.Test

/**
 * BloomFilterTest
 *
 * @author tech@intellij.io
 */
class BloomFilterTest {

    @Test
    fun `test bloom filter`() {
        val cl = Thread.currentThread().contextClassLoader
        val input = cl.getResourceAsStream("domain_apple.txt") ?: error("resource not found")

        val bloomFilter = buildBloomFilter(10000)
        input.bufferedReader().forEachLine {
            bloomFilter.add(it)
        }

        println("apple: ${bloomFilter.contains("www.apple.com")}")
        println("google: ${bloomFilter.contains("www.google.com")}")

    }
}