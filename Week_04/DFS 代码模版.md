## DFS 代码模版

### 递归写法

Java

```java
public void dfs(TreeNode node, Set hs) {
    // 终止条件
    if (hs.contains(node)) {
        return;
    }
    
    hs.add(node);
    
    // 处理当前节点
    for (int i = 0; i < hs.size(); ++i) {
        if (node.next != null) {
            dfs(node.next, hs);
        }
    }
    
}
```



python

```python
visited = set() 

def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```



### 非递归写法

Java

```java
private Set<Node> visited = new HashSet<>();
private Deque<Node> dq = new Deque<>();
public void dfs(TreeNode currentNode, Node target) {
    if (currentNode == null) {
        return;
    }
    dq.add(currentNode);
    while (!dq.isEmpty) {
        Node temp = dq.remove();
        visited.add(temp);
        // process(temp);
        nodes = node.next;
        dq.add(nodes);
    }
    
}
```



python

```python
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

