package io.intellij.dsa.sort.impl

import io.intellij.dsa.sort.Sort
import io.intellij.dsa.swap

/**
 * InsertSort 插入排序
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
class InsertSort<T : Comparable<T>> : Sort<T> {

    override fun sort(array: Array<T>) {
        if (array.isEmpty() || array.size == 1) return

        val n = array.size
        for (i in 1 until n) {
            for (j in i downTo 1) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1)
                }
            }
        }
    }

}