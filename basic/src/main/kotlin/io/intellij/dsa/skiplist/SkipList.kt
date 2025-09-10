package io.intellij.dsa.skiplist

import io.intellij.dsa.DataStructurePrintable
import io.intellij.dsa.KVOperation

/**
 * SkipList 跳表是对有序链表的改进
 *
 * @author tech@intellij.io
 */
interface SkipList<K : Comparable<K>, V> : KVOperation<K, V>, DataStructurePrintable {

    /**
     * 跳表的层数
     */
    fun level(): Int

}