# Week 08 学习笔记

👉 [week 08 code](./week08code)

👉 [每日一题](./week08code/daily)



## 第 16 课｜位运算

计算机使用二进制（补码）形式记录数据。

### 二进制基本操作

与 &

或 |

非 ~

异或 ^

### 常见骚操作

左移 \<<    和 *2 等效

右移 \>>    和 /2 等效

无符号右移 \>>

判断奇偶： x&1 == 1

### 指定位置的位运算

将 x 最右边的 n 位清零：x&(~0<<n)

获取 x 的第 n 位值（0 或 1）：(x>>n)&1

获取 x 的第 n 位的幂值：x&(1<<n)



## 第 17 课｜布隆过滤器（Bloom Filter）

由二进制数组和什么构成，消耗内存空间少，常用于缓存，能快速判断元素是否在集合中。如果存在于布隆过滤器中则有可能存在；如果不存在于布隆过滤器中则一定不存在。

👉 [布隆过滤器原理的实现](https://www.cnblogs.com/cpselvis/p/6265825.html)

👉 [布隆过滤器具体应用](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)

👉 布隆过滤器代码模版 Python

👉 [布隆过滤器的实现 Python](https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/)

👉 [布隆过滤器的 Java 实现示例](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)

👉 [布隆过滤器的 Java 实际应用示例](https://github.com/Baqend/Orestes-Bloomfilter)



## LRU 缓存

Least recently used 最近最少使用。在 Java 中通常使用 HashMap + 双向链表实现。

👉 [Understanding the Meltdown exploit](https://www.sqlpassion.at/archive/2018/01/06/understanding-the-meltdown-exploit-in-my-own-simple-words/)

👉 [替换算法们](https://en.wikipedia.org/wiki/Cache_replacement_policies)

👉 [LRU Cache Python 代码示例](https://shimo.im/docs/tTxRkGwJpXG6WkGY/)



## 第 18 课｜排序算法

👉 [十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)

