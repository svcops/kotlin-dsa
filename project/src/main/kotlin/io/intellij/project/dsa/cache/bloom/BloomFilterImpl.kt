package io.intellij.project.dsa.cache.bloom

import java.util.*

/**
 * BloomFilterImpl
 *
 * @author tech@intellij.io
 */
class BloomFilterImpl(bitCount: Int) : BloomFilter {
    private val hashUtils = HashUtils(1, bitCount)
    private val bitSet: BitSet = BitSet(bitCount)

    override fun add(value: String) {
        hashUtils.indices(value).forEach {
            bitSet.set(it)
        }
    }

    override fun mustNotContains(value: String): Boolean {
        hashUtils.indices(value).forEach {
            if (!bitSet.get(it)) return true
        }
        return false
    }
}

