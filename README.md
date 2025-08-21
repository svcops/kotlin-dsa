# Data Structures and Algorithms in Kotlin

<!-- TOC -->
* [Data Structures and Algorithms in Kotlin](#data-structures-and-algorithms-in-kotlin)
  * [动态规划](#动态规划)
  * [排序](#排序)
    * [O(n^2)](#on2)
    * [O(nlog(n))](#onlogn)
  * [查找](#查找)
    * [并查集](#并查集)
    * [堆](#堆)
    * [搜索树](#搜索树)
    * [压缩](#压缩)
  * [图](#图)
    * [定义](#定义)
    * [算法](#算法)
<!-- TOC -->

## 动态规划

[Dynamic Programming](dp.md)

## 排序

[排序的定义](src/main/kotlin/io/intellij/dsa/sort/Sort.kt)

### O(n^2)

[选择排序](src/main/kotlin/io/intellij/dsa/sort/impl/SelectSort.kt)

[插入排序](src/main/kotlin/io/intellij/dsa/sort/impl/InsertSort.kt)

### O(nlog(n))

[归并排序](src/main/kotlin/io/intellij/dsa/sort/impl/MergeSort.kt)

[快速排序](src/main/kotlin/io/intellij/dsa/sort/impl/QuickSort.kt)

## 查找

### 并查集

[并查集的定义](src/main/kotlin/io/intellij/dsa/uf/UnionFind.kt)

- [基于索引的并查集](src/main/kotlin/io/intellij/dsa/uf/IndexedUnionFind.kt)
- [基于树的并查集 连接对象本身](src/main/kotlin/io/intellij/dsa/uf/TreeUnionFind.kt)
  - 对象本身可对比
- [基于树的并查集 连接对象的唯一标识](src/main/kotlin/io/intellij/dsa/uf/TreeIdUnionFind.kt)
  - 唯一标识可对比

### 堆

[堆的定义](src/main/kotlin/io/intellij/dsa/tree/heap/Heap.kt)

[堆的实现](src/main/kotlin/io/intellij/dsa/tree/heap/HeapImpl.kt)

`heapify`

```kotlin
private fun heapify() {
    // 从最后一个非叶子节点开始向下调整
    for (i in (count / 2 - 1) downTo 0) {
        siftDown(i)
    }
}
```

### 搜索树

[二分搜索树定义](src/main/kotlin/io/intellij/dsa/tree/bst/BST.kt)

- [节点定义](src/main/kotlin/io/intellij/dsa/tree/bst/BSTNode.kt)

[基础二分搜索树实现](src/main/kotlin/io/intellij/dsa/tree/bst/BasicBST.kt)

[AVL平衡树实现](src/main/kotlin/io/intellij/dsa/tree/bst/AVLTree.kt)

- 基于 `height` 计算 `balance factor` 旋转平衡
  - `height`: 节点的高度，即从该节点到叶子节点的最长路径长度
- [旋转操作: LL RR LR RL](src/main/kotlin/io/intellij/dsa/tree/bst/AVLRotate.kt)

[二三树的定义](src/main/kotlin/io/intellij/dsa/tree/twothree/TTTree.kt)
和 [二三树的实现](src/main/kotlin/io/intellij/dsa/tree/twothree/TTTreeImpl.kt)

- 插入操作，二三树会将新节点插入到一个叶子节点上，并可能需要分裂出父节点
- 删除操作，二三树会将一个节点删除，并可能需要合并或借用兄弟节点的值

红黑树：红黑树是4阶B树 (`2-3-4`树)的变体

左偏红黑树：左偏红黑树是红黑树的一种变体，它的对红边（点）的位置做了一定限制，使得其插入与删除操作可以与 2-3 树构成一一对应

AA树：AA 树是红黑树的一种变体，与红黑树不同，AA 树上的红色节点只能作为右子节点。这导致 AA 树模拟了 2-3 树

### 压缩

[Huffman Tree](src/main/kotlin/io/intellij/dsa/tree/huffman/HuffmanImpl.kt)

## 图

### 定义

[图的定义](src/main/kotlin/io/intellij/dsa/graph/Graph.kt)

[顶点和边的定义](src/main/kotlin/io/intellij/dsa/graph/VertexEdge.kt)

[稠密图 使用 邻接矩阵](src/main/kotlin/io/intellij/dsa/graph/impl/DenseGraph.kt)

[稀疏图 使用 邻接表](src/main/kotlin/io/intellij/dsa/graph/impl/SparseGraph.kt)

### 算法

**[图中的算法](src/main/kotlin/io/intellij/dsa/graph/compute)**

[图的遍历](src/main/kotlin/io/intellij/dsa/graph/compute/Traverse.kt)

- 深度优先遍历 `dfs`
- 广度优先遍历 `bfs`

[无向图联通分量](src/main/kotlin/io/intellij/dsa/graph/compute/Components.kt)

[有向无环拓扑排序](src/main/kotlin/io/intellij/dsa/graph/compute/TopoSort.kt)

- `Kahn` 算法：筛选入度为0的顶点 + 队列 + BFS

[最小生成树](src/main/kotlin/io/intellij/dsa/graph/compute/Mst.kt)

- `LazyPrim`算法：深度优先遍历 + 切分
- `Kruskal`算法：最小堆 + 并查集 + 切分

[单源最短路径](src/main/kotlin/io/intellij/dsa/graph/compute/Dijkstra.kt)

- 思路：局部最优更新到全局最优

[环分析](src/main/kotlin/io/intellij/dsa/graph/compute/CycleAnalyzer.kt)
