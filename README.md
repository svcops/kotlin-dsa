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

[二分搜索树的定义](src/main/kotlin/io/intellij/dsa/tree/bst/BST.kt)

- [节点定义](src/main/kotlin/io/intellij/dsa/tree/bst/BSTNode.kt)

[基础二分搜索树实现](src/main/kotlin/io/intellij/dsa/tree/bst/BasicBST.kt)

[AVL平衡树实现](src/main/kotlin/io/intellij/dsa/tree/bst/AVLTree.kt)

- [旋转](src/main/kotlin/io/intellij/dsa/tree/bst/AVLRotate.kt)

红黑树：红黑树是4阶B树 (`2-3-4`树)的变体

左偏红黑树：左偏红黑树是红黑树的一种变体，它的对红边（点）的位置做了一定限制，使得其插入与删除操作可以与 2-3 树构成一一对应

AA树：AA 树是红黑树的一种变体，与红黑树不同，AA 树上的红色节点只能作为右子节点。这导致 AA 树模拟了 2-3 树

## 图

[图的定义](src/main/kotlin/io/intellij/dsa/graph/Graph.kt) [顶点和边的定义](src/main/kotlin/io/intellij/dsa/graph/VertexEdge.kt)

- [稠密图 邻接矩阵](src/main/kotlin/io/intellij/dsa/graph/impl/DenseGraph.kt)
- [稀疏图 邻接表](src/main/kotlin/io/intellij/dsa/graph/impl/SparseGraph.kt)
