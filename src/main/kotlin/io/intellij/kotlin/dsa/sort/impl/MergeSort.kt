package io.intellij.kotlin.dsa.sort.impl

import io.intellij.kotlin.dsa.sort.Sort

/**
 * MergeSort
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
class MergeSort<T : Comparable<T>> : Sort<T> {

    override fun sort(array: Array<T>) {
        if (array.isEmpty() || array.size == 1) return
        this.divide(array, 0, array.size - 1)
    }

    private fun divide(array: Array<T>, left: Int, right: Int) {
        if (left >= right) return

        val mid = (left + right) / 2
        divide(array, left, mid)
        divide(array, mid + 1, right)
        merge(array, left, mid, right)
    }

    @Suppress("UNCHECKED_CAST")
    private fun merge(array: Array<T>, left: Int, mid: Int, right: Int) {
        // 临时数组
        val tmp: Array<Comparable<T>> = Array(right - left + 1) { array[left] }

        var x = left
        var y = mid + 1
        var tmpIndex = 0

        // 处理左右两个子数组，直到其中一个处理完
        while (x <= mid && y <= right) {
            tmp[tmpIndex++] = if (array[x] <= array[y]) {
                array[x++]
            } else {
                array[y++]
            }
        }

        // 处理左子数组剩余元素
        while (x <= mid) {
            tmp[tmpIndex++] = array[x++]
        }

        // 处理右子数组剩余元素
        while (y <= right) {
            tmp[tmpIndex++] = array[y++]
        }

        // 将临时数组中的元素复制回原数组
        tmp.forEachIndexed { index, element ->
            array[left + index] = element as T
        }
    }

}