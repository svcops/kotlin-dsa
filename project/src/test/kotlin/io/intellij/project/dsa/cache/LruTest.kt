package io.intellij.project.dsa.cache

import io.intellij.project.dsa.cache.lru.buildLruCache
import org.junit.jupiter.api.Test

/**
 * LruTest
 *
 * @author tech@intellij.io
 */
class LruTest {

    @Test
    fun `test lru`() {
        val maxSize = 20
        val lru = buildLruCache<Int, String>(maxSize)
        for (i in 1..maxSize * 2) {
            lru.put(i, "value-$i")
            lru.print()
        }
        println("lru size = ${lru.size()}")
    }

}