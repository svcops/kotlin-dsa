package io.intellij.dsa.sort.impl

import io.intellij.dsa.sort.Sort
import io.intellij.dsa.swap

/**
 * QuickSort
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
class QuickSort<T : Comparable<T>> : Sort<T> {

    override fun sort(array: Array<T>) {
        if (array.isEmpty() || array.size == 1) return
        quickSort(array, 0, array.size - 1)
    }

    private fun quickSort(array: Array<T>, left: Int, right: Int) {
        if (left >= right) return

        val pivotIndex = oneWay(array, left, right)

        quickSort(array, left, pivotIndex - 1)
        quickSort(array, pivotIndex + 1, right)

    }

    private fun oneWay(array: Array<T>, left: Int, right: Int): Int {
        val pivot = array[left]

        var start = left + 1
        var end = right

        while (true) {
            if (array[start] <= pivot) {
                start++
            } else {
                swap(array, end, start)
                end--
            }
            // 极限情况
            // case1: start=r+1 pivot 全小于 arr[l+1...r]
            // case2: end=l     pivot 全大于等于 arr[l+1...r]
            // 终止的本质是 start=end+1
            if (start > end) {
                break
            }
        }

        swap(array, left, end)
        return end
    }

    private fun twoWay(array: Array<T>, left: Int, right: Int): Int {
        val pivot = array[left]
        var start = left + 1
        var end = right

        while (true) {
            while (start <= end && array[start] < pivot) {
                start++
            }
            while (end >= start && array[end] >= pivot) {
                end--
            }

            if (start > end) {
                break
            }
            swap(array, start, end)
        }

        swap(array, left, end)
        return end
    }

}