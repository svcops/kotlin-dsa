package io.intellij.kotlin.dsa.sort

/**
 * Sort
 *
 * @author tech@intellij.io
 * @since 2025-05-30
 */
interface Sort<T : Comparable<T>> {

    /**
     * Sorts the given array in ascending order.
     *
     * @param array the array to be sorted
     */
    fun sort(array: Array<T>)

}