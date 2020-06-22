# Week 09 学习笔记

👉 [week 09 code](./week09code)

👉 [每日一题](./week09code/daily)

## 第 19 课｜高级动态规划

高级动态规划也还是动态规划，依然需要状态转移方程和存储中间状态，依然要找**重复子问题**。无非是纬度更高（二维、三维甚至需要压缩），状态方程更复杂。

## 第 20 课｜字符串算法

说算法之前说说 Java 的字符串吧

String、StringBuffer 和 StringBuilder

String 被 final 修饰，典型的不可变对象（这里并不是说 final 修饰的类就是 immutable，这就是另一个话题了。）

StringBuffer 是可以修改，线程安全的 String。

StringBuilder 是非线程安全的 StringBuffer。



String 类的常用方法：

- indexOf()：返回指定字符的索引。
- charAt()：返回指定索引处的字符。
- replace()：字符串替换。
- trim()：去除字符串两端空白。
- split()：分割字符串，返回一个分割后的字符串数组。
- getBytes()：返回字符串的 byte 类型数组。
- length()：返回字符串长度。// 数组的长度是属性。
- toLowerCase()：将字符串转成小写字母。
- toUpperCase()：将字符串转成大写字符。
- substring()：截取字符串。
- equals()：字符串比较。



KMP