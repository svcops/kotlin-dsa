package io.intellij.dsa.sort

import io.intellij.dsa.sort.impl.BubbleSort
import io.intellij.dsa.sort.impl.InsertSort
import io.intellij.dsa.sort.impl.MergeSort
import io.intellij.dsa.sort.impl.QuickSort
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * SortTest
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
class SortTest {

    @Test
    fun `test bubble sort`() {
        test(BubbleSort())
    }

    @Test
    fun `test insert sort`() {
        test(InsertSort())
    }

    @Test
    fun `test merge sort`() {
        test(MergeSort())
    }

    @Test
    fun `test quick sort`() {
        test(QuickSort())
    }

    private fun test(sort: Sort<Int>) {
        val result = sortArr(sort, createRandomArray(100000, 100000))
        println(result)
        Assertions.assertTrue(result.sorted)
        Assertions.assertTrue(result.same)
    }

}