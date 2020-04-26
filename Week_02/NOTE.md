## Week02 学习笔记



### 每日一题

#### 4-20 题目：

* [299. 猜数字游戏](https://leetcode-cn.com/problems/bulls-and-cows/)

* [290. 单词规律](https://leetcode-cn.com/problems/word-pattern/)

前者是在上周的google面经的原题。大家好好练习，按照五毒神掌来。

学有余力的同学可以再做一遍[移动0](https://leetcode-cn.com/problems/move-zeroes/)问题

#### 4-21 题目：

* [350. 两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)
* [392. 判断子序列](https://leetcode-cn.com/problems/is-subsequence/)

前面两个是简单题，第三个是中等。

#### 4-22 题目：

* [1021. 删除最外层的括号](https://leetcode-cn.com/problems/remove-outermost-parentheses/)
* [面试题59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

经典题，多做

#### 4-23 题目：

- [412. Fizz Buzz](https://leetcode-cn.com/problems/fizz-buzz/)
- [258. 各位相加](https://leetcode-cn.com/problems/add-digits/)
- [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

今天的差不多都是软柿子；让大家可以轻松一下。

#### 4-24 题目： 

大家学习和实践一下，别怕！

- [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
- [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
- [559. N叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/)
- [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)

#### 4-25 题目：

* [面试题 01.08. 零矩阵](https://leetcode-cn.com/problems/zero-matrix-lcci/)
* [1200. 最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference/)
* [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)

#### 4-26 题目：

* [75. 颜色分类](https://leetcode-cn.com/problems/sort-colors/)
* [23. 合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

两个都是经典高频面试题目（第一个有出现在字节跳动和百度的面试）；后者也是今天leetcode上的官方每日一题。



### HashMap

HashMap初始化默人大小为16（1 << 4），最大容量为2^30^（1 << 30）。

loadFactor 默人负载因子 0.75。

```java
/**
 * The default initial capacity - MUST be a power of two.
 */
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

/**
 * The maximum capacity, used if a higher value is implicitly specified
 * by either of the constructors with arguments.
 * MUST be a power of two <= 1<<30.
 */
static final int MAXIMUM_CAPACITY = 1 << 30;

/**
  * The load factor used when none specified in constructor.
  */
static final float DEFAULT_LOAD_FACTOR = 0.75f;
```



当集合中当前元素数量达到 ++size > threshold（capacity * load factor），自动扩容。

Java 1.7 以前 HashMap 由线性表和链表组成，Java 1.8 改为当链表长度达到一定程度时将链表转化为红黑树。

```java
// 树化阈值为8
static final int TREEIFY_THRESHOLD = 8;

// 当树中节点小于6时，将树还原为链表
static final int UNTREEIFY_THRESHOLD = 6;
```

在 Java1.7 时多线程情况下扩容时容易出现链表环，或者数据丢失。

在 Java1.8 版本，多线程情况下扩容容易出现数据覆盖。

#### put() 方法

```java 
public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
```

调用自身的<code>final V putVal()</code> 方法，如果当前键值对存在，则更新当前 key 对应的 value 值，并返回愿来的 value。如果不存在创建键值对并添加到集合中，并返回 null。

#### get() 方法

```java
public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
```

get() 方法调用自身的<code>final Node<K,V> getNode()</code>方法，先找到相同 hashcode 的 key，然后依次遍历寻找真正的 key，找到指定的 Node，返回 value；未找到则返回 null。

#### getOrDefault() 方法

```java
@Override
    public V getOrDefault(Object key, V defaultValue) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? defaultValue : e.value;
    }
```

同 get() 方法，但如果未找到则返回 defaultValue。