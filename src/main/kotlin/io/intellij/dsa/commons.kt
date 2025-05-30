package io.intellij.dsa

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)

fun <T : Comparable<T>> swap(array: Array<T>, i: Int, j: Int) {
    if (i == j) {
        return
    }
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}
