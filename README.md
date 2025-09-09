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
    * [跳表](#跳表)
    * [哈夫曼树](#哈夫曼树)
    * [树套树](#树套树)
  * [图](#图)
    * [定义](#定义)
    * [算法](#算法)
  * [工程算法常用实践](#工程算法常用实践)
    * [缓存与存储](#缓存与存储)
    * [并发与任务调度](#并发与任务调度)
    * [网络与分布式](#网络与分布式)
    * [搜索与推荐](#搜索与推荐)
    * [其他高频实践](#其他高频实践)
<!-- TOC -->

## 动态规划

[Dynamic Programming](basic/dynamic_programming.md)

## 排序

[排序的定义](basic/src/main/kotlin/io/intellij/dsa/sort/Sort.kt)

### O(n^2)

[选择排序](basic/src/main/kotlin/io/intellij/dsa/sort/impl/SelectSort.kt)

[插入排序](basic/src/main/kotlin/io/intellij/dsa/sort/impl/InsertSort.kt)

### O(nlog(n))

[归并排序](basic/src/main/kotlin/io/intellij/dsa/sort/impl/MergeSort.kt)

[快速排序](basic/src/main/kotlin/io/intellij/dsa/sort/impl/QuickSort.kt)

## 查找

### 并查集

[并查集的定义](basic/src/main/kotlin/io/intellij/dsa/uf/UnionFind.kt)

- [基于索引的并查集](basic/src/main/kotlin/io/intellij/dsa/uf/IndexedUnionFind.kt)
- [基于树的并查集 连接对象本身](basic/src/main/kotlin/io/intellij/dsa/uf/TreeUnionFind.kt)
  - 对象本身可对比
- [基于树的并查集 连接对象的唯一标识](basic/src/main/kotlin/io/intellij/dsa/uf/TreeIdUnionFind.kt)
  - 唯一标识可对比

### 堆

[堆的定义](basic/src/main/kotlin/io/intellij/dsa/tree/heap/Heap.kt)

[堆的实现](basic/src/main/kotlin/io/intellij/dsa/tree/heap/HeapImpl.kt)

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

> 查询时间复杂度为 $\mathrm{O} \log\mathrm{(N)}$

[二分搜索树定义](basic/src/main/kotlin/io/intellij/dsa/tree/bst/BST.kt)

- [节点定义](basic/src/main/kotlin/io/intellij/dsa/tree/bst/BSTNode.kt)

[基础二分搜索树实现](basic/src/main/kotlin/io/intellij/dsa/tree/bst/BasicBST.kt)

[AVL平衡树实现](basic/src/main/kotlin/io/intellij/dsa/tree/bst/AVLTree.kt)

- 基于 `height` 计算 `balance factor` 旋转平衡
  - `height`: 节点的高度，即从该节点到叶子节点的最长路径长度
- [旋转操作: LL RR LR RL](basic/src/main/kotlin/io/intellij/dsa/tree/bst/AVLRotate.kt)

[二三树的定义](basic/src/main/kotlin/io/intellij/dsa/tree/twothree/TTTree.kt)
和 [二三树的实现](basic/src/main/kotlin/io/intellij/dsa/tree/twothree/TTTreeImpl.kt)

- 插入操作，二三树会将新节点插入到一个叶子节点上，并可能需要分裂出父节点
- 删除操作，二三树会将一个节点删除，并可能需要合并或借用兄弟节点的值

红黑树：红黑树是4阶B树 (`2-3-4`树)的变体

左偏红黑树：左偏红黑树是红黑树的一种变体，它的对红边（点）的位置做了一定限制，使得其插入与删除操作可以与 2-3 树构成一一对应

AA树：AA 树是红黑树的一种变体，与红黑树不同，AA 树上的红色节点只能作为右子节点。这导致 AA 树模拟了 2-3 树

### 跳表

> 概率数据结构

时间复杂度基于产生的索引层数的概率 $\mathrm{p} : \mathrm{O}(\log_{\frac{1}{p}}\mathrm{(N)})$

跳表是对有序链表的改进

[跳表的定义](basic/src/main/kotlin/io/intellij/dsa/skiplist/SkipList.kt)

[跳表的实现](basic/src/main/kotlin/io/intellij/dsa/skiplist/SkipListImpl.kt)

跳表插入删除实现的核心

- 对于插入元素：找到要插入的元素的前驱节点
  - 前驱节点的个数取决于插入的元素随机出来的层数
  - 前驱节点值本质上都会小于当前节点
  - 更新前驱节点的指向，和新增节点的指向
  - 如果是相同值，直接更新返回
  - 基于新元素更新当前跳表的高度
- 对于删除元素，找到要删除的元素的前驱节点
  - 前驱节点的个数取决于有多少节点指向当前
  - 如果没有任何前驱节点，直接返回
  - 更新前驱节点的指向，删除当前节点
  - 更新跳表高度的时候根据哨兵(`head`)节点更新

### 哈夫曼树

> 一种带权路径长度最短的二叉树，主要用于压缩

[Huffman Tree](basic/src/main/kotlin/io/intellij/dsa/tree/huffman/HuffmanImpl.kt)

### 树套树

[Trie](basic/src/main/kotlin/io/intellij/dsa/tree/trie/TrieImpl.kt)

Trie 是一种典型的树套树的实现

- 对于本身的结构，是树形展开
- 对于同一层的查询，需要用的查询树(ps: 利用哈希表也可以)
  - 如果哈希表数据量很庞大，最终的性能约束还是落在了查询上

## 图

### 定义

[图的定义](basic/src/main/kotlin/io/intellij/dsa/graph/Graph.kt)

[顶点和边的定义](basic/src/main/kotlin/io/intellij/dsa/graph/VertexEdge.kt)

[稠密图 使用 邻接矩阵](basic/src/main/kotlin/io/intellij/dsa/graph/impl/DenseGraph.kt)

[稀疏图 使用 邻接表](basic/src/main/kotlin/io/intellij/dsa/graph/impl/SparseGraph.kt)

### 算法

**[图中的算法](basic/src/main/kotlin/io/intellij/dsa/graph/compute)**

[图的遍历](basic/src/main/kotlin/io/intellij/dsa/graph/compute/Traverse.kt)

- 深度优先遍历 `dfs`
- 广度优先遍历 `bfs`

[无向图联通分量](basic/src/main/kotlin/io/intellij/dsa/graph/compute/Components.kt)

[有向无环拓扑排序](basic/src/main/kotlin/io/intellij/dsa/graph/compute/TopoSort.kt)

- `Kahn` 算法：筛选入度为0的顶点 + 队列 + BFS

[最小生成树](basic/src/main/kotlin/io/intellij/dsa/graph/compute/Mst.kt)

- `LazyPrim`算法：深度优先遍历 + 切分
- `Kruskal`算法：最小堆 + 并查集 + 切分

[单源最短路径](basic/src/main/kotlin/io/intellij/dsa/graph/compute/Dijkstra.kt)

- 思路：局部最优更新到全局最优

[环分析](basic/src/main/kotlin/io/intellij/dsa/graph/compute/CycleAnalyzer.kt)

## 工程算法常用实践

### 缓存与存储

LRU / LFU / ARC —— 缓存淘汰策略（操作系统缓存、Redis、Guava Cache）。

一致性哈希 —— 分布式缓存、分库分表、负载均衡。

布隆过滤器（Bloom Filter） —— 大数据场景下的快速存在性判断（爬虫 URL 去重、黑名单过滤）。

跳表（SkipList） —— Redis Sorted Set 的底层数据结构。

B+ 树 / B 树 —— 数据库和文件系统的索引结构。

LSM 树 —— LevelDB、RocksDB、HBase 等存储引擎。

### 并发与任务调度

令牌桶 / 漏桶算法 —— 限流、流量控制（API 网关）。

优先队列 / 小顶堆 —— 定时任务调度、任务优先级处理。

工作窃取算法（Work Stealing） —— 并行计算任务调度（Java ForkJoinPool、Go 调度器）。

CAS / 自旋锁 —— 高并发环境下的乐观锁。

协程调度算法 —— Golang、Kotlin 协程的任务切换策略。

### 网络与分布式

Raft / Paxos —— 分布式一致性协议（Etcd、ZooKeeper）。

Gossip 协议 —— 分布式系统中节点状态传播（Cassandra、Consul）。

背压（Backpressure）算法 —— 消息队列、流式处理防止堆积（Kafka、RxJava）。

Hystrix 熔断算法 —— 服务治理中的快速失败与恢复。

### 搜索与推荐

倒排索引（Inverted Index） —— 搜索引擎核心（Elasticsearch、Lucene）。

PageRank —— 网页排名与推荐系统。

LSH（局部敏感哈希）/ MinHash —— 相似度搜索、去重。

余弦相似度 / Jaccard 相似度 —— 推荐系统、文本去重。

### 其他高频实践

环形缓冲区（Ring Buffer） —— 高性能队列（Disruptor、Netty）。

一致性快照（Snapshotting） —— 数据库和分布式系统恢复点。

动态规划（Diff、编辑距离） —— Git diff、文本比较。

LRU-K / LFU-K —— 数据库缓存管理（Oracle、Postgres）。

Skip Merge / Compaction —— LSM 树存储引擎中的合并算法。
