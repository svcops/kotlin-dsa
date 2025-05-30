package io.intellij.dsa.sort.impl

import io.intellij.dsa.sort.Sort
import io.intellij.dsa.swap

/**
 * BubbleSort 冒泡排序
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
class BubbleSort<T : Comparable<T>> : Sort<T> {

    override fun sort(array: Array<T>) {
        if (array.isEmpty() || array.size == 1) return
        val n = array.size
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (array[j] < array[i]) {
                    swap(array, i, j)
                }
            }
        }
    }

}