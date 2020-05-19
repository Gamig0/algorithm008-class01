# Week02 学习笔记

👉 [week 02 code](https://github.com/Gamig0/algorithm008-class01/tree/master/Week_02/week02code)

👉 [每日一题](https://github.com/Gamig0/algorithm008-class01/tree/master/Week_02/week02code/daily)



### 集合常用方法

Map：key-value对，key不重复 

- new HashMap() / new TreeMap() 
- map.set(key, value)  
- map.get(key) 
- map.has(key) 
- map.size() 
- map.clear()

Set：不重复元素的集合 - new HashSet() / new TreeSet() 

- set.add(value) 
- set.delete(value) 
- set.hash(value) 



![复杂度分析](https://github.com/Gamig0/algorithm008-class01/blob/master/Week_02/复杂度分析.jpeg)



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

[一篇 HashMap 的短文](https://shimo.im/docs/DHC3drQrCKRxrcRC)



[堆（Heap）的实现](https://github.com/Gamig0/algorithm008-class01/blob/master/Week_02/week02code/BinaryHeap.java)

