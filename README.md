# kotlin dsa

> Data Structures and Algorithms in Kotlin

## 排序

[冒泡排序](src/main/kotlin/io/intellij/dsa/sort/impl/BubbleSort.kt)
[插入排序](src/main/kotlin/io/intellij/dsa/sort/impl/InsertSort.kt)

[归并排序](src/main/kotlin/io/intellij/dsa/sort/impl/MergeSort.kt)
[快速排序](src/main/kotlin/io/intellij/dsa/sort/impl/QuickSort.kt)

## 查找

### 堆

[堆的定义](src/main/kotlin/io/intellij/dsa/tree/heap/Heap.kt)

[堆的实现](src/main/kotlin/io/intellij/dsa/tree/heap/HeapImpl.kt)

`heapify`

```kotlin
private fun heapify() {
    // 从最后一个非叶子节点开始向上调整
    for (i in (count / 2 - 1) downTo 0) {
        siftDown(i)
    }
}
```

### 二分搜索树

[基础二分搜索树](src/main/kotlin/io/intellij/dsa/tree/bst/BasicBST.kt)

[AVL平衡树](src/main/kotlin/io/intellij/dsa/tree/bst/AvlTree.kt)
