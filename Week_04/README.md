# Week 04 学习笔记

👉 [week 01 code](https://github.com/Gamig0/algorithm008-class01/tree/master/Week_04/week04code)

👉 [每日一题](https://github.com/Gamig0/algorithm008-class01/tree/master/Week_04/week04code/daily)

## DFS & BFS

深度优先搜索（deep first search）逐个分支依次遍历到最深处再回溯

广度优先搜索（breadth first search）遍历离当前节点最近的节点，并依次遍历。

不论是 DFS 还是 BFS 再遍历图结构是要使用 Set 集合保证每个节点只遍历一次

[**DFS代码模版**](https://github.com/Gamig0/algorithm008-class01/blob/master/Week_04/DFS%20%E4%BB%A3%E7%A0%81%E6%A8%A1%E7%89%88.md)

[**BFS代码模版**](https://github.com/Gamig0/algorithm008-class01/blob/master/Week_04/BFS%20%E4%BB%A3%E7%A0%81%E6%A8%A1%E7%89%88.md)



## 贪心算法 Greedy

把大问题拆分成许多小问题，每次只寻找局部最优解，已得到全剧最优解。

可以通过贪心算法解决的问题，贪心算法通常都是这个问题的最优解。贪心算法也可用做辅助算法或直接解决一些结果要求不精确的问题。

> 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不 能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行 选择，有回退功能。 
>
> [动态规划](https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92)



## 二分查找

#### 二分查找前提

1. 目标函数单调性（函数单调递增或者单调递减）
2. 边界条件，特殊值处理（bounded）
3. 可通过索引直接访问（index accessible）

**二分查找代码模版**

