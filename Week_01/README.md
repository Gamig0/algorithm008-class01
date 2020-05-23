# Week01 学习笔记

👉 [**week 01 code**](https://github.com/Gamig0/algorithm008-class01/tree/master/Week_01/week01code)

👉 [**每日一题**](https://github.com/Gamig0/algorithm008-class01/tree/master/Week_01/week01code/daily)



### 数组和链表时间复杂度对比

| 操作    | 数组 | 链表 |
| ------- | ---- | ---- |
| prepend | O(n) | O(1) |
| append  | O(1) | O(1) |
| lookup  | O(1) | O(n) |
| insert  | O(n) | O(1) |
| delete  | O(n) | O(1) |



### Java 中 ArrayList 和 LinkedList 对比

ArrayList 和 LinkedList 新增或删除元素操作测试从集合头部、中间位置以及尾部位置新增元素消耗的时间

* ArrayList > LinkedList
* ArrayList < LinkedList
* ArrayList < LinkedList

ArrayList 和 LinkedList 遍历元素操作测试 for(;;) 循环迭代器迭代循环消耗的时间

* ArrayList < LinkedList
* ArrayList ≈ LinkedList

ArrayList 是基于数组实现，LinkedList 是基于链表实现（JDK 1.7 有重大变化）

在头部新增元素，ArrayList 在不需要扩容的情况下需要复制整个原来的数组，而 LinkedList 只需要 new 一个节点加在头指针前面就可以了。而在中间和尾部新增元素为什么是 ArrayList 快呢？因为 LinkedList 每次新增元素时需要先找到目标位置，也就是说每次都需要遍历半个链表。而 ArrayList 在不扩容的情况下只需要通过 System.arraycopy 方法复制一段数组，再把目标元素放到目标位置。在尾部新增元素都是直接增加一个元素，在不需要扩容的情况下当然是 ArrayList 比 LinkedList 快一点。

 删除元素和新增元素道理相同（删除元素一定不会导致扩容），再次就不多赘述了。 

LinkedList 的 for 循环性能是最差的，而 ArrayList 的 for 循环性能是最好的。这是因为 LinkedList 基于链表实现的，在使用 for 循环的时候，每一次 for 循环都会去遍历半个 List，所以严重影响了遍历的效率；ArrayList 则是基于数组实现的，并且实现了 RandomAccess 接口标志（意味着 ArrayList 可以实现快速随机访问），所以 for 循环效率非常高。 LinkedList 的迭代循环遍历和 ArrayList 的迭代循环遍历性能相当，也不会太差，所以在遍历 LinkedList 时，要切忌使用 for 循环遍历。 

当你对以上两个集合使用 foreach 进行遍历时，如果在遍历对过程中直接使用集合的 remove 方法会引发 ConcurrentModificationException（并发修改异常）。 这是因为 foreach 循环是 Java 8 出现的语法糖，集合使用这个语法糖会被解释成迭代器，而集合内部又一个 int 类型的属性 modCount 用来记录 集合修改次数；迭代器内部保存了一个 expectedModCount 记录集合期望修改的次数。如果遍历过程中对集合进行修改会导致集合的 modCount 改变，没有同步给 expectedModCount 进而导致 modCount != expectedModCount，引发异常。  所以遍历时想要修改元素要使用 iterator 中的 remove方法。

[参考极客时间专栏](https://time.geekbang.org/column/article/98145)



### 作业

- [ ] 用 add first 或 add last 这套新的 API 改写 Deque 的代码

- [ ] 分析 Queue 和 Priority Queue 的源码





> 深切体会到小魔王所说的四步切题和**五毒神掌**。
>
> 方法很重要。
>
> 刻意练习很重要。
>
> 刷题时应该把重点放在如何找到答案而非答案是什么。
>
> 本周总计共刷了 13 道算法题，时间控制的不好。做某些题时一开始是有思路的，大概想了一下就开始写，写着好了调试发现有 bug 或者有没有考虑到的地方再继续改，反复几次，最后虽然是通过自己努力做出来的，但也已经浪费了好多时间。。。
>
> 质量和数量不可兼得，不能贪多。
>
> 
>
> 第一周先立下 Flag：
>
> 训练营结束前刷 70+ 题目，每道题至少刷 5 遍。
>
> 希望以后回想起这段时光是欣慰而不是后悔，希望在未来回想起来会感谢现在正在努力的自己。
>
> 努力！奋斗！

